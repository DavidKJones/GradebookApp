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
	 * 
	 */
	public TotalPointsGradeBook()
	{
		super();
		setName("New Total Points Gradebook");
	}
	
	/**
	 * 
	 */
	public TotalPointsGradeBook( String name )
	{
		super();
		setName(name);
	}
	
	//calculates student grade by total points system
	@Override
	public double calculateStudentPercentage( Student student ) 
	{
		double totalpoints = 0;
		double studentTotal = 0;
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
			percentage = (studentTotal / totalpoints) * 100;
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex);
		}
		
		return percentage;
	}
	
	//get the overall grade of the student
	public String getGrade( Student student )
	{
		double percentage = calculateStudentPercentage( student );
		String grade = null;
		
		if(percentage >= 97)
			grade = "A+";
		else if(percentage < 96 && percentage >= 93)
			grade = "A";
		else if(percentage < 93 && percentage >= 90)
			grade = "A-";
		else if(percentage < 89 && percentage >= 87)
			grade = "B+";
		else if(percentage < 86 && percentage >= 83)
			grade = "B";
		else if(percentage < 82 && percentage >= 80)
			grade = "B-";
		else if(percentage < 79 && percentage >= 77)
			grade = "C+";
		else if(percentage < 76 && percentage >= 73)
			grade = "C";
		else if(percentage < 72 && percentage >= 70)
			grade = "C-";
		else if(percentage < 69 && percentage >= 67)
			grade = "D+";
		else if(percentage < 66 && percentage >= 63)
			grade = "D";
		else if(percentage < 62 && percentage >= 60)
			grade = "D-";
		else
			grade = "F";
		return grade;
	}
}
