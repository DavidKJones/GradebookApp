package gradebookapp;

import java.util.ArrayList;

/**
 * <h1>CategoryGradebook</h1>
 * gradebook class that calculates grades with category weight.
 * @author david
 *
 */
@SuppressWarnings("serial")
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
	 * Check to see if all the weights from the categories add up to 100%.
	 * @return
	 */
	public boolean weightsAddUpToHundred()
	{
		double weight = 0;
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
	public double calculateStudentPercentage( Student student ) 
	{
		double percentage = 0.0;
		
		for( GradebookCategory c : categories)
		{ 
			double categoryPercentage = 0.0;
			int numberOfAssignments = 0;
			for( Assignment a : student.getAssignments())
			{			
				if(a.getCategoryName() == c.getName())
				{
					numberOfAssignments++;
					categoryPercentage += a.calculatePercentage();
					System.out.println(a.getName() + " - " + a.calculatePercentage());
				}
			}
			categoryPercentage /= (double)numberOfAssignments;
			System.out.print(categoryPercentage);
			percentage += categoryPercentage * (c.getWeight() / (double)100);
		}
		
		return percentage;
	}
	
	@Override
	public String getGrade( Student student ) 
	{
		double percentage = calculateStudentPercentage( student );
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
