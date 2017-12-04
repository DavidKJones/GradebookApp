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
		//Rows (Added dynamically)
		Object[][] rowData = {{student.get(0).getIdNumber(), student.get(0).getName(), null, null}
							 ,{student.get(1).getIdNumber(), student.get(1).getName(), null, null}
							 ,{student.get(2).getIdNumber(), student.get(2).getName(), null, null}
							 ,{student.get(3).getIdNumber(), student.get(3).getName(), null, null}};
//		for(int i = 0;i<student.size();i++)
//		{
//			rowData[i] = student.toArray();
//		}
		
		
		frame.setSize(800, 500);
		table = new JTable(rowData, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
