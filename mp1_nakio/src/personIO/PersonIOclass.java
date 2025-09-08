package personIO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
class Person {
private String name;
private int age;
public Person(String name, int value) {
    this.name = name;
    this.age = value;
}
public String getName() {
    return name;
} public int getValue() {
    return age;
}
	
}
public class PersonIOclass {
String fileName;
ObjectInputStream ois = null;
ObjectOutputStream oos = null;
static Scanner kbInput = new Scanner(System.in);
public PersonIOclass(String fileName) {
//fill in the code
//set fileName
//construct ObjectInputStream ois using fileName
//construct ObjectOutputStream oos using fileName
}
public void add() {
}
public void display() {
}
public static void main(String[] args) {
PersonIOclass mp1 = new PersonIOclass("person.ser");
try {
int option = -1;
while (option != 0) {
System.out.println("Please choose an option:");
System.out.println("0: quit");
System.out.println("1: add");
System.out.println("2: display");
option = kbInput.nextInt();
kbInput.nextLine();
switch (option) {
case 0:
System.out.println("Bye");
break;
case 1:
//add example  person myData = new DataPair("Example", 123);
	System.out.println("Enter Name:");
	

case 2:
//invoke display
}
}
} finally {
//close oos
//close ois
}
}
}