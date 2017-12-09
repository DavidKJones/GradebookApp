
import java.util.ArrayList;

/**
 * <h1>CategoryGradebook</h1>
 * gradebook class that calculates grades with category weight.
 * @author david
 *
 */
public class CategoryGradebook extends GradeBook 
{
	//private fields
	public ArrayList<GradebookCategory> categories;
	
	//constructors
	/**
	 * 
	 */
	public CategoryGradebook()
	{
		super();
		setName("New Category Gradebook");
		categories = new ArrayList<GradebookCategory>();
	}
	
	/**
	 * 
	 */
	public CategoryGradebook( String name )
	{
		super();
		setName(name);
		categories = new ArrayList<GradebookCategory>();
	}
	
	/**
	 * 
	 */
	public void addCategory(GradebookCategory category)
	{
		categories.add(category);
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public GradebookCategory getCategory(int index)
	{
		GradebookCategory category = null;		
		try
		{
			category = categories.get(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
		
		return category;
	}
	
	/**
	 * 
	 * @param category
	 */
	public void removeCategory(GradebookCategory category)
	{
		categories.remove(category);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeCategoryAt(int index)
	{
		try
		{
			categories.remove(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void addAssignment()
	{
		try
		{
			if(categories.size() < 1)
				throw new NoCategoryException();
			
			getAssignments().add(new CategoryAssignment());	
		}
		catch(NoCategoryException ex)
		{
			System.out.print(ex);
		}
	}
	
	/**
	 * Check to see if all the weights from the categories add up to 100%.
	 * @return
	 */
	public boolean weightsAddUpToHundred()
	{
		int weight = 0;
		for( int i = 0; i < categories.size(); i++)
		{
			weight += categories.get(0).getWeight();	
		}
		
		if(weight > 100 || weight < 100)
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public double calculateStudentGrade() 
	{
		return 0;
	}
	
}
