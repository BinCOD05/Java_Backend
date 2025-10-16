package spring.web.Utils;

public class StringUtil {
	public static boolean validString(String value) {
		if(value != null && !value.equals("")) {
			return true;
		}
		return false;
	}
}
