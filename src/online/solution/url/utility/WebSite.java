/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.url.utility;

/**
 * 
 * @author Bhushankumar
 */
public class WebSite {

	private String websiteName;
	private String websitePrefix;

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
		setWebsitePrefix();
	}

	public String getWebsitePrefix() {
		return websitePrefix;
	}

	private void setWebsitePrefix() {
		String[] prefix = getWebsiteName().split("\\.");
		if (prefix != null) {
			StringBuilder p = new StringBuilder();
			for (String string : prefix) {
				p.append(string).append(".");
			}
			p.deleteCharAt(p.length() - 1);
			// p.append(prefix[0]).append(".").append(prefix[1]).append(".").append(prefix[2]);
			this.websitePrefix = p.toString();
			System.out.println("I am prefix ----> " + websitePrefix);
		} else {
			System.out.println("I am empty");
		}
	}
}
