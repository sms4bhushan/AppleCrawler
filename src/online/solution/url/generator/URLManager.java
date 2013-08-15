/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.url.generator;

import java.util.HashSet;

/**
 * 
 * @author Bhushankumar
 */
public class URLManager {

	public String getNextUrl(HashSet<String> toBeCrawl) {
		String nextUrl = "";
		try {
			nextUrl = toBeCrawl.iterator().next();
			// System.out.println("Nexturl -> " + nextUrl);
			toBeCrawl.remove(nextUrl);
			return nextUrl;
		}
		catch (Exception exception) {
			System.out.println("Exception getNextUrl->" + exception);
			toBeCrawl.remove(nextUrl);
			return nextUrl;
		}

	}

	public HashSet<String> addNewSingleUrl(HashSet<String> toBeCrawl, String newUrl) {
		toBeCrawl.add(newUrl);
		return toBeCrawl;
	}

	public HashSet<String> addNewMultipleUrl(HashSet<String> toBeCrawl, HashSet<String> newUrlList) {
		toBeCrawl.addAll(newUrlList);
		return toBeCrawl;
	}

	private String parentUrl;

	public String getParentUrl() {
		return parentUrl;
	}

	public void setParentUrl(String parentUrl) {
		this.parentUrl = parentUrl;
	}
}
