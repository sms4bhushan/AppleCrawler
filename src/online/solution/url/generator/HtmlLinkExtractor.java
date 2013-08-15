/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.url.generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import online.solution.url.brokenLink.CheckStatus;
import online.solution.url.utility.IsNull;
import online.solution.url.utility.UrlUtil;
import online.solution.url.utility.WebSite;

/**
 * 
 * @author Bhushankumar
 */
public class HtmlLinkExtractor {

	private Pattern patternTag, patternLink;
	private Matcher matcherTag, matcherLink;
	private static final String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
	private static final String HTML_A_HREF_TAG_PATTERN = "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";

	public HtmlLinkExtractor() {
		System.out.println("Default constructor initializrd...");
	}

	WebSite webSite = new WebSite();

	public HtmlLinkExtractor(String websiteName) {
		System.out.println("Main constructor initializrd...");
		webSite.setWebsiteName(websiteName);
		tempCurrentPageLink.add(websiteName);
		manager.addNewSingleUrl(allPageLink, websiteName);
		patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
		patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
	}

	private final URLManager manager = new URLManager();

	private boolean endFalg = true;

	@SuppressWarnings("finally")
	public ArrayList<HtmlLink> generateLink() {
		try {
			System.out.println(result.size() + "    Next link is -> " + endFalg);
			if (!endFalg) {
				return result;
			}
			if (allPageLink.size() > 0) {
				String newWebsite = manager.getNextUrl(allPageLink);
				System.out.println("Remainning links -> " + allPageLink.size());
				System.out.println("Next link is -> " + newWebsite);
				// boolean flag = CheckStatus.CheckUrl(newWebsite);
				// System.out.println("Remainning links -> " +
				// allPageLink.size());

				manager.setParentUrl(newWebsite);
				BufferedReader pageReader = null;
				pageReader = new BufferedReader(new InputStreamReader(new URL(newWebsite).openStream()));
				String s;
				StringBuilder pageContents = new StringBuilder();
				while ((s = pageReader.readLine()) != null) {
					// System.out.println("Line -> " + s);
					pageContents.append(s);
				}
				pageReader.close();

				if (pageContents.length() > 0) {
					// System.out.println("Page length -> " +
					// pageContents.length());
					// System.out.println("Size pageContents -> " +
					// pageContents.length());
					System.out.println("pageContents -> Total result Size before retiving-> " + result.size());
					grabHTMLLinks(result, pageContents.toString());
					System.out.println("pageContents -> Total result Size after retiving-> " + result.size());
				}
			}
			System.out.println("All url visiting is completed  -> " + allPageLink.size());
		}
		catch (Exception exception) {
			exception.printStackTrace(System.out);
			System.out.println("Exception generateLink -> " + exception);
			generateLink();
		}
		finally {
			return result;
		}
	}

	private HtmlLink htmlLink;
	private final ArrayList<HtmlLink> result = new ArrayList<HtmlLink>();
	private HashSet<String> allPageLink = new HashSet<String>();
	private HashSet<String> currentPageLink;
	private final HashSet<String> tempCurrentPageLink = new HashSet<String>();
	private String link = "";

	public void grabHTMLLinks(ArrayList<HtmlLink> result, final String html) throws Exception {
		try {
			// System.out.println("Inside grabHTMLLinks");
			currentPageLink = new HashSet<String>();
			matcherTag = patternTag.matcher(html);
			while (matcherTag.find()) {
				String linkText = matcherTag.group(2); // link text
				String href = matcherTag.group(1); // <a>
				matcherLink = patternLink.matcher(href);
				while (matcherLink.find()) {
					link = matcherLink.group(1).trim().toLowerCase(); // link
					htmlLink = new HtmlLink();

					if (IsNull.isNullValue(link) && link.length() > 2) {
						// Returns true if url to be skip
						// System.out.println(".......Old Link-> " + link);
						// System.out.println("tempCurrentPageLink.-> "+tempCurrentPageLink.size());
						if (tempCurrentPageLink.add(link) == true) {
							// System.out.println(".......Old Link-> " + link);
							// tempCurrentPageLink.add(link);
							if (UrlUtil.skipUrl(link) == false) {
								link = UrlUtil.removeDoubleQuato(link);
								link = UrlUtil.removeSingleQuato(link);
								link = UrlUtil.removeDoubleSlash(link);
								link = UrlUtil.removeSingleSlash(link);

								System.out.println(".......Old Link-> " + link);

								// System.out.println(".......webSite.getWebsitePrefix()-> "
								// + webSite.getWebsitePrefix());

								if (link.contains("/")) {
									link = UrlUtil.setPrefix(link, webSite.getWebsitePrefix());
								}
								else {
									// System.out.println("Prefix is := " +
									// manager.getParentUrl().lastIndexOf("/"));
									if (manager.getParentUrl().contains("/")) {
										String prefix = manager.getParentUrl().substring(0,
												manager.getParentUrl().lastIndexOf("/"));
										// System.out.println("Prefix is := "+prefix);
										link = UrlUtil.setPrefix(link, prefix);
									}
									else {
										link = UrlUtil.setPrefix(link, webSite.getWebsitePrefix());
									}
								}

								// System.out.println(".......after fix-> " +
								// link);

								link = UrlUtil.fixUrlPattern(link, webSite.getWebsiteName());// appdent
																								// http
								System.out.println(".......fixUrlPattern -> " + link);

								if (UrlUtil.urlValidator(link)) {
									// System.out.println("Removed -> " + link);
									currentPageLink.add(link);

									if (CheckStatus.CheckUrl(link)) {
										System.out.println("................New Link   -> " + link);
										htmlLink.setLink(link);
										htmlLink.setLinkText(linkText);
										result.add(htmlLink);
										System.out.println("Total result Size after added -> " + result.size());
										if (result.size() == -1) {
											endFalg = false;
											throw new Exception("Specified number of url is complete....");
										}
									}
									else {
										System.out.println("<<<<<<<----- Not added Link   -> " + link);
									}
								}
							}// tempMirrorLink.contains(link)
						}// Check for URL SKIP end...
					}// End of finder loop.
				}// End of matcher loop.
			}// System.out.println("Inside if mirrorLink.containsAll(currentPageLink)");
			System.out.println("Total result Size -> " + result.size());
			allPageLink = manager.addNewMultipleUrl(allPageLink, currentPageLink);
			generateLink();
			// return result;
		}
		catch (Exception exception) {
			System.out.println("grabHTMLLinks Exception -> " + exception);
			throw exception;
		}
		finally {
			// allPageLink.clear();
			// return result;
		}
	}
}
