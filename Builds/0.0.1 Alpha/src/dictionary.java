import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

//dictionary.java

class dictionary 
{
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	public static Object dictionary_lookup (String word) 
	{
		try {
			URL dict = new URL("http://blogwithme.net/dictionary/xml_files/check3.php?word=" + word); 
			  URLConnection dictConnection = dict.openConnection(); 
			  Scanner in = new Scanner(dict.openStream());
			  String line = in.nextLine();
			  line = line.concat(".");
			  line = utils.WordWrap(line);
			  return line;
		} catch (Exception ex) {
			return null;
		}	
	}
	public static Object dictionary_add (String word, String definition, Boolean overwrite) 
	{
		return "Dictonary is still being built";	
	}
}