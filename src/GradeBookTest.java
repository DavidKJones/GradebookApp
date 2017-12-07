import java.util.ArrayList;

public class GradeBookTest {

	public static void main(String[] args) {
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student("S0001","John Doe"));
		student.add(new Student("S0002", "Apple Banana"));
		student.add(new Student("S0003","poopy butt"));
		student.add(new Student("S0004","poopy butt", "B" , 73.5));
		student.add(new Student("S0005","poopy butt", "C" , 80));
		for(int i = 0;i<student.size();i++) {
			System.out.println(student.get(i).toString());
		}
	}

}
