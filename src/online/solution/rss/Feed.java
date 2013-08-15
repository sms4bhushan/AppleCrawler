/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.rss;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Bhushankumar
 */
public class Feed {

	final String title;
	final String link;
	final String description;
	final String language;
	final String copyright;
	final List<FeedMessage> messages = new ArrayList<FeedMessage>();

	public List<FeedMessage> getMessages() {
		return messages;
	}

	public Feed(String title, String link, String description, String language,
			String copyright) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.copyright = copyright;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public String getCopyright() {
		return copyright;
	}

	@Override
	public String toString() {
		return "Feed [copyright=" + copyright + ", description=" + description
				+ ", language=" + language + ", link=" + link + "title="
				+ title + "]";
	}
}
