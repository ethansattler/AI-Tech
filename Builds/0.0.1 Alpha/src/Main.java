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
	public static Boolean config_loaded, config_written = true, installed, just_installed = false, proc_mode = false;
	public static Boolean internet_access = false, place_found = false, internet_error = false;
	public static String IP, place, audio, stdin;
	

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
																																																																					
		//Debug installed and configuration variables here:
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
		if (error.equals("runtime")) {
			System.out.print("Warning: runtime error");
		}
		if (error.equals("install")) {
			System.out.print("Warning: installation error");
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
	public static void AI_Proc () throws IOException, InterruptedException {
		while (proc_mode == true) {
			System.out.print("> ");
			stdin = input.nextLine();
			
			//Only parse if string isn't null
			if (!stdin.equals("")) {
				
			//Check for (direct to AI) ;; command
			if (stdin.startsWith(";;")) {
				Direct_to_AI(stdin);
			} else {
				parse(stdin);
			}
			
			}
		}
	}
	
	private static void clearConsole()
	{
		for(int i = 0; i < 25; i++) System.out.println();
	}
	
	public static void parse(String stdin) throws IOException, InterruptedException
	{
		stdin = stdin.toLowerCase();
		
		if (stdin.contains("what is"))
		{
			what_is_parse(stdin);
		} 
		else if (stdin.contains("where is")) 
		{
			where_is_parse(stdin);
		} else {
			unknown();
		}
	}
	
	public static void what_is_parse(String stdin) throws IOException, InterruptedException
	{
		//Replace "what is"
		stdin = stdin.replace("what is", "");
		
		say("what is", true);
	}
	
	public static void where_is_parse(String stdin) throws IOException, InterruptedException
	{
		//Replace "where is"
		stdin = stdin.replace("where is", "");
		
		say("where is", true);
	}
	
	public static void unknown() throws IOException, InterruptedException
	{
		say("I don't know what to say", true);
	}
	
	public static void say(String input, Boolean newline) throws IOException, InterruptedException
	{
		if (Properties_Utils.get_prop("use_audio").equals("yes")) {
		if (newline == true) {
			System.out.println(input);
			Utils.speak(input);
		} else {
			System.out.print(input);
			Utils.speak(input);	
		}
		} else {
			if (newline == true) {
				System.out.println(input);
				//Utils.speak(input);
			} else {
				System.out.print(input);
				//Utils.speak(input);	
			}
		}
	}
	
	public static void Direct_to_AI(String input) throws IOException, InterruptedException
	{
		input = input.replace(";;", "");
		
		if (input.startsWith("echo "))
		{
			input = input.replace("echo ", "");
			say(input, true);
		}
		
		if (input.startsWith("clear"))
		{
			say("clearing", true);
			clearConsole();
		}
		
		if (input.startsWith("audio"))
		{
			input = input.replace("audio", "");
			
			if (input.contains("on")) {
				Properties_Utils.set_prop("use_audio", "yes");
			} else {
				Properties_Utils.set_prop("use_audio", "no");
			}
		}
		
		if (input.startsWith("rmprop")) {
			say("Name of property ", false);
			String name = Main.input.nextLine();
			Properties_Utils.rm_prop(name);
			say("Property removed.", true);
		}
		
		if (input.startsWith("setprop")) {
			say("Name of property ", false);
			String name = Main.input.nextLine();
			say("Property value ", false);
			String value = Main.input.nextLine();
			Properties_Utils.set_prop(name, value);
			say("Property set.", true);
		}
		
		if (input.startsWith("propout ")) {
			input = input.replace("propout ", "");
			say(Properties_Utils.get_prop(input), true);
		}
		
		if (input.startsWith("first_name="))
		{
			input = input.replace("first_name=", "");
			Properties_Utils.set_prop("first_name", input);
		}
		
		if (input.startsWith("last_name="))
		{
			input = input.replace("last_name=", "");
			Properties_Utils.set_prop("last_name", input);
		}
		
		if (input.startsWith("place="))
		{
			input = input.replace("place=", "");
			input.trim();
			Properties_Utils.set_prop("place", input);
			Properties_Utils.set_prop("place_confirmed", "true");
		}
		
		if (input.contains("time"))
		{
			if (input.contains("-12"))
			{
				say(Utils.get_12hr_time (), true);	
			} else {
				say(Utils.get_time(), true);
			}
		}
		
		if (input.equals("reinstall"))
		{
			try {
				Procedure.install();
				//Procedure.welcome();
				proc_mode = true;
				AI_Proc ();
			} catch (IOException | InterruptedException e) {
				error("install");
			}
		}
	}
	
}