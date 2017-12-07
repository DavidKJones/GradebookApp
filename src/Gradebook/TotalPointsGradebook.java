package Gradebook;

/**
 * <h1>TotalPointsGradebook</h1>
 * Simple grade book class that calculates grade by totalpoints.
 * @author david
 *
 */
public class TotalPointsGradebook extends Gradebook 
{
	//constructors
	/**
	 * 
	 */
	public TotalPointsGradebook()
	{
		super();
		setName("New Total Points Gradebook");
	}
	
	/**
	 * 
	 */
	public TotalPointsGradebook( String name )
	{
		super();
		setName(name);
	}
	
	/**
	 * 
	 */
	@Override
	public void addAssignment()
	{
		getAssignments().add(new Assignment());
	}
	
	
	/**
	 * 
	 */
	@Override
	public double calculateStudentGrade() 
	{
		int studentPoints = 0;
		int totalPoints = 0;
		
		return studentPoints / totalPoints;
	}
}
