//procedure.java
class procedure {
	
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}
	
	public static void install() {
		
		System.out.print("Hello, I don't belive we've met.\nCould you tell me your first name? ");
		main.first_name = main.input.next().trim();
		properties.set_prop("first_name", main.first_name);
		System.out.print("Oh ok " + main.first_name + ", what's your last name? ");
		main.last_name = main.input.next().trim();
		properties.set_prop("last_name", main.last_name);
		main.fullname = main.first_name + " " + main.last_name; 
		System.out.print("So, " + main.fullname + " are we in " + main.place);
		
	}
	
	public static void welcome () {
		System.out.println("Hello " + main.first_name + ", It's " + utils.get_time());
	}
}