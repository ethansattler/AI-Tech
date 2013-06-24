//properties.java

import java.io.FileInputStream;
import java.io.FileOutputStream;

class properties
{
	public static void main (String[] args) 
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	public static Boolean init() {
		try {
			main.config_prop.load(new FileInputStream(main.config_path));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static Boolean create_file () {
		try {
			main.config_prop.store(new FileOutputStream(main.config_path), null);
			return true;
		} catch (Exception ex) {
			return false;
		}
		
	}
	
	public static Boolean store () {
		try {
			main.config_prop.store(new FileOutputStream(main.config_path), null);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static Boolean set_prop (String prop, String value) {
		try {
			main.config_prop.setProperty(prop, value);
			properties.store();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static String get_prop (String prop) {
		try {
			return main.config_prop.getProperty(prop);
		} catch (Exception ex) {
			main.error("Missing property");
			return "Error...";
		}
	}
}