/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.rss.feedWriter;

import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import online.solution.rss.Feed;
import online.solution.rss.FeedMessage;

/**
 * 
 * @author Bhushankumar
 */
public class RSSFeedWriter {

	private final String outputFile;
	private final Feed rssFeed;

	public RSSFeedWriter(String outputFile, Feed rssFeed) {
		this.outputFile = outputFile;
		this.rssFeed = rssFeed;
	}

	public void write() throws Exception {
		try {

			XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();

			XMLEventWriter eventWriter;
			FileOutputStream stream = new FileOutputStream(outputFile);
			eventWriter = outputFactory.createXMLEventWriter(stream);

			XMLEventFactory eventFactory = XMLEventFactory.newInstance();

			XMLEvent newLine = eventFactory.createDTD("\n");
			XMLEvent tab = eventFactory.createDTD("\t");

			StartDocument startDocument = eventFactory.createStartDocument();
			// eventWriter.add(eventFactory.createAttribute("encoding",
			// "ISO-8859-1\\"));
			eventWriter.add(startDocument);
			eventWriter.add(newLine);

			StartElement rssElement = eventFactory.createStartElement("", "",
					"rss");
			eventWriter.add(rssElement);
			eventWriter.add(eventFactory.createAttribute("version", "2.0"));
			eventWriter.add(eventFactory.createAttribute("xmlns:atom",
					"http://www.w3.org/2005/Atom"));
			eventWriter.add(newLine);
			eventWriter.add(newLine);

			eventWriter.add(eventFactory.createStartElement("", "", "channel"));
			eventWriter.add(newLine);
			eventWriter.add(tab);

			StartElement atomElement = eventFactory.createStartElement("", "",
					"atom:link");
			eventWriter.add(atomElement);
			eventWriter.add(eventFactory.createAttribute("href",
					"http://dallas.example.com/rss.xml"));
			eventWriter.add(eventFactory.createAttribute("rel", "self"));
			eventWriter.add(eventFactory.createAttribute("type",
					"application/rss+xml"));
			eventWriter.add(eventFactory.createEndElement("", "", "atom:link"));
			eventWriter.add(newLine);

			/*
			 * StartElement atom = eventFactory.createStartElement("", "",
			 * "atom:link"); eventWriter.add(newLine); eventWriter.add(atom);
			 * 
			 * eventWriter.add(newLine);
			 * 
			 * 
			 * EndElement end = eventFactory.createEndElement("", "",
			 * "atom:link"); eventWriter.add(end); eventWriter.add(end);
			 */
			// eventWriter.add(eventFactory.createEndElement("", "",
			// "atom:link"));

			createNode(eventWriter, "title", rssFeed.getTitle());

			createNode(eventWriter, "link", rssFeed.getLink());

			createNode(eventWriter, "description", rssFeed.getDescription());

			createNode(eventWriter, "language", rssFeed.getLanguage());

			createNode(eventWriter, "copyright", rssFeed.getCopyright());
			eventWriter.add(newLine);
			eventWriter.add(tab);
			eventWriter.add(tab);

			for (FeedMessage entry : rssFeed.getMessages()) {
				eventWriter
						.add(eventFactory.createStartElement("", "", "item"));

				eventWriter.add(newLine);
				eventWriter.add(tab);
				eventWriter.add(tab);

				createNode(eventWriter, "title", entry.getTitle());
				eventWriter.add(tab);
				eventWriter.add(tab);
				createNode(eventWriter, "description", entry.getDescription());
				eventWriter.add(tab);
				eventWriter.add(tab);
				createNode(eventWriter, "link", entry.getLink());
				eventWriter.add(tab);
				eventWriter.add(tab);
				createNode(eventWriter, "author", entry.getAuthor());
				eventWriter.add(tab);
				eventWriter.add(tab);

				eventWriter.add(eventFactory.createEndElement("", "", "item"));
				eventWriter.add(newLine);
			}

			eventWriter.add(newLine);
			eventWriter.add(eventFactory.createEndElement("", "", "channel"));
			eventWriter.add(newLine);
			eventWriter.add(newLine);
			eventWriter.add(eventFactory.createEndElement("", "", "rss"));

			eventWriter.add(eventFactory.createEndDocument());
			eventWriter.close();
			stream.close();
		} catch (Exception e) {
			System.out.println("Exception in RSSFeedWriter - >" + e);
			throw new Exception(e.getMessage());
		} finally {
		}
	}

	public void createNode(XMLEventWriter eventWriter, String name, String value)
			throws Exception {
		try {
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			XMLEvent end = eventFactory.createDTD("\n");
			XMLEvent tab = eventFactory.createDTD("\t");

			StartElement startElement = eventFactory.createStartElement("", "",
					name);
			eventWriter.add(tab);
			eventWriter.add(startElement);

			Characters characters = eventFactory.createCharacters(value);
			eventWriter.add(characters);

			EndElement endElement = eventFactory.createEndElement("", "", name);
			eventWriter.add(endElement);
			eventWriter.add(end);
		} catch (Exception e) {
			System.out.println("Exception in RSSFeedWriter - >" + e);
			throw new Exception(e.getMessage());
		} finally {
		}
	}
}
