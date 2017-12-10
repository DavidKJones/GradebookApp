package gradebookapp;
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
	/**
	 * <h1><i>getAssignments</i></h1>
	 * <p>
	 * Get the entire list of assignments.
	 * @return array list of assignments
	 * @see Assignment
	 */
	static public ArrayList<Assignment> getAssignments()
	{
		//Integer integer = Integer.
		return assignments;
	}
	
	/**
	 * <h1><i>getAssignment</i></h1>
	 * <p>
	 * Gets the assignment from the list at the index.
	 * @param index index of assignment
	 * @return assignment at index
	 * @see Assignment
	 */
	static public Assignment getAssignment( int index )
	{
		return assignments.get(index);
	}
	
	/**
	 * Add an assignment to the assignment list.
	 * @param assignment Assignment
	 */
	static public void addAssignment( Assignment assignment )
	{
		assignments.add(assignment);
	}
	
	/**
	 * Remove an assignment from the assignment list.
	 * @param assignment Assignment
	 */
	static public void removeAssignment (Assignment assignment)
	{
		assignments.remove(assignments);
	}
	
	/**
	 * Remove assignment from the list by index.
	 * @param index index of assignment to be removed
	 */
	static public void removeAssignmentAt( int index )
	{
		assignments.remove(index);
	}
}
