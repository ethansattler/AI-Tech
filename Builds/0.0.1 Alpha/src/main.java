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
	public static Properties config_prop = new Properties();
	public static Boolean installed;
	
	public static void main (String[] args) 
	{
		//Check if System is installed properly.
		if (config_file.exists()) {
			installed = true;
			Boolean method_check = properties.init();
			if (method_check == true) {
			
			} else {
				
			}
		} else {
			installed = false;
			Boolean method_check = properties.create_file();
			if (method_check == true) {
				
			} else {
				
			}
		}
		
		if (installed == false) {
			System.out.print("Hello, I don't belive we've met.\nCould you tell me your name? ");
		}
		if (installed == true) {
			System.out.print("Hello...");
		}
		else if (installed == null) {
			//Throw Configuration error.
			config_error();
		}
	}
	public static void config_error () 
	{
		System.out.print("System Error, Configuration files tampered, or damaged. Review AI-Tech wiki for help, exiting...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.print("System interrupted, Error.");
			
		}	
	}
	public static void AI_Proc () {
	
	}
	
}