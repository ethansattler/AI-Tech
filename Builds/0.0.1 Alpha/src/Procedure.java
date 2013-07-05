import java.io.IOException;

//procedure.java
class Procedure {
	
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	public static void install() throws IOException, InterruptedException {
		first_name ();
		last_name();
		location();
		audio();
		just_installed();
	}
	
	public static void just_installed() {
		Main.just_installed = true;
	}
	
	public static void welcome () {
		Main.first_name = Properties_Utils.get_prop("first_name");
		Main.last_name = Properties_Utils.get_prop("last_name");
		Main.fullname = Main.first_name + " " + Main.last_name;
		if (Main.just_installed != true) {
		System.out.println("Hello " + Main.first_name + ", It's " + Utils.get_time());
		} else {
			System.out.println(Main.first_name + ", It's " + Utils.get_time());
		}
	}
	
	public static void first_name () throws IOException, InterruptedException {
		System.out.print("Hello, I don't belive we've met.\nCould you tell me your first name? ");
		Utils.speak("Hello, I don't belive we've met. Could you tell me your first name?");
		Main.first_name = Main.input.nextLine().trim();
		if (Main.first_name == null || Main.first_name == "") {
			Main.first_name = "Unknown";
		}
		Properties_Utils.set_prop("first_name", Main.first_name);
	}
	
	public static void last_name() throws IOException, InterruptedException {
		System.out.print("Oh ok " + Main.first_name + ", what's your last name? ");
		Utils.speak("Oh ok " + Main.first_name + ", what's your last name? ");
		Main.last_name = Main.input.nextLine().trim();
		if (Main.last_name == null || Main.last_name == "") {
			Main.last_name = "Unknown";
		}
		Properties_Utils.set_prop("last_name", Main.last_name);
		Main.fullname = Main.first_name + " " + Main.last_name; 
	}
	
	public static void location() throws IOException, InterruptedException {
		System.out.print("So, " + Main.fullname + " are we in " + Main.place + "? ");
		Utils.speak("So, " + Main.fullname + " are we in " + Main.place);
		String check = Main.input.next().trim();
		if (Utils.yes_parse(check) == true) {
			Properties_Utils.set_prop("place", Main.place);
			Main.place_found = true;
			Properties_Utils.set_prop("place_confirmed", "true");
		} else {
			System.out.print("Oh where are we then? ");
			Utils.speak("Oh where are we then? ");
			String place = Main.input.nextLine().trim();
			Properties_Utils.set_prop("place", place);
			Main.place_found = true;
			Properties_Utils.set_prop("place_confirmed", "true");
		}
	}
	public static void audio() throws IOException, InterruptedException {
		System.out.print("Should I keep talking with audio? ");
		Utils.speak("Should I keep talking with audio? ");
		String check = Main.input.next().trim();
		Main.audio = check;
		if (Utils.yes_parse(check) == true) {
			Properties_Utils.set_prop("use_audio", "yes");
		} else {
			Properties_Utils.set_prop("use_audio", "no");
		}
	}
}