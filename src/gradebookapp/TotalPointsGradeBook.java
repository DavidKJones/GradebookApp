package gradebookapp;
/**
 * <h1>TotalPointsGradebook</h1>
 * Simple grade book class that calculates grade by total points.
 * @author david
 *
 */
@SuppressWarnings("serial")
public class TotalPointsGradeBook extends GradeBook 
{
	//constructors
	/**
	 * default constructor
	 */
	public TotalPointsGradeBook()
	{
		super();
		setName("New Total Points Gradebook");
	}
	
	/**
	 * constructor with one parameter
	 * @param name string
	 */
	public TotalPointsGradeBook( String name )
	{
		super();
		setName(name);
	}
	
	/**
	 * calculates student grade by total points system
	 * @param student Student
	 * @return double value of the student percentage
	 */
	@Override
	public double calculateStudentPercentage( Student student ) 
	{
		int totalpoints = 0;
		int studentTotal = 0;
		double percentage = 0;
		
		for(Assignment a : student.getAssignments())
		{
			if(a == null)
				break;
			
			if(!a.isExtraCredit())
				totalpoints += a.getTotalScore();
			studentTotal += a.getStudentScore();
		}
		
		try
		{
			percentage = ((double)studentTotal / (double)totalpoints) * 100.0;
			System.out.println(percentage);
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex);
		}
		
		return percentage;
	}
	
	/**
	 * get the overall grade of the student
	 * @param student Student
	 * @return letter grade of student
	 */
	@Override
	public String getGrade( Student student )
	{
		double percentage = calculateStudentPercentage( student );
		String grade = null;
		
		if(percentage >= 97)
			grade = "A+";
		else if(percentage < 97 && percentage >= 93)
			grade = "A";
		else if(percentage < 93 && percentage >= 90)
			grade = "A-";
		else if(percentage < 90 && percentage >= 87)
			grade = "B+";
		else if(percentage < 87 && percentage >= 83)
			grade = "B";
		else if(percentage < 83 && percentage >= 80)
			grade = "B-";
		else if(percentage < 80 && percentage >= 77)
			grade = "C+";
		else if(percentage < 77 && percentage >= 73)
			grade = "C";
		else if(percentage < 73 && percentage >= 70)
			grade = "C-";
		else if(percentage < 70 && percentage >= 67)
			grade = "D+";
		else if(percentage < 67 && percentage >= 63)
			grade = "D";
		else if(percentage < 63 && percentage >= 60)
			grade = "D-";
		else
			grade = "F";
		return grade;
	}
}
