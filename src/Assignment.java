
public class Assignment 
{
	//fields
	private String name;
	private int totalScore;
	private int studentScore;
	
	//default constructor
	/**
	 * Assignment default constructor.
	 */
	public Assignment()
	{
		name = "New Assignment";
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
	
	/**
	 * Get the percentage grade on the assignment.
	 * @return
	 */
	public double getPercentScore()
	{
		double percentage = 0;
		
		try
		{
			percentage = studentScore / totalScore;
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
		double percentage = getPercentScore();
		String grade = null;
		
		if(percentage <= 100 && percentage >= 97)
			grade = "A+";
		else if(percentage <= 96 && percentage >= 93)
			grade = "A";
		else if(percentage <= 93 && percentage >= 90)
			grade = "A-";
		else if(percentage <= 89 && percentage >= 87)
			grade = "B+";
		else if(percentage <= 86 && percentage >= 83)
			grade = "B";
		else if(percentage <= 82 && percentage >= 80)
			grade = "B-";
		else if(percentage <= 79 && percentage >= 77)
			grade = "C+";
		else if(percentage <= 76 && percentage >= 73)
			grade = "C";
		else if(percentage <= 72 && percentage >= 70)
			grade = "C-";
		else if(percentage <= 69 && percentage >= 67)
			grade = "D+";
		else if(percentage <= 66 && percentage >= 63)
			grade = "D";
		else if(percentage <= 62 && percentage >= 60)
			grade = "D-";
		else
			grade = "F";
		
		return grade;
	}
}
