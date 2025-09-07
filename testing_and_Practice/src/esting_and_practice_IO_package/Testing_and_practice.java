/**
 * 
 */
package esting_and_practice_IO_package;
import java.io.*;
import java.util.Scanner;
/**
 * 
 */
public class Testing_and_practice {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("Info2writeandread");
		Scanner scanning = new Scanner(fr);
		while (scanning.hasNextLine()) {
	        System.out.println(scanning.nextLine());
	    }
		
//		int characters;
//		while ((characters = fr.read()) !=-1) {
//			 if ((char) characters == '\n') {
//	                System.out.println(); // Print a new line
//	            } else {
//			System.out.print((char) characters);}}
		
		
		fr.close();
		scanning.close();
	}



}
