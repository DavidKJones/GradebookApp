import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * <h1>GradeBookSerializaton</h1>
 * Class that serializes the grade books.
 * @author david
 */
public class GradeBookSerialization 
{
	/**
	 * Serializes the grade book into a .ser file.
	 * @param fileName
	 */
	@SuppressWarnings("resource")
	public static void serializeGradeBooks( ArrayList<GradeBook> gradeBooks, String fileName )
	{
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName+".ser"));
			out.writeObject(gradeBooks);
		}
		catch(IOException exception)
		{
			System.out.println("Problem occured during serialization.");
			System.out.println(exception.getMessage());
		}
	}
	
	/**
	 * Deserializes file that contains grade book data.
	 * @param fileName
	 * @return
	 */
	public static ArrayList<GradeBook> deserializedGradeBooks(String fileName)
	{
		ArrayList<GradeBook> gradeBooks = null;
		
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			gradeBooks = (ArrayList<GradeBook>)in.readObject();
		}
		catch(IOException | ClassNotFoundException exception)
		{
			System.out.println("A problem occured during deserialization.");
			System.out.println(exception.getMessage());
		}
		
		return gradeBooks;
	}
}
