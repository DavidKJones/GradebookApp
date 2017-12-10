package gradebookapp;

/**
 * 
 * @author david
 *
 */
public class Homework extends Assignment 
{
	//default constructor
	/**
	 * 
	 */
	public Homework() 
	{
		super("New Homework Assignment");
	}

	/**
	 * 
	 * @param name String
	 * @param totalPoints int
	 */
	public Homework(String name, int totalPoints) 
	{
		super(name, totalPoints);
	}

	/**
	 * 
	 * @param name String
	 */
	public Homework(String name) 
	{
		super(name);
	}

}
