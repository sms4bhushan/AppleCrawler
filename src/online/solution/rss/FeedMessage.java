/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.rss;

/**
 * 
 * @author Bhushankumar
 */
public class FeedMessage {

	String title;
	String description;
	String link;
	String author;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", description=" + description
				+ ", link=" + link + ", author=" + author + " ]";
	}
}
