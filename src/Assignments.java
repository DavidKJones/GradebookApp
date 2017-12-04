import java.util.ArrayList;

/**
 * class that keeps track of all assignments.
 * @author david
 */
public class Assignments 
{
	//Fields
	static private ArrayList<Assignment> assignments;
	
	//Methods
	static public ArrayList<Assignment> getAssignments()
	{
		return assignments;
	}
	
	/**
	 * Gets a specific assignment by index.
	 * @return
	 */
	static public Assignment getAssignment( int index )
	{
		return assignments.get(index);
	}
	
	/**
	 * Add an assignment to the assignment list.
	 * @return
	 */
	static public void addAssignment( Assignment assignment )
	{
		assignments.add(assignment);
	}
	
	/**
	 * Remove an assignment from the assignment list.
	 * @return
	 */
	static public void removeAssignment (Assignment assignment)
	{
		assignments.remove(assignments);
	}
	
	/**
	 * Remove assignment from the list by index.
	 * @return
	 */
	static public void removeAssignmentAt( int index )
	{
		assignments.remove(index);
	}
}
