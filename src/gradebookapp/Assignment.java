package gradebookapp;

/**
 * <h1>Assignment</h1>
 * Assignment object class that holds the total score, current score,
 * and name.
 * @author david
 *
 */
public class Assignment 
{
	//fields
	private String name;
	private int totalScore;
	private int studentScore;
	private String categoryName;
	private boolean isEC;
	
	//default constructor
	/**
	 * Assignment default constructor.
	 */
	public Assignment()
	{
		name = "New Assignment";
		categoryName = "";
		totalScore = 0;
		studentScore = 0;
		isEC = false;
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
		studentScore = 0;
		isEC = false;
		categoryName = "";
	}
	
	/**
	 * Assignment constructor.
	 * @param name
	 * @param categoryName
	 * @param totalPoints
	 */
	public Assignment( String name, String categoryName, int totalPoints )
	{
		this.name = name;
		this.totalScore = totalPoints;
		studentScore = 0;
		isEC = false;
		this.categoryName = categoryName;
	}
	
	/**
	 * Assignment constructor.
	 * @param name
	 * @param totalScore
	 */
	public Assignment (String name)
	{
		this.name = name;
		categoryName = "";
		totalScore = 0;
		studentScore = 0;
		isEC = false;
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
	
	/**
	 * Returns if the assignment is extra credit or not.
	 * @return
	 */
	public boolean isExtraCredit()
	{
		return isEC;
	}
	
	/**
	 * Sets the assignment as extra credit or not.
	 * @param status
	 */
	public void setExtraCredit(boolean status)
	{
		isEC = status;
	}
	
	/**
	 * Get the category name for the assignment.
	 * @return
	 */
	public String getCategoryName()
	{
		return categoryName;
	}
	
	/**
	 * Set the category name for the assignment.
	 * @param name
	 */
	public void setCategoryName(String name)
	{
		categoryName = name;
	}

	/**
	 * Calculates the percentage grade on the assignment.
	 * @return
	 */
	public double calculatePercentage()
	{
		double percentage = 0;
		
		try
		{
			percentage = ((double)studentScore/(double)totalScore) * 100.0;
		}
		catch(ArithmeticException ex)
		{
			System.out.println(ex);
		}
		
		return percentage;
	}
	
	/**
	 * Get the letter grade of the assignment.
	 * @return
	 */
	public String getLetterScore()
	{
		double percentage = calculatePercentage();
		String grade = null;
		
		if(percentage >= 97)
			grade = "A+";
		else if(percentage < 97 && percentage >= 93)
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
