package online.solution.url.utility;

//import com.sun.xml.internal.ws.util.StringUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Bhushankumar
 */
public class IsNull {

	public static boolean isNullValue(String value) {
		try {
			String temp = null;
			String space = " ";
			String empty = "";
			if (value.trim().length() < 0) {
				return false;
			}
			else if (value.trim().equalsIgnoreCase("")) {
				return false;
			}
			else if (value.trim().equalsIgnoreCase("null")) {
				return false;
			}
			else if (value.equals(temp)) {
				return false;
			}
			else if (space.equals(value)) {
				return false;
			}
			else if (empty.equals(value)) {
				return false;
			}
			else {
				return true;
			}
		}
		catch (Exception exception) {
			System.out.println("Exception isNullValue -> " + exception);
			return false;
		}
	}

	public static boolean isNullValue(Object value) {
		try {
			if (value == null) {
				return false;
			}
			else if (!IsNull.isNullValue(value.toString())) {
				return false;
			}
			else {
				return true;
			}
		}
		catch (Exception exception) {
			System.out.println("Exception isNullValue -> " + exception);
			return false;
		}

	}
}
