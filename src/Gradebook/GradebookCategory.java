package Gradebook;

/**
 * <h1>Gradebook Category</h1>
 * Category object for CategoryGradebook.
 * @author david
 *
 */
public class GradebookCategory 
{
	//private fields
	private String name;
	private int weight;
	
	//constructors
	/**
	 * 
	 */
	public GradebookCategory()
	{
		name = "new category";
		weight = 0;
	}
	
	/**
	 * 
	 */
	public GradebookCategory( String name )
	{
		this.name = name;
		weight = 0;
	}
	
	/**
	 * 
	 */
	public GradebookCategory( String name, int weight )
	{
		this.name = name;
		this.weight = weight;
	}
	
	/**
	 * 
	 * @param weight
	 */
	public void setWeight( double weight )
	{
		
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWeight ()
	{
		return weight;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}
}
