//readfromserver.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class Readfromserver
{
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	 public static String getpage(String url) throws IOException {
         URL conn = new URL(url);
         URLConnection c = conn.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream(), "UTF-8"));
         String inputLine;
         StringBuilder a = new StringBuilder();
         while ((inputLine = in.readLine()) != null)
             a.append(inputLine);
         in.close();
         return a.toString();
     }
}