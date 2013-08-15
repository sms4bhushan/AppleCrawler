/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.sitemap;

/**
 * 
 * @author Bhushankumar
 */
public class SiteMapElement {

	private String loc;
	private String lastmod;
	private String changefreq;
	private String priority;

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLastmod() {
		return lastmod;
	}

	public void setLastmod(String lastmod) {
		this.lastmod = lastmod;
	}

	public String getChangefreq() {
		return changefreq;
	}

	public void setChangefreq(String changefreq) {
		this.changefreq = changefreq;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "FeedMessage [location=" + loc + ", lastModification=" + lastmod
				+ ", changeFeque=" + changefreq + ", priority=" + priority
				+ " ]";
	}
}
