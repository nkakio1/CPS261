package mp2_nakio_student;

import mp2_nakio.Main;
import java.util.*;


public class Student extends Main implements Comparable<Student> {
	
	private int studentID;
	private String name;
	private double gpa;
	
	public static int studentIDnum = 0;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
		this.studentID = ++studentIDnum;
	}
	
	
	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getGpa() {
		return gpa;
	}


	public void setGpa(double gpa) {
		this.gpa = gpa;
	}


	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", name=" + name + ", gpa=" + gpa + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		
	}


	public static int getStudentIDnum() {
		return studentIDnum;
	}


	public static void setStudentIDnum(int studentIDnum) {
		Student.studentIDnum = studentIDnum;
	}


	@Override
	public int compareTo(Student other) {
		// TODO Auto-generated method stub
		 if (this.studentID < other.studentID) {
	            return -1;
	        } else if (this.studentID > other.studentID) {
	            return 1;
	        } else {
	            return 0;
	        }
	}

}
