package mp2_nakio_student;

import java.util.*;

import mp2_nakio.Main;


public class MySelectionSort extends Main{


	    public static <T> void sortArray(Student[] arrayOne) {
	    	
	//    	Student.compareTo(Main.MySelectionSort[0]);
	    	
	//    	arrayListOne.sort(Main.myStudent);
	    //	this.arrayListOne[0].compareTo(arrayListOne[1]);
	    	
	    //	arrayOne[0].compareTo(arrayOne[1]);
	    //	arrayOne[2].compareTo(arrayOne[3]);
	    	
	    	//Array.sort(arrayOne);

	    	Arrays.sort(arrayOne,    (a , b) -> a.compareTo(b)    );
	    	
		}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub





		
	}

}
