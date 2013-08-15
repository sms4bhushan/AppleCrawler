/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.sitemap.writer;

import online.solution.sitemap.SiteMapElement;
import online.solution.sitemap.SiteMapNode;

/**
 * 
 * @author Bhushankumar
 */
public class SiteMapWriterTest {

	public void test(String path) throws Exception {
		try {
			SiteMapNode node = new SiteMapNode();

			// Now add one example entry
			SiteMapElement element = new SiteMapElement();
			element.setLoc("http://www.example.com/");
			element.setLastmod("2013-01-01");
			element.setChangefreq("monthly");
			element.setPriority("0.8");

			node.getMessages().add(element);

			SiteMapWriter writer = new SiteMapWriter(path, node);
			writer.siteMapwrite();

		} catch (Exception e) {
			System.out.println("Exception in WriteTest -> " + e);
			throw new Exception(e.getMessage());
		} finally {
		}
	}
}
