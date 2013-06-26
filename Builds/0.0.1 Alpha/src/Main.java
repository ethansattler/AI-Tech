//main.java 

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

class Main 
{
	//Public static variables:
	public static String Build_Version = "0.0.1 Alpha";
	public static String Build_name = "AI-Tech";
	public static Scanner input = new Scanner(System.in);
	public static File config_file = new File(".AI-Config.properties");
	public static String config_path = ".AI-Config.properties";
	public static Properties config_prop = new Properties();
	public static Boolean config_loaded;
	public static Boolean config_written = true;
	public static Boolean installed;
	public static Boolean just_installed = false;
	public static Boolean proc_mode = false;
	public static Boolean internet_access = false, place_found = false, internet_error = false;
	public static String IP, place, audio;

	//Currently undefined user variables
	public static String first_name, last_name, fullname;
	
	public static void main (String[] args) throws IOException, InterruptedException 
	{
		//Check Internet 
		try {
			IP = Checkip.getextIp();
			internet_access = true;
		} catch (Exception ex) {
			internet_access = false;
		}
		
		//Setup internet variables use this format to save API key uses
		try {
			if (internet_access == true && Checkip.ip_changed() == true) 
			{
				Properties_Utils.set_prop("IP", IP);
				place = Checkip.geoLocate();
				Properties_Utils.set_prop("place", place);
				place_found = true;
			}
		} catch (Exception e) {
			internet_error = true;
		}
		
		if (place == null) {
			place = Checkip.geoLocate();
			place_found = true;
		}
		
		//Start language parser
		Natural_Parser.set_verb_list();
		
		
		
		//Check if System is installed properly.
		if (config_file.exists()) {
			installed = true;
			Boolean method_check = Properties_Utils.init();
			if (method_check == true) {
				config_loaded = true;
			} else {
				config_loaded = false;
			}
		} else {
			installed = false;
			Boolean method_check = Properties_Utils.create_file();
			if (method_check == true) {
				config_written = true;
			} else {
				config_written = false;
			}
		}
																																																																					
		//Debug installed and config variables here:
		//installed = false;
		
		if (installed == null) {
			//Throw Configuration error.
			error("config_startup");
		}
		
		if (installed == false) {
			Procedure.install();		
		}
		
		if (installed == true) {
			Procedure.welcome();
			proc_mode = true;
			AI_Proc ();
		}
	
	}
	public static void error (String error) 
	{
		if (error.equals("config_startup")) {
		System.out.print("System Error, Configuration files tampered, or damaged. Review AI-Tech wiki for help, exiting...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.print("System interrupted, Error...");
			
		}	
		}
		
		if (error.equals("adderrorhere")) {
			System.out.print("adderrorhere. Exiting...");
			System.exit(0);
		}
		if (error.equals("Missing property")) {
			System.out.print("Warning: Missing property");
		}
		if (error.equals("no internet")) {
			System.out.print("Warning: no internet access.");
		}
		
		else {
			System.out.print("Unknown Error. Exiting...");
			System.exit(0);
		}
	}
	public static void AI_Proc () {
		while (proc_mode == true) {
			
		}
	}
	
}