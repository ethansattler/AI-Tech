import java.io.IOException;

//procedure.java
class procedure {
	
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	public static void install() throws IOException, InterruptedException {
		
		System.out.print("Hello, I don't belive we've met.\nCould you tell me your first name? ");
		utils.speak("Hello, I don't belive we've met. Could you tell me your first name?");
		main.first_name = main.input.next().trim();
		properties.set_prop("first_name", main.first_name);
		System.out.print("Oh ok " + main.first_name + ", what's your last name? ");
		utils.speak("Oh ok " + main.first_name + ", what's your last name? ");
		main.last_name = main.input.next().trim();
		properties.set_prop("last_name", main.last_name);
		main.fullname = main.first_name + " " + main.last_name; 
		System.out.print("So, " + main.fullname + " are we in " + main.place + "? ");
		utils.speak("So, " + main.fullname + " are we in " + main.place);
		String check = main.input.next().trim();
		if (utils.yes_parse(check) == true) {
			properties.set_prop("place", main.place);
			main.place_found = true;
		} else {
			System.out.print("Oh where are we then? ");
			utils.speak("Oh where are we then? ");
			String place = main.input.nextLine().trim();
			properties.set_prop("place", place);
			main.place_found = true;
		}
		
		System.out.print("Should I keep talking with audio? ");
		utils.speak("Should I keep talking with audio? ");
		check = main.input.next().trim();
		if (utils.yes_parse(check) == true) {
			properties.set_prop("use_audio", "yes");
		} else {
			properties.set_prop("use_audio", "no");
		}
	}
	
	public static void welcome () {
		main.first_name = properties.get_prop("first_name");
		main.last_name = properties.get_prop("last_name");
		main.fullname = main.first_name + " " + main.last_name;
		System.out.println("Hello " + main.first_name + ", It's " + utils.get_time());
	}
}