package gradebookapp;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * <h1>GradeBookSerializaton</h1>
 * Class that serializes the grade books.
 * @author david
 */
public class GradeBookSerialization 
{
	public static Path savePath = null;
	
	/**
	 * Save grade book data using JFileChooser into a .ser file.
	 */
	public static void saveGradeBooksAs()
	{
	      JFileChooser fileChooser = new JFileChooser();
	      
	      fileChooser.setFileSelectionMode(
	         JFileChooser.FILES_AND_DIRECTORIES);
	      
	      FileNameExtensionFilter filter = new FileNameExtensionFilter(
	    		    "*.ser files", "ser");
	      
	      fileChooser.setFileFilter(filter);
	      
	      int result = fileChooser.showSaveDialog(null);
	
	      if(result == JFileChooser.CANCEL_OPTION)
	      {
	    	  return;
	      }
	
	      // return Path representing the selected file
	      Path path = fileChooser.getSelectedFile().toPath();
	      
	      if(path == null)
	      {
	    	  return;
	      }
	      
	      serializeGradeBooks(GradeBookGUI.gradebook, path.toString());
	      savePath = path;
	}
	
	/**
	 * Save grade book data at the latest save path.
	 */
	public static void saveGradeBooks()
	{
	      if(savePath == null)
	      {
	    	  saveGradeBooksAs();
	      }
	      else
	      {
		      serializeGradeBooks(GradeBookGUI.gradebook, savePath.toString());  
	      }
	}
	
	/**
	 * Open a serialized file to get grade book data.
	 * returns the list of grade books
	 */
	public static void openGradeBooks()
	{
	      JFileChooser fileChooser = new JFileChooser();
	           
	      FileNameExtensionFilter filter = new FileNameExtensionFilter(
	    		    "*.ser files", "ser");
	      
	      fileChooser.setFileFilter(filter);
	      
	      fileChooser.setFileSelectionMode(
	 	         JFileChooser.FILES_AND_DIRECTORIES);
	      
	      int result = fileChooser.showOpenDialog(null);
	      
	      if(result == JFileChooser.CANCEL_OPTION)
	      {
	    	  return;
	      }
	
	      // return Path representing the selected file
	      Path path = fileChooser.getSelectedFile().toPath();
	      
	      if(path == null)
	      {
	    	  return;
	      }
	      
	      GradeBookGUI.gradebook = deserializeGradeBooks(path.toString());
	      savePath = path;
	}
	
	/**
	 * Serializes the grade book into a .ser file.
	 * @param fileName
	 * @serialData gradebooks
	 */
	private static void serializeGradeBooks( ArrayList<GradeBook> gradeBooks, String fileName )
	{
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(gradeBooks);
			out.close();
		}
		catch(IOException exception)
		{
			JOptionPane.showMessageDialog(null, "Failed to save file.", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("Problem occured during serialization.");
			System.out.println(exception.getMessage());
		}
	}
	
	/**
	 * Deserializes file that contains grade book data.
	 * @param fileName
	 * @return gradeBooks
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
			JOptionPane.showMessageDialog(null, "Failed to open file.", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println("A problem occured during deserialization.");
			System.out.println(exception.getMessage());
		}
		
		return gradeBooks;
	}
}
