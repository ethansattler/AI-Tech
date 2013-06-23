//utils.java
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

class utils {
	
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}

	
	public static String WordWrap(String s) {
		StringBuilder sb = new StringBuilder(s);

		int i = 0;
		while (i + 100 < sb.length() && (i = sb.lastIndexOf(" ", i + 100)) != -1) {
		    sb.replace(i, i + 1, "\n");
		}
		return sb.toString();
		
	}
	
	public static String get_time () {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = ""+sdf.format(cal.getTime());
    	return time;
	}
	
	public static Boolean yes_parse(String input) {
		if (Arrays.asList("yes", "y", "yep", "yea", "aye", "true", "affirmative", "granted", "mhm").contains(input.toLowerCase().trim())) {
			return true;
		} else {
		return false;
		}
	}
	
	public static Boolean no_parse(String input) {
		if (Arrays.asList("no","n","nope").contains(input.toLowerCase().trim())) {
			return true;
		} else {
		return false;
		}
	}
}