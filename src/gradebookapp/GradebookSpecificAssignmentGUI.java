package gradebookapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class GradebookSpecificAssignmentGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<GradeBook> gradebook = new ArrayList<GradeBook>();
	private ArrayList<Student> students = new ArrayList<Student>
	private TotalPointsGradeBook totalGradeBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradebookSpecificAssignmentGUI frame = new GradebookSpecificAssignmentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GradebookSpecificAssignmentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 224);
		contentPane.add(scrollPane);
		totalGradeBook.addAssignment(new Assignment("test",25));
		totalGradeBook.addStudent(new Student("S0000", null, null));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student", "Score/Total", "%"
			}
		));
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
	}

}
