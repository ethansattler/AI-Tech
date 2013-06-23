//main.java 

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

class main 
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
	//Currently undefined user variables
	public static String first_name, last_name, fullname = first_name + last_name;
	
	public static void main (String[] args) 
	{
		//Check if System is installed properly.
		if (config_file.exists()) {
			installed = true;
			Boolean method_check = properties.init();
			if (method_check == true) {
				config_loaded = true;
			} else {
				config_loaded = false;
			}
		} else {
			installed = false;
			Boolean method_check = properties.create_file();
			if (method_check == true) {
				config_written = true;
			} else {
				config_written = false;
			}
		}
		
		//Debug installed and config variables here:
		
		if (installed == null) {
			//Throw Configuration error.
			error("config_startup");
		}
		
		if (installed == false) {
			System.out.print("Hello, I don't belive we've met.\nCould you tell me your first name? ");
			
		}
		if (installed == true) {
			System.out.print("Hello...");
		}
	
	}
	public static void error (String error) 
	{
		if (error.equals("config_startup")) {
		System.out.print("System Error, Configuration files tampered, or damaged. Review AI-Tech wiki for help, exiting...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.print("System interrupted, Error.");
			
		}	
		}
		
		if (error.equals("adderrorhere")) {
			System.out.print("adderrorhere. Exiting...");
			System.exit(0);
		}
		
		else {
			System.out.print("Unknown Error. Exiting...");
			System.exit(0);
		}
	}
	public static void AI_Proc () {
	
	}
	
}