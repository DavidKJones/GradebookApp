package gradebookapp;


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
	private double weight;
	
	//constructors
	/**
	 * default constructor
	 */
	public GradebookCategory()
	{
		name = "new category";
		weight = 0.0;
	}
	
	/**
	 * constructor with one parameter
	 * @param name string
	 */
	public GradebookCategory( String name )
	{
		this.name = name;
		weight = 0.0;
	}
	
	/**
	 * constructor with two parameters
	 * @param name string
	 * @param weight double
	 */
	public GradebookCategory( String name, double weight )
	{
		this.name = name;
		this.weight = weight;
	}
	
	/** Sets the weight for a category
	 * @param weight double
	 */
	public void setWeight( double weight )
	{
		this.weight = weight;
	}
	
	/**get the category's weight
	 * @return the weight of a category
	 */
	public double getWeight ()
	{
		return weight;
	}
	
	/**changes the name of the category
	 * @param name string
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**get the category's name
	 * @return name of the category
	 */
	public String getName()
	{
		return name;
	}
}
