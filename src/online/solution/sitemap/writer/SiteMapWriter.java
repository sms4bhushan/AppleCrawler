/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.sitemap.writer;

import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import online.solution.sitemap.SiteMapElement;
import online.solution.sitemap.SiteMapNode;

/**
 * 
 * @author Bhushankumar
 */
public class SiteMapWriter {

	private final String outputFile;
	private final online.solution.sitemap.SiteMapNode rssFeed;

	public SiteMapWriter(String outputFile, SiteMapNode rssFeed) {
		this.outputFile = outputFile;
		this.rssFeed = rssFeed;
	}

	public void siteMapwrite() throws Exception {
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
					"urlset");
			eventWriter.add(rssElement);

			eventWriter.add(eventFactory.createAttribute("xmlns",
					"http://www.sitemaps.org/schemas/sitemap/0.9"));
			eventWriter.add(newLine);
			eventWriter.add(newLine);

			// eventWriter.add(eventFactory.createStartElement("", "",
			// "channel"));
			// eventWriter.add(newLine);
			eventWriter.add(tab);

			/*
			 * StartElement atomElement = eventFactory.createStartElement("",
			 * "", "atom:link"); eventWriter.add(atomElement);
			 * eventWriter.add(eventFactory.createAttribute("href",
			 * "http://dallas.example.com/rss.xml"));
			 * eventWriter.add(eventFactory.createAttribute("rel", "self"));
			 * eventWriter.add(eventFactory.createAttribute("type",
			 * "application/rss+xml"));
			 * eventWriter.add(eventFactory.createEndElement("", "",
			 * "atom:link")); eventWriter.add(newLine);
			 * 
			 * createNode(eventWriter, "title", rssFeed.getTitle());
			 * 
			 * createNode(eventWriter, "link", rssFeed.getLink());
			 * 
			 * createNode(eventWriter, "description", rssFeed.getDescription());
			 * 
			 * createNode(eventWriter, "language", rssFeed.getLanguage());
			 * 
			 * createNode(eventWriter, "copyright", rssFeed.getCopyright());
			 * eventWriter.add(newLine); eventWriter.add(tab);
			 * eventWriter.add(tab);
			 */
			for (SiteMapElement entry : rssFeed.getMessages()) {
				eventWriter.add(eventFactory.createStartElement("", "", "url"));

				eventWriter.add(newLine);
				eventWriter.add(tab);
				// eventWriter.add(tab);

				createNode(eventWriter, "loc", entry.getLoc());
				eventWriter.add(tab);
				// eventWriter.add(tab);
				createNode(eventWriter, "lastmod", entry.getLastmod());
				eventWriter.add(tab);
				// eventWriter.add(tab);
				createNode(eventWriter, "changefreq", entry.getChangefreq());
				eventWriter.add(tab);
				// eventWriter.add(tab);
				createNode(eventWriter, "priority", entry.getChangefreq());
				eventWriter.add(tab);
				// eventWriter.add(tab);

				eventWriter.add(eventFactory.createEndElement("", "", "url"));
				eventWriter.add(newLine);
			}

			eventWriter.add(newLine);
			// eventWriter.add(eventFactory.createEndElement("", "",
			// "channel"));
			// eventWriter.add(newLine);
			// eventWriter.add(newLine);
			// eventWriter.add(eventFactory.createEndElement("", "", "rss"));

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
