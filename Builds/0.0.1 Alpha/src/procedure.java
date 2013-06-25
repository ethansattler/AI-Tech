import java.io.IOException;

//procedure.java
class procedure {
	
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
		main.just_installed = true;
	}
	
	public static void welcome () {
		main.first_name = properties.get_prop("first_name");
		main.last_name = properties.get_prop("last_name");
		main.fullname = main.first_name + " " + main.last_name;
		if (main.just_installed != true) {
		System.out.println("Hello " + main.first_name + ", It's " + utils.get_time());
		} else {
			System.out.println(main.first_name + ", It's " + utils.get_time());
		}
	}
	
	public static void first_name () throws IOException, InterruptedException {
		System.out.print("Hello, I don't belive we've met.\nCould you tell me your first name? ");
		utils.speak("Hello, I don't belive we've met. Could you tell me your first name?");
		main.first_name = main.input.nextLine().trim();
		if (main.first_name == null || main.first_name == "") {
			main.first_name = "Unknown";
		}
		properties.set_prop("first_name", main.first_name);
	}
	
	public static void last_name() throws IOException, InterruptedException {
		System.out.print("Oh ok " + main.first_name + ", what's your last name? ");
		utils.speak("Oh ok " + main.first_name + ", what's your last name? ");
		main.last_name = main.input.nextLine().trim();
		if (main.last_name == null || main.last_name == "") {
			main.last_name = "Unknown";
		}
		properties.set_prop("last_name", main.last_name);
		main.fullname = main.first_name + " " + main.last_name; 
	}
	
	public static void location() throws IOException, InterruptedException {
		System.out.print("So, " + main.fullname + " are we in " + main.place + "? ");
		utils.speak("So, " + main.fullname + " are we in " + main.place);
		String check = main.input.next().trim();
		if (utils.yes_parse(check) == true) {
			properties.set_prop("place", main.place);
			main.place_found = true;
			properties.set_prop("place_confirmed", "true");
		} else {
			System.out.print("Oh where are we then? ");
			utils.speak("Oh where are we then? ");
			String place = main.input.nextLine().trim();
			properties.set_prop("place", place);
			main.place_found = true;
			properties.set_prop("place_confirmed", "true");
		}
	}
	public static void audio() throws IOException, InterruptedException {
		System.out.print("Should I keep talking with audio? ");
		utils.speak("Should I keep talking with audio? ");
		String check = main.input.next().trim();
		main.audio = check;
		if (utils.yes_parse(check) == true) {
			properties.set_prop("use_audio", "yes");
		} else {
			properties.set_prop("use_audio", "no");
		}
	}
}