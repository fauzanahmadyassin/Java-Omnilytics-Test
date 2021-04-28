package pkg.com.my;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QuestionTwo {
	
	final static String numRegex   = "^-?[0-9]\\d*(\\.\\d+)?$";
	final static String alphaRegex = "^[a-zA-Z]+$";
	final static String alphaNumRegex = "^[a-zA-Z0-9]+$";
	
	public static String LoadFile(String filename) {
		File myFile = new File(filename);
		Scanner myReader = null;
		try {
			myReader = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error while retrieving file");
		}
		return myReader.nextLine();
	}
	
	public static void DataLabel(String doc) {
		StringTokenizer str = new StringTokenizer(doc," ,");
		int count = 0;
		while (str.hasMoreTokens()) {
			String data= str.nextToken();
			
			if (data.matches(numRegex)) {
				if (data.contains("."))
					System.out.println(data + " - real numbers");
				else
					System.out.println(data + " - integer");
			}
			
			else if (data.matches(alphaRegex)) {
				System.out.println(data + "  - alphabetical strings");
			}
			
			else if (data.matches(alphaNumRegex)) {
				System.out.println(data + " - alphanumeric");
			}
			count ++;
		}
		System.out.println("\nTotal data count : " +count+ " record(s)");
		
	}

	public static void main(String[] args) {
		String doc = LoadFile("AnswerQuestion1.txt");
		DataLabel(doc);    
	}

}
