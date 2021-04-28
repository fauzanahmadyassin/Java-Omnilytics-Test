package pkg.com.my;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class QuestionOne {
	
	static final String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String alphanum = character + "0123456789";
	static Random rand = new Random();

	public static String Alphabet() {
		
		String randstr = "";
		int size = rand.nextInt(character.length());
		if (size == 0)
			size += 1;
		
		for (int x=0; x<size; x++) 
			randstr += character.charAt(rand.nextInt(character.length()));
		
		return randstr;
		
	}
	
	public static double RealNumber() {

		return rand.nextInt(1000000 - 1) + Double.parseDouble(String.format("%.3f", rand.nextDouble()));
		
	}
	
	public static int IntegerNumber() {
		return rand.nextInt();
		
	}
	
	public static String AlphaNumeric() {

	   int size = rand.nextInt(alphanum.length());
	   String randstr = "";
	   
	   if (size == 0)
		   size += 1;
	   
	   for (int x=0; x<size; x++) 
			randstr += alphanum.charAt(rand.nextInt(alphanum.length()));
	   
	   String space = "          ";
	   String firstSpace = space.substring(0, rand.nextInt(space.length()));
	   String lastSpace = space.substring(firstSpace.length(), space.length());

	   return  firstSpace + randstr + lastSpace;

	}
	
	public static void PrintToFile() {
		
		File myFile = new File ("AnswerQuestion1.txt"); 
	      try {
			if (myFile.createNewFile()) {  
			    System.out.println("Text file created: " + myFile.getName());   
			    System.out.println("Loading data to file...");
			    FileWriter myWriter = new FileWriter(myFile, true);
			    boolean first = true;
			    while (myFile.length()/1048576.0 <= 10) { // 1 megabytes == 1048576 bytes
			    	if (first) {
			    		myWriter.write(Alphabet()+ "," +RealNumber()+ "," +IntegerNumber()+ "," +AlphaNumeric());
			    		first = false;
			    	}
			    	myWriter.write("," +Alphabet()+ "," +RealNumber()+ "," +IntegerNumber()+ "," +AlphaNumeric());
			    }
			    myWriter.close();
			    System.out.println("Done!");
			  }
			else {
				System.out.println(myFile.getName() + " is already exist. \nPlease delete the file first and run the script again.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error while checking file");
		}
		
	}
	

	public static void main(String[] args) {
		
		PrintToFile();
		
	}
	

}
