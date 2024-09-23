import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {

	private ArrayList<Student> students;

	public ScoreTrakker()
	{
		students = new ArrayList<Student>();
	}

	public void loadDataFile(String fileName)
	{
		//load in the file
		File myFile = new File(fileName);
//		try
//		{
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
					System.out.println("Incorrect format for " + studentName + "not a valid score: " + studentScore);
				}
			}
//		}
//		catch(FileNotFoundException e)
//		{
//			System.out.println("File failed to open");
//		}
		

	}
	
	public void printlnOrder()
	{
		
	}

}
