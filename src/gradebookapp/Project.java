package gradebookapp;

/**
 * 
 * @author david
 *
 */
public class Project extends Assignment 
{
	//default constructor
	/**
	 * 
	 */
	public Project() 
	{
		super("New Project");
	}

	/**
	 * 
	 * @param name String
	 * @param totalPoints int
	 */
	public Project(String name, int totalPoints) 
	{
		super(name, totalPoints);
	}

	/**
	 * 
	 * @param name String
	 */
	public Project(String name) 
	{
		super(name);
	}

}
