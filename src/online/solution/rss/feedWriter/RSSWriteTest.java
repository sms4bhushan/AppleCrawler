/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.rss.feedWriter;

import online.solution.rss.Feed;
import online.solution.rss.FeedMessage;

/**
 * 
 * @author Bhushankumar
 */
public class RSSWriteTest {

	public void test(String path) throws Exception {
		try {
			String copyright = "Copyright hold by Lars Vogel";
			String title = "Eclipse and Java Information";
			String description = "Eclipse and Java Information";
			String language = "en";
			String link = "http://www.vogella.de";

			// Calendar cal = new GregorianCalendar();
			// Date creationDate = cal.getTime();
			// SimpleDateFormat date_format = new
			// SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z",
			// Locale.US);
			// String pubdate = date_format.format(creationDate);
			Feed rssFeeder = new Feed(title, link, description, language,
					copyright);

			// Now add one example entry
			FeedMessage feed = new FeedMessage();
			feed.setTitle("RSSFeed");
			feed.setDescription("This is a description");
			feed.setAuthor("nonsense@somewhere.de (Lars Vogel)");
			feed.setLink("http://www.vogella.de/articles/RSSFeed/article.html");

			rssFeeder.getMessages().add(feed);

			RSSFeedWriter writer = new RSSFeedWriter(path, rssFeeder);
			writer.write();

		} catch (Exception e) {
			System.out.println("Exception in WriteTest -> " + e);
			throw new Exception(e.getMessage());
		} finally {
		}
	}
}
