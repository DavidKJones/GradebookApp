package gradebookapp;

/**<h1>CategoryAssignment</h1>
 * 
 * @author david
 *
 */
public class CategoryAssignment extends Assignment 
{
	private String category;
	
	/**sets category
	 * @param category String
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	/**gets this category
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}
}
