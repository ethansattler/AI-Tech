//Properties.java

import java.io.FileInputStream;
import java.io.FileOutputStream;

class Properties_Utils
{
	public static void main (String[] args) 
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	public static Boolean init() {
		try {
			Main.config_prop.load(new FileInputStream(Main.config_path));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static Boolean create_file () {
		try {
			Main.config_prop.store(new FileOutputStream(Main.config_path), null);
			return true;
		} catch (Exception ex) {
			return false;
		}
		
	}
	
	public static Boolean store () {
		try {
			Main.config_prop.store(new FileOutputStream(Main.config_path), null);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static Boolean set_prop (String prop, String value) {
		try {
			Main.config_prop.setProperty(prop, value);
			Properties_Utils.store();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static void rm_prop (String prop) {
		try {
			Main.config_prop.remove(prop);
			Properties_Utils.store();
		} catch (Exception ex) {
		}
	}
	
	public static String get_prop (String prop) {
		try {
			return Main.config_prop.getProperty(prop);
		} catch (Exception ex) {
			Main.error("Missing property");
			return "Error...";
		}
	}
}