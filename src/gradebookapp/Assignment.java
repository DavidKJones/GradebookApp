package gradebookapp;

import java.io.Serializable;

/**
 * <h1>Assignment</h1>
 * Assignment object class that holds the total score, current score,
 * and name.
 * @author david
 *
 */
@SuppressWarnings("serial")
public class Assignment implements Serializable
{
	//fields
	private String name;
	private int totalScore;
	private int studentScore;
	/**
	 * is the assignment extra credit
	 */
	private boolean isEC;
	
	//default constructor
	/**
	 * Assignment default constructor.
	 */
	public Assignment()
	{
		name = "New Assignment";
		totalScore = 0;
		studentScore = 0;
		isEC = false;
	}
	
	//parameterized constructors
	/**
	 * Assignment constructor with two parameters.
	 * @param name String
	 * @param totalPoints int
	 */
	public Assignment( String name, int totalPoints )
	{
		this.name = name;
		this.totalScore = totalPoints;
		studentScore = 0;
		isEC = false;
	}
	
	/**
	 * Assignment constructor with three parameters.
	 * @param name String
	 * @param categoryName String
	 * @param totalPoints int
	 */
	public Assignment( String name, String categoryName, int totalPoints )
	{
		this.name = name;
		this.totalScore = totalPoints;
		studentScore = 0;
		isEC = false;
	}
	
	/**
	 * Assignment constructor with one parameter.
	 * @param name String
	 */
	public Assignment (String name)
	{
		this.name = name;
		totalScore = 0;
		studentScore = 0;
		isEC = false;
	}
	
	//methods
	/**
	 * Get the total score for the assignment.
	 * @return integer value of total score for an assignment
	 */
	public int getTotalScore()
	{
		return totalScore;
	}
	
	/**
	 * Get the student score from the assignment.
	 * @return integer value of the student score
	 */
	public int getStudentScore()
	{
		return studentScore;
	}
	
	/**
	 * Set the student score for the assignment.
	 * @param score int
	 */
	public void setStudentScore( int score)
	{
		studentScore = score;
	}
	
	/**
	 * Set total points for the assignment.
	 * @param score int
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
	 * @param name String
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**
	 * Returns if the assignment is extra credit or not.
	 * @return whether the assignment is extra credit or not
	 */
	public boolean isExtraCredit()
	{
		return isEC;
	}
	
	/**
	 * Sets the assignment as extra credit or not.
	 * @param status boolean
	 */
	public void setExtraCredit(boolean status)
	{
		isEC = status;
	}

	/**
	 * Calculates the percentage grade on the assignment.
	 * @return double value of percentage
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
	 * @return string letter grade
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
