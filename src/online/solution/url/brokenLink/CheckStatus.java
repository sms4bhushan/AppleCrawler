/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package online.solution.url.brokenLink;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author Bhushankumar
 */
public class CheckStatus {

	public static boolean CheckUrl(String link) {
		try {
			// It may through if it is unable to open stream..
			new URL(link).openStream();

			HttpURLConnection connection = (HttpURLConnection) new URL(link)
					.openConnection();

			connection.setRequestMethod("GET");
			connection.connect();

			int code = connection.getResponseCode();
			// System.out.println("Code -> " + code);
			if (String.valueOf(code).startsWith("2")) {
				return true;
			} else {
				return false;
			}
			/*
			 * if (code == 200) { return true; } else if (code >= 200 || code <=
			 * 299) { return true; } else { return false; }
			 */
			// System.out.println("Code -> " + code);

		} catch (Exception exception) {
			System.out.println(link + " Exception CheckStatus.CheckUrl-> "
					+ exception);
			// e.printStackTrace(System.out);
			return false;
		}
	}
}