//checkip.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

import javax.xml.soap.Node;

import org.w3c.dom.Document;

public class Checkip {

	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}

	
	public static String geoLocate() throws IOException {
		try {
	        URL whatismyip = new URL("http://api.db-ip.com/addrinfo?addr="+ getextIp() +"&api_key="+ randomapi());
	        BufferedReader in = null;
	        try {
	            in = new BufferedReader(new InputStreamReader(
	                    whatismyip.openStream()));
	            String ip = in.readLine();
	            String[] ips = ip.split("\"");
	            String part2 = ips[11];
	            String part3 = ips[7];
	            if (part3.equals("US")) {
	            	part3 = "USA";
	            }
	            String part4 = part2 + ", " + part3;
	            return part4;
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    } catch (Exception ex) {
	    	return null;
	    }
	}
	
	public static Boolean ip_changed() {
		try {
		Object ip1 = Properties_Utils.get_prop ("IP");
		String ip2 = getextIp();
		if (ip1.equals(ip2)) {
			return false;
		}
		return true;
		} catch (Exception ex) {
			return false;
		}
	}
 
	private static String randomapi() {
	Random rand = new Random();
	int  n = rand.nextInt(5) + 1;
	if (n == 1) {
		return "106224f2f1de1f68fcb2b035850291ee7ed25224";
	}
	if (n == 2) {
		return "645436749aed2360006c83f58e1ce301a183e232";
	}
	if (n == 3) {
		return "1dd1617a43f5d944f9e70bc03e5faf1ef9b03e1a";
	}
	if (n == 4) {
		return "4acada6ffd133037f554c205ee068e0f0d6d12dd";
	} else {
		return "2b650722432d3148f747c97fc51f9f54e6442fea";
	}
}



public static String getintIp() throws Exception {
	try {
	Socket s = new Socket("google.com", 80);
	String intip = s.getLocalAddress().getHostAddress();
	s.close();
	return intip;
	} catch (Exception ex) {
    	return null;
    }
}
	    public static String getextIp() throws Exception {
	    	try {
	        URL whatismyip = new URL("http://checkip.amazonaws.com");
	        BufferedReader in = null;
	        try {
	            in = new BufferedReader(new InputStreamReader(
	                    whatismyip.openStream()));
	            String ip = in.readLine();
	            return ip;
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    } catch (Exception ex) {
	    	return null;
	    }
	}
}