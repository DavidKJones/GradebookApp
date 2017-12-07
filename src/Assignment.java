
public class Assignment 
{
	//fields
	private String name;
	private int totalScore;
	private int studentScore;
	private Date dueDate;
	
	//default constructor
	/**
	 * Assignment default constructor.
	 */
	public Assignment()
	{
		name = "New Assignment";
		dueDate = new Date();
		totalScore = 0;
	}
	
	//parameterized constructors
	/**
	 * Assignment constructor.
	 * @param name
	 * @param totalPoints
	 */
	public Assignment( String name, int totalPoints )
	{
		this.name = name;
		this.totalScore = totalPoints;
	}
	
	/**
	 * Assignment constructor.
	 * @param name
	 * @param totalScore
	 */
	public Assignment (String name)
	{
		this.name = name;
		totalScore = 0;
	}
	
	//methods
	/**
	 * Get the total score for the assignment.
	 * @return integer value of points
	 */
	public int getTotalScore()
	{
		return totalScore;
	}
	
	/**
	 * Get the student score from the assignment.
	 * @return 
	 */
	public int getStudentScore()
	{
		return studentScore;
	}
	
	/**
	 * Set the student score for the assignment.
	 * @return 
	 */
	public void setStudentScore( int score)
	{
		studentScore = score;
	}
	
	/**
	 * Set total points for the assignment.
	 * @param points
	 * @return nothing
	 */
	public void setTotalScore( int score )
	{
		totalScore = score;
	}
	
	/**
	 * Get name for the assignment.
	 * @return <code>String</code> name
	 */
	public String getName()
	{
		return name; 
	}
	
	/**
	 * Set name for the assignment.
	 * @param name
	 * @return nothing
	 */
	public String setName( String name )
	{
		return name;
	}
}
