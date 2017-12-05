
public class Assignment 
{
	//fields
	private String name;
	private int totalPoints;
	//Create a date class//
	
	//default constructor
	/**
	 * Assignment default constructor.
	 */
	public Assignment()
	{
		name = "New Assignment";
		totalPoints = 0;
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
		this.totalPoints = totalPoints;
	}
	
	/**
	 * Assignment constructor.
	 * @param name
	 * @param totalPoints
	 */
	public Assignment (String name)
	{
		this.name = name;
		totalPoints = 0;
	}
	
	//methods
	/**
	 * Get total points for the assignment.
	 * @return integer value of points
	 */
	public int getTotalPoints()
	{
		return totalPoints;
	}
	
	/**
	 * Set total points for the assignment.
	 * @param points
	 * @return nothing
	 */
	public void setTotalPoints( int points )
	{
		totalPoints = points;
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
