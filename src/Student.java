
public class Student implements Comparable{

	
	private String name;
	private int score;
	
	public Student(String n, int s)
	{
		name = n;
		score = s;
	}

	@Override
	public int compareTo(Object o) {
		Student comp = (Student)(o);
		if(score > comp.score)
			return -1;
		
		return 1;
	}

	@Override
	public String toString() {
		return name + " " + score;
	}
	
	
}
