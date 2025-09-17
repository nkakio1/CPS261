package personIO;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class Person implements Serializable {
private static final long serialVersionUID = 1L;
private String name;
private int age;
public Person(String name, int value) {
    this.name = name;
    this.age = value;
}
public String toString(){
	return "Person [name=" + name + ", age=" + age +"]";
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
	this.fileName = fileName;
	
//fill in the code
//set fileName
//construct ObjectInputStream ois using fileName
//construct ObjectOutputStream oos using fileName
	  
}
public void add() throws IOException {
	
	String name = null;
	int age=0;
	System.out.println("Enter Name:");
	name = kbInput.next();
	 boolean valid= false;
	 while(!valid) {
		System.out.println("Enter a number for age\n");
		try {
			kbInput.nextLine();
			age = kbInput.nextInt();
			valid = true;
		}catch(InputMismatchException e) {
		System.out.println("Sorry, please enter a number for age\n");
		}
	}
	  Person addedPerson = new Person(name, age);
	
	 FileOutputStream Output = new FileOutputStream("PIOreadwrite.txt", false);
            try (ObjectOutputStream out = new ObjectOutputStream(Output)) {
				{
				out.writeObject(addedPerson);

				}
            }
	
}
public void display() throws IOException, ClassNotFoundException {
//	File file = new File(fileName);
	
	 try (
	            FileInputStream fileIn = new FileInputStream("PIOreadwrite.txt");
	            ObjectInputStream in = new ObjectInputStream(fileIn)
	        ) 
	 {while (true) {
	                try {
	                    Person person = (Person) in.readObject();
	                    System.out.println(person);
	                } catch (EOFException eof) {
	                    break;
	                }
	            }
	        } 
	
	
}
public static void main(String[] args) throws IOException, ClassNotFoundException {
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
//add example  person myData = new DataPair("bbb", 123);
mp1.add();
break;
case 2:
mp1.display();
break;
}
}
} finally {
}
}
}


/*
 * AIused:
 * tool: gemini 
 * prompt:
 * just explain the parts of this without correcting
 * original code:
 * public PersonIOclass(String fileName) {
//fill in the code
//set fileName
//construct ObjectInputStream ois using fileName
//construct ObjectOutputStream oos using fileName
}
public void add() {
}
public void display() {
}
 * AI response: went over the parts like void and oublic and why they are needed, so I could get a better understanding of  what I need to write
 * 
 * 
 * AI used:
 * tool: gemini
 * prompt why is name and age not being used in my code
 * code:
 * public void add() {
	int IScorrect =-1;
	String name = null;
	int age=0;
	System.out.println("Enter Name:");
	name = kbInput.next();
	while(IScorrect!=0) {
		System.out.println("Enter a number for age\n");
		try {
			kbInput.nextLine();
			age = kbInput.nextInt();
			IScorrect++;
		}catch(InputMismatchException e) {
		System.out.println("Sorry, please enter a number for age\n");
	}
	}
	
	AI response: the method ends and I dont do anything with it after theyre defined
	so I realize now I need to send the data to the person class which should write to the file
	
	AI used:
	tool: gemini
	prompt: what is the difference between the person class and personio class
	AI response: person class holds data and the person io will write that data to a file eventually
 
 *
 *AI used:
 *tool:gemini
 *prompt: how do I print newPerson to the cl
 *original code: system.out.printline(newPerson);
 *Ai: response: System.out.println("Name: " + newPerson.getName() + ", Age: " + newPerson.getAge());
 *
 *

		}
 *
 *AI used
 *tool:gemini
 *prompt: why doesnt this work?
 *code:     objectOutputStream fileOut = new objectOutputStream("PIOreadwrite.txt", true);
AI response: 
 *ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
    
            out.writeObject(newPerson);
            System.out.println("Successfully added person: " + newPerson);
        } catch (IOException i) {
            System.err.println("Error writing to file: " + i.getMessage());
     what I changed: I needed to set the file output AND the object output since there was no defined object to send
 *
 *
 *
 *AI used:
 *tool: gemini
 *prompt: 2
java.io.NotSerializableException: personIO.Person
	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1200)
	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:358)
	at mp1_nakio/personIO.PersonIOclass.add(PersonIOclass.java:59)
	at mp1_nakio/personIO.PersonIOclass.main(PersonIOclass.java:85)
	
	AI response: change person to class Person implements Serializable {
change:	I went back and had to read the articles again.s
 */
