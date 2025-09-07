package readingWexceptions;

import java.io.*;
import java.util.Scanner;


public class ReaderFile {

//MAKE OUTPUT FILE INSTEAD OF PRINTING TO SYSTEM, Make program return when file is not found.

	public static void main(String[] args) throws FileNotFoundException {
		int asa =0;
		int numcap =0;
	
		try (Scanner TextOptions = new Scanner(System.in)) {
			System.out.print("please Search a file, heres some suggestions: \nfile1.txt  \nnon-existent-file  \nfile2.txt  \nfile3.txt \n:");
			String Input = TextOptions.nextLine();
			String filename = Input;
		

		
		
		
		try (Scanner fs = new Scanner(new File(filename))) {

		    if (fs.hasNext()) {		
		    	String line =fs.next();
		    	System.out.print(line);
		    	System.out.print(" Generated this: \n");
		       }else{
		    	   System.out.println("The file is empty");
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
                // Read the first line and discard it.
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
					break;
				}
					}
				}//while
				
				if(NumCount < numcap){
					System.out.print("\nNot enough data to reach desired number! ");
					System.out.println();
				}if (asa ==1) {
					System.out.println();
					System.out.print("Non Number included in file.");
					System.out.println();

				}
            } else {
            	System.out.print("\n Not enough data or limit of 0!");
            }//if
			
				
			
		}//try
		
		
	}catch(FileNotFoundException e){
	System.out.print("\n File not found!" + e);
	return;
	}
		  }//main 
}//class
		
}
		







/* AI help section
 * Prompts : why is this only printing 9 characters in a row public 
 * I cant read a variable outside my loop here 
 *  how can I change this to skip the letter if numcap is read as f4 in the file 
 * I want it to readthe 4 but skip the f 
 *  how to return to the top of the program after catching an exception 
 * 
 * 
 * 
 * 
 * Code before correction:
 * 
 * 
 * 	public static void main(String[] args) throws IOException {
		String filename = "file1.txt";

		try (Scanner fs = new Scanner(new File(filename))) {

		    if (fs.hasNextLine()) {		
		    	String line =fs.next();
		    	System.out.print(line);
		    	System.out.print(" Generated this: \n");
		    	numcap = fs.next();
		       }//if statement
		     }//try
		int numcap =1;
 * 
 * 
 * 
 * 
 * 
 * 
 * int Rowcnt =0;
				while (Numscan.hasNext()){
					String readint = Numscan.next();
				Rowcnt = Rowcnt +1;
				if(Rowcnt =< 10) {
					Rowcnt = 0;
					System.out.print("\n");
				}else if(Rowcnt <= 10) {
					System.out.print(readint + " ");
 */
		
/*
 * import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MyFileParser {

    public static void main(String[] args) throws IOException {
        
        try (Scanner fileScanner = new Scanner(new File("file1.txt"))) {
            // Read the first line of the file.
            // You can remove this if you want to process the whole file.
            if (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                // Use a second Scanner to parse the words in the line.
                try (Scanner lineScanner = new Scanner(line)) {
                    while (lineScanner.hasNext()) {
                        if (lineScanner.hasNextInt()) {
                            // If the next token is an integer, just consume it and move on.
                            lineScanner.nextInt();
                        } else if (lineScanner.hasNextDouble()) {
                             // If it's a double, consume it too.
                             lineScanner.nextDouble();
                        } else {
                            // If it's not a number, read and print it.
                            String word = lineScanner.next();
                            System.out.println(word);
                        }
                    }
                }
            }
        }
    }
}
 * 		
 *
		

try (Scanner fs = new Scanner(new File(filename))) {

    if (fs.hasNextLine()) {		
    	String line =fs.next();
    	System.out.print(line);
    	System.out.print(" Generated this: \n");
       }//if statement
    if(fs.hasNextInt()) {		    	
    	 numcap = fs.nextInt();
	    	System.out.print(  "\n"+numcap + "\n\n");


    }else {
    	fs.next();
    	asa++;
    }
     }//try






try (Scanner Numscan = new Scanner(new File(filename))){
	if (Numscan.hasNextLine()) {
        // Read the first line and discard it.
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
			break;
		}
			}
		}//while
		
		
		
		
		
		
		
		
		
		
		if(NumCount < numcap){
			System.out.print("\nNot enough data to reach desired number! ");
			System.out.println();
		}if (asa ==1) {
			System.out.println();
			System.out.print("Non Number included in file.");
			System.out.println();
		
			try (Scanner fs = new Scanner(new File(filename))) {








		    if (fs.hasNextLine()) {		
		    	String line =fs.next();
		    	System.out.print(line);
		    	System.out.print(" Generated this: \n");
		       }//if statement
		    if(fs.hasNext()) {		    	
		    	String potentialnumcap = fs.next();
			    
			 try {   	numcap =Integer.parseInt(potentialnumcap);
			 
//	System.out.print(  "\n"+ potentialnumcap + "\n\n");
			 }catch(NumberFormatException e) {
		    	fs.next();
		    	asa++;
		    }
		     }//try
		
/*
 * 
 * 	}catch(FileNotFoundException e){
	System.out.print("\n File not found!");
	return;
	}
 * 
 * 
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
	


