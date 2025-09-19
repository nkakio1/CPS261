package mp2_nakio;

import java.util.*;

import mp2_nakio_student.MySelectionSort;
import mp2_nakio_student.Student;

public class Main {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Student myStudent = new Student("name ", 1.5);
	//	Student myStudent2 = new Student("insert ", 1.2225);



	//	System.out.println(Student.studentIDnum);
		
		
//		ArrayList<Object> arrayListOne;
	//	Array<Student> arrayOne = new ArrayList<>();
	//Array<Student> arrayOne = new Array<>();
		/*
		arrayListOne = new ArrayList<>();

		arrayListOne.add(myStudent2);
		arrayListOne.add(myStudent);

		MySelectionSort.sortArray(arrayListOne);
		
		System.out.println(arrayListOne);
		*/
	
	//	Student[] arrayOne = new Student[4]; 

		Student[] people = {new Student("Alice", 3.9), 
				new Student("Bob", 3.1), 
				new Student("Bob2", 3.7), 
				new Student("Alice2", 2.5)};
	/*	
	new Student("Alice", 3.5
		arrayOne.add(new Student("Bob", 3.9));
		arrayOne.add(new Student("Alice2", 3.1));
		arrayOne.add(new Student("Bob2", 2.5));
	*/	
	//	Student.setStudentIDnum(0);
		
	//	int result = people[0].compareTo(people[1]);
		
	//	System.out.println(result);  // -1, 0, or 1 depending on IDs
		
	//	Array.sort(arrayOne,    (a , b) -> a.compareTo(b)    );
		//System.out.println(people[1]);
	/*	
		people[0].setStudentID(22222);
		people[1].setStudentID(20);
		people[2].setStudentID(3);
		people[3].setStudentID(4);
*/
	//	Arrays.sort(people,    (a , b) -> a.compareTo(b)    );
		
		MySelectionSort.sortArray(people);
		System.out.println(Arrays.toString(people));
	}
}


//parse array into sort, 
//	arrayListOne.sortArray;
////write sort in my selection


//AI
//how to reference array members in a funciton
// how to generate getters and setters in eclipse
//
//why is this not accessing the array 0 position
//System.out.println(arrayListOne[0]);


//arrayListOne.get(0).compareTo(arrayListOne.get(1));
//why is this asking to be casted

// if this is the context, how shoild I change the declaration?
//		ArrayList<Object> arrayListOne;
//I got this example when I asked

/*
 * 	arrayListOne.add(new Student("Alice", 3.5));
		arrayListOne.add(new Student("Bob", 3.9));

		int result = arrayListOne.get(0).compareTo(arrayListOne.get(1));
		System.out.println(result);  // -1, 0, or 1 depending on IDs
 * 
 */



//Array<Student> arrayOne = new Array<>(); how do I fix this

//what is the syntax for adding things to a non array list in java?
//Person[] people = {new Person("Alice"), new Person("Bob")};

//what is wrong with this ? public static <T> void sortArray(arrayOne) {
//its array list formatting not array formatting
//	    public static <T> void sortArray(Student[] arrayOne) {


//how do I pass my array into the sort function?
//		Arrays.sort(people,    (a , b) -> a.compareTo(b)    );
//what is the a and b here? //		
//Arrays.sort(people,    (a , b) -> a.compareTo(b)    );



// how to pass array list with objects into array.sort
/*You cannot
 * 
 * 
 * 
 * 
 */
