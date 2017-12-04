import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

public class GradeBookGUI {

	private JFrame frame;
	private JTable table;
	private Object[][] rowData = null; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeBookGUI window = new GradeBookGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GradeBookGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 167);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Testing adding student object to table
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		
		/*
		 * Set up the table
		 */
		String columnNames[] = {"Student ID", "Name", "GPA", "Letter Grade"};
		
		addStudentToTable(student.get(0));
		addStudentToTable(student.get(1));
		addStudentToTable(student.get(3));
		
		frame.setSize(800, 500);
		table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	/*
	 * Add student to multi-demensional array dynamically
	 */
	void addStudentToTable( Student student )
	{
		/*
		 * Adding student to multi-dimensional array
		 */	
		if(rowData == null)
		{
			Object[][] newRowData = {{ student.getIdNumber(), student.getName(), null, null}};
			rowData = newRowData;
		}
		else
		{
			int rows = rowData.length;
			Object[][] newRowData = new Object[rows + 1][4];
			
			for(int j = 0; j < rowData.length; j++)
			{
				newRowData[j][0] = rowData[j][0].toString();
				newRowData[j][1] = rowData[j][1].toString();
				newRowData[j][2] = null;
				newRowData[j][3] = null;
			}
			
			newRowData[rows][0] = student.getIdNumber();
			newRowData[rows][1] = student.getName();
			newRowData[rows][2] = null;
			newRowData[rows][3] = null;
			
			rowData = newRowData;	
		}	
	}
}
