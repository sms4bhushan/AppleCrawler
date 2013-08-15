package online.solution.url.utility;

public class UrlUtil {

	public static boolean skipUrl(String link) {
		// System.out.println("before Removed #-> "+link);
		try {
			// Skip sRemove empty links
			if (link.trim().length() <= 0) {
				return true;
			}
			// Skip links that are just page anchors.
			if (link.contains("#")) {
				// System.out.println("Removed #-> " + link);
				return true;
			}

			if (link.contains("mailto:")) {
				// System.out.println("Removed mailto:-> " + link);
				return true;
			}
			// Skip JavaScript links.
			if (link.contains("javascript")) {
				// System.out.println("Removed javascript-> " + link);
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception exception) {
			System.out.println("Exception skipUrl -> " + exception);
			return false;
		}
		finally {
		}
	}

	public static String fixUrlName(String websiteName, String link) {
		StringBuilder name = new StringBuilder(websiteName);
		try {
			// /signin to //lad.wikipedia.org
			// System.out.println("link -> " + link);
			boolean dotFlag = false;
			String prefixDot[] = link.split("\\.");

			for (String item : prefixDot) {
				if (link.contentEquals(item)) {
					System.out.println("Inside if contentEquals(item) -> " + item);
					dotFlag = true;
					break;
				}
			}

			if (dotFlag) {
				// System.out.println(prefixDot[1] + link);
				return name.append("/").append(link).toString();
			}

			if (dotFlag) {
				String prefixSlash[] = websiteName.split("//");
				// boolean slashFlag;
				if (!link.contains(prefixSlash[1])) {
					// slashFlag = true;
					System.out.println(prefixSlash[1] + link);
					return name.append("/").append(link).toString();
				}
			}
			return link;
		}
		catch (Exception exception) {
			System.out.println("Exception fixUrlName -> " + exception);
			return link;
		}
		finally {
			// return name.toString();
		}
	}

	public static String fixUrlPattern(String link, String website) {
		try {
			if (!link.contains("http") && !link.contains("https")) {
				String prefix[] = website.split("//");
				return new StringBuilder(prefix[0]).append("//").append(link).toString();
			}
			else {
				return link;
			}
		}
		catch (Exception exception) {
			System.out.println("Exception fixUrlPattern -> " + exception);
			return link;
		}
		finally {
			// return name;
		}
	}

	public static String setPrefix(String link, String websitePrefix) {
		if (!link.contains(websitePrefix)) {
			String temp = new StringBuilder(websitePrefix).append("/").append(link).toString();
			// System.out.println("INside if"+temp);
			return temp;
		}
		else {
			// System.out.println("else part");
			return link;
		}
	}

	public static String removeDoubleQuato(String text) {
		try {
			if (text.contains("\"")) {
				// System.out.println("removeDoubleQuato from - >  "+text);
				if (text.startsWith("\"") || text.endsWith("\"")) {
					return text.split("\"")[1];
				}
				else {
					return text;
				}
			}
			else {
				return text;
			}
		}
		catch (Exception exception) {
			System.out.println(text + " ....Exception removeDoubleQuato -> " + exception);
			// exception.printStackTrace(System.out);
			return text;
		}
	}

	public static String removeSingleQuato(String text) {
		try {
			if (text.contains("'")) {
				// System.out.println("removeDoubleQuato from - >  "+text);
				if (text.startsWith("'") || text.endsWith("'")) {
					return text.split("'")[1];
				}
				else {
					return text;
				}
			}
			else {
				return text;
			}
		}
		catch (Exception exception) {
			System.out.println(text + " ....Exception removeSingleQuato -> " + exception);
			// exception.printStackTrace(System.out);
			return text;
		}
	}

	public static String removeDoubleSlash(String text) {
		// System.out.println("condotion removeSlash -> " + text);
		try {
			if (text.startsWith("//")) {
				// System.out.println("Inside removeSlash -> ");
				return text.substring(2);
			}
			else {
				return text;
			}
		}
		catch (Exception exception) {
			System.out.println(text + " Exception removeDoubleSlash -> " + exception);
			return text;
		}
	}

	public static String removeSingleSlash(String text) {
		// System.out.println("condotion removeSlash -> " + text);
		try {
			if (text.startsWith("/")) {
				// System.out.println("Inside removeSingleSlash -> ");
				text = text.substring(1);
			}
			if (text.endsWith("/")) {
				text = text.substring(0, text.length() - 1);
			}
			return text;
		}
		catch (Exception exception) {
			System.out.println(text + " Exception removeSingleSlash -> " + exception);
			return text;
		}
		finally {
		}
	}

	public static boolean urlValidator(String url) {
		try {
			if (url == null) {
				return false;
			}

			final String FILE_PATTERN = "([^\\s]+(\\.(?i)(/bmp|jpg|gif|png|pdf|doc|docx))$)";
			if (url.matches(FILE_PATTERN)) {
				return false;
			}

			// Assigning the url format regular expression
			String urlPattern = "^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*";
			int slash2Count = countToken("//", url);

			if (!url.matches(urlPattern)) {
				return false;
			}
			else if (slash2Count > 1) {
				return false;
			}
			else {
				return true;
			}
		}
		catch (Exception exception) {
			System.out.println(url + " Exception urlValidator -> " + exception);
			return false;
		}
	}

	private static int countToken(String token, String target) {
		int tokenIndex = 0;
		int count = 0;
		while (tokenIndex != -1) {
			tokenIndex = target.indexOf(token, tokenIndex);
			if (tokenIndex > -1) {
				tokenIndex++;
				count++;
			}
		}
		// System.out.println(target + " " + count);
		return count;
	}
}
