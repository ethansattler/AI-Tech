//utils.java
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

class Utils {
	
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
	
	public static String get_12hr_time () {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
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
	
	public static String read(String file) throws IOException {
		
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(file));
		StringBuffer sb = new StringBuffer("");
		while (br.readLine() != null) {
			sb.append("," + br.readLine());
		}
		return sb.toString();
		
	}
	
	public static void speak(String message) throws IOException, InterruptedException {
		Process p;
			p = Runtime.getRuntime().exec(new String[] {"espeak", "-g 5" , message});
			//p.waitFor();
			 
			  BufferedReader reader = 
			     new BufferedReader(new InputStreamReader(
				 p.getInputStream()));
			  String line = reader.readLine();
			  while (line != null) {
				line = reader.readLine();
			  }

	}
}