package gradebookapp;

public class Test extends Assignment 
{
	//default constructor
	public Test()
	{
		super("New Quiz");
	}
	
	//parameterized constructors
	public Test(String name)
	{
		super(name);
	}
	
	public Test( String name, int totalPoints )
	{
		super(name, totalPoints);
	}
}
