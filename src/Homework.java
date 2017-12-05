
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
	 * @param name
	 * @param totalPoints
	 */
	public Homework(String name, int totalPoints) 
	{
		super(name, totalPoints);
	}

	/**
	 * 
	 * @param name
	 */
	public Homework(String name) 
	{
		super(name);
	}

}
