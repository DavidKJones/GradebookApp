import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JFileChooser;

/**
 * <h1>GradeBookSerializaton</h1>
 * Class that serializes the grade books.
 * @author david
 */
public class GradeBookSerialization 
{
	/**
	 * Save grade book data into a .ser file.
	 */
	public static void saveGradeBooks( ArrayList<GradeBook> gradeBooks, String fileName )
	{
	      JFileChooser fileChooser = new JFileChooser();
	      
	      fileChooser.setFileSelectionMode(
	         JFileChooser.FILES_AND_DIRECTORIES);
	      
	      int result = fileChooser.showSaveDialog(null);
	
	      if (result == JFileChooser.CANCEL_OPTION)
	         System.exit(1);
	
	      // return Path representing the selected file
	      Path path = fileChooser.getSelectedFile().toPath();
	      serializeGradeBooks(gradeBooks, path.toString());
	}
	
	/**
	 * Open a serialized file to get grade book data.
	 * @return list of grade books
	 */
	public static ArrayList<GradeBook> openGradeBooks()
	{
	      JFileChooser fileChooser = new JFileChooser();
	      
	      fileChooser.setFileSelectionMode(
	         JFileChooser.FILES_AND_DIRECTORIES);
	      
	      int result = fileChooser.showOpenDialog(null);
	
	      if (result == JFileChooser.CANCEL_OPTION)
	         System.exit(1);
	
	      // return Path representing the selected file
	      Path path = fileChooser.getSelectedFile().toPath();
	      return deserializeGradeBooks(path.toString());
	}
	
	/**
	 * Serializes the grade book into a .ser file.
	 * @param fileName
	 */
	@SuppressWarnings("resource")
	private static void serializeGradeBooks( ArrayList<GradeBook> gradeBooks, String fileName )
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
	@SuppressWarnings("unchecked")
	private static ArrayList<GradeBook> deserializeGradeBooks(String fileName)
	{
		ArrayList<GradeBook> gradeBooks = null;
		
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			gradeBooks = (ArrayList<GradeBook>)in.readObject();
			in.close();
		}
		catch(IOException | ClassNotFoundException exception)
		{
			System.out.println("A problem occured during deserialization.");
			System.out.println(exception.getMessage());
		}
		
		return gradeBooks;
	}
}
