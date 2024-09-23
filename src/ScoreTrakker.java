import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//comment for test push

public class ScoreTrakker {

	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

	public ScoreTrakker()
	{
		students = new ArrayList<Student>();
	}

	public static void main(String[] args)
	{
		ScoreTrakker st = new ScoreTrakker();
		st.processFiles();
	}

	//loads in the file and puts the student data in the ArrayList
	public void loadDataFile(String fileName) throws FileNotFoundException
	{
		//load in the file
		File myFile = new File(fileName);
		Scanner scan = new Scanner(myFile);

		//put the file data into the array
		while(scan.hasNextLine())
		{
			String studentName = scan.nextLine();
			String studentScore = scan.nextLine();
			try
			{
				Integer score = Integer.parseInt(studentScore);
				students.add(new Student(studentName, score));
			}
			catch(NumberFormatException e)
			{
				System.out.println("\nIncorrect format for " + studentName + " not a valid score: " + studentScore);
			}
		}


	}

	//prints the list of students with their scores
	public void printlnOrder()
	{
		Collections.sort(students);
		System.out.println("\nStudent Score List");
		for(Student s:students)
		{
			System.out.println(s);
		}
	}

	public void processFiles()
	{

		for(String f: files)
		{
			try
			{
				loadDataFile(f);
				printlnOrder();
			}
			catch(FileNotFoundException e)
			{
				System.out.println("\nCan't open file: " + f);
			}
			students = new ArrayList<Student>();
		}

	}


}
