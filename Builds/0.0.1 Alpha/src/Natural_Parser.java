import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Natural_Parser {
	
	public static List<String> verbs = new ArrayList<String>();
	public static ClassLoader cl = Thread.currentThread().getContextClassLoader();
	public static String URLtoVerbs = "VERBS";
	public static String Verbs;
	
	public static void main (String[] args)  
	{
		
		//System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	public static Boolean known_word(String file) throws IOException {
		String input = Utils.read("/usr/share/dict/words");
		if (input.contains(file)) {
		return true;
		} else {
			return false;
		}
		
	}
	
	public static void set_verb_list() {
		try {
		String verb_list = Utils.read(URLtoVerbs);
		String[] split_list = verb_list.split(",");
		int len = split_list.length;
		int x = 0;
		while (x < len) {
			verbs.add(split_list[x]);
			x++;
		}
		} catch (Exception ex) {
		}
		String finals = verbs.toString();
		finals = finals.replace(",", "");
		finals = finals.replace("null", "");
		Verbs = finals;
	}
	
	public static Boolean verb_check(String word) {
		word = word.trim();
		word = word.replaceAll("([a-z]+)[?:!.,;]*", "$1");
		System.out.print(word + "\n" + Verbs);
		if (Verbs.contains(word)) {
			return true;
		} else {
			return false;
		}
	}
}