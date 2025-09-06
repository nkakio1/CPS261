/**
 * 
 */
package esting_and_practice_IO_package;
import java.io.*;
/**
 * 
 */
public class Testing_and_practice {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("Info2writeandread");
		int characters;
		while ((characters = fr.read()) !=-1) {
			 if ((char) characters == '\n') {
	                System.out.println(); // Print a new line
	            } else {
			System.out.print((char) characters);
		}
		}
		fr.close();
	}



}
