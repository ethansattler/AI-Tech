class utils {
	
	public static void main (String[] args)  
	{
		System.out.println("Not the correct way to execute this file, refer to documentation.");
		System.exit(0);
	}

	
	public static String WordWrap(String s) {
		StringBuilder sb = new StringBuilder(s);

		int i = 0;
		while (i + 100 < sb.length() && (i = sb.lastIndexOf(" ", i + 100)) != -1) {
		    sb.replace(i, i + 1, "\n");
		}
		return sb.toString();
		
	}
}