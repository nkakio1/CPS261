package readingWexceptions;

import java.io.*;
import java.util.Scanner;


public class ReaderFile {

//MAKE OUTPUT FILE INSTEAD OF PRINTING TO SYSTEM

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream originalOut = System.out;
	
		
		int asa =0;
		int numcap =0;
	
		try (Scanner TextOptions = new Scanner(System.in)) {
			System.out.print("please Search a file, heres some suggestions: \nfile1.txt  \nnon-existent-file  \nfile2.txt  \nfile3.txt \n:");
			String Input = TextOptions.nextLine();
			String filename = Input;
		

			try {
	         
	            PrintStream fileOut = new PrintStream(new FileOutputStream("OUTput.txt", true));
	            System.setOut(fileOut);
		
		
		try (Scanner fs = new Scanner(new File(filename))) {

		    if (fs.hasNext()) {		
		    	String line =fs.next();
		    	System.out.print(line);
		    	System.out.print(" Generated this: \n");
		       }else{
		    	   originalOut.println("The file is empty");
		    	   return;
		       }
		    if(fs.hasNext()) {		    	
		    	String potentialnumcap = fs.next();	
		    	 String numberPart = potentialnumcap.replaceAll("[^0-9]", "");
		    	 if(!numberPart.isEmpty()) {
		    	 try {   	
				
	//System.out.print(  "\n"+ numcap + "\n\n");
				 
			      numcap =Integer.parseInt(numberPart);
				 
			 
		     }catch (NumberFormatException e) {
		    	 asa++;
		    	 numcap =0;
		     }
		     }else {
		    	 asa++;
		    	 numcap=0;

		     }
		}
		try (Scanner Numscan = new Scanner(new File(filename))){
			if (Numscan.hasNextLine() && numcap!=0) {
				Numscan.nextLine();
				int NumCount =0;
				int Rowcnt =0;
				while (Numscan.hasNext()){
					if(Numscan.hasNextInt() !=true) {
						Numscan.next();		
						asa = asa +1;
					}else {
					String readint = Numscan.next();
					System.out.print(readint + " ");
					Rowcnt = Rowcnt +1;
					NumCount = NumCount+1;
				if(Rowcnt == 10) {
					Rowcnt = 0;
					System.out.print("\n");
				}else if(NumCount == numcap) {
					System.out.println();
					break;
				}
					}
				}//while
				
				if(NumCount < numcap){
					 originalOut.println("Not enough data to reach desired number!\n ");
				
				}if (asa ==1) {
					 originalOut.println("\nNon Number included in file.\n");
					
				}
            } else {
            	 originalOut.println("\n Not enough data or limit of 0!");
            }//if
			
				
			
		}//try
		
		
	}catch(FileNotFoundException e){
		 originalOut.println("\n File not found!" + e);
	return;
	}
		  
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			System.setOut(originalOut);
		}
		System.out.println("Your data has be output to OUTpu.txt!");
		
		
		
		
		
		
		
}
		
}
}







/* AI USED:
 * 
 * Tool: copilot
 * 
 * Prompt : why is this only printing 9 characters in a row 
 * Original code:
 *  *	try (Scanner Numscan = new Scanner(new File(filename))){
			if (Numscan.hasNextLine()) {
                // Read the first line and discard it.
				Numscan.nextLine();
				int NumCount =0;
				int Rowcnt =0;
				while (Numscan.hasNext()){
						asa = asa +1;
					}else {
					String readint = Numscan.next();
					System.out.print(readint + " ");
					Rowcnt = Rowcnt +1;
					NumCount = NumCount+1;
				if(Rowcnt >=9) {
					Rowcnt = 0;
					System.out.print("\n");
				}else if(NumCount == numcap) {
					System.out.println();
					break;
				}
		
		AI suggested to: change >=9 to ==10
		
 * 
 * AI USED:
 * 
 * Tool: copilot
 * Prompt: Why is this not appending
 * 
 *Original code:
 *
 * 			try {
	            // Step 2: Set up the new output stream to a file
	            PrintStream fileOut = new PrintStream(new FileOutputStream("OUTput.txt"));
	            System.setOut(fileOut);
 * 
 * AI suggested to add the true statement to the "OUTput.txt" true));
 * 
 * 
 * AI USED:
 * Tool: Gemini guided Learning Mode 
 * Prompt: 

 Original code:Why is this still running through the program, even though the number which sets the desired output numbers is 0 (numcap)
 
 try (Scanner Numscan = new Scanner(new File(filename))){
			if (Numscan.hasNextLine()) {
        
				Numscan.nextLine();
				int NumCount =0;
				int Rowcnt =0;
				while (Numscan.hasNext()){
					if(Numscan.hasNextInt() !=true) {
						Numscan.next();		
						asa = asa +1;
					}else {
					String readint = Numscan.next();
					System.out.print(readint + " ");
					Rowcnt = Rowcnt +1;
					NumCount = NumCount+1;
				if(Rowcnt == 10) {
					Rowcnt = 0;
					System.out.print("\n");
				}else if(NumCount == numcap) {
					System.out.println();
					break;
				}
					}
				}//while
AI suggested to: It went through the process of the loop like this:
First, let's trace what happens in your code when numcap is set to 0:

The loop starts.

Your code reads the first item from the file.

The NumCount variable goes from 0 to 1.

Then, your code checks if NumCount is equal to numcap. What are the values of NumCount and numcap at this point? Is the condition NumCount == numcap true or false?
		
 *
 *
 *  TRIAL AND ERROR
 *
 *
 *	static void process(String inputFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(inputFile);
		while(scanner.hasNext()) {
			String output =scanner.next();
			System.out.println(output);
			
		}
		scanner.close();
		
		
		 Scanner TextOptions = new Scanner(System.in);
	        System.out.print("please choose between: \nfile1.txt  \nnon-existent-file  \nfile2.txt  \nfile3.txt \n:");
	        String Input = TextOptions.nextLine();//READS HUMAN INPUT

	/*    try  (BufferedReader Linereader = new BufferedReader(new FileReader(Input))) {
	    	
	    }catch (FileNotFoundException e) {
	    	System.out.println("File Not Found " + e);
	    } 
	        
	    try {
            process(Input);
        } catch (FileNotFoundException e) {
            // Catch the specific exception thrown by the process method.
            System.err.println("File Not Found: " + e.getMessage());
        } finally {
            // The finally block ensures the scanner for system input is always closed.
            TextOptions.close();
        }
	    
	    
	    
 if (Input == "file1.txt" ){
	process("file1.txt");
}else if(Input == "file2.txt") {
	process("file2.txt");
}else if(Input == "file3.txt"){
	process("file3.txt");
}else { 
	process(Input);
};
TextOptions.close();
		//process(xyz); will process which file that is called
		//&& output == "MyOutput1.txt " + 22)
*/
	


