package gradebookapp;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

public class GradebookAssignmentGUI {

	private JFrame frame;
	String[] columns = new String[] {"Assignment name", "Total Points"};
	private JTable table;
	private JTable tableAssignment;
	private JPanel addAssignment = new JPanel();
	private JTextField assignment = new JTextField(7);
    private JTextField totalPoints = new JTextField(7);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradebookAssignmentGUI window = new GradebookAssignmentGUI();
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
	public GradebookAssignmentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addAssignment.add(new JLabel("Assignment Name:"));
		addAssignment.add(assignment);
		addAssignment.add(new JLabel("Assignment Score:"));
		addAssignment.add(totalPoints);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				assignment.setText(null);
				totalPoints.setText(null);
				int result = JOptionPane.showConfirmDialog(null, addAssignment, "Please Enter Assignment Name", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION)
			    {
					if (assignment.getText().matches("[a-zA-Z]") || totalPoints.getText().matches("[1-9]+"))
			    	{
						String assignmentName = assignment.getText();
						String assignmentPoints = totalPoints.getText();
						int numCols = tableAssignment.getModel().getColumnCount();
						Object[] Assignment = new Object[numCols + 1];
						Assignment[0] = assignmentName;
						Assignment[1] = assignmentPoints;
						
						((DefaultTableModel) tableAssignment.getModel()).addRow(Assignment);
					
						
						
			    	}
			    }
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("remove");
		
		JButton btnNewButton_2 = new JButton("edit");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(137)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)))
		);
		
		DefaultTableModel model = new DefaultTableModel();
		tableAssignment = new JTable(model);
		tableAssignment.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Assignment", "Total Points"
			}
		));

		scrollPane.setViewportView(tableAssignment);
		int numCols = tableAssignment.getModel().getColumnCount();
		Object[] Assignment = new Object[numCols + 1];
		Assignment[0] = "hard assignment";
		Assignment[1] = "15";
		/*ArrayList<Assignment> assignments = GradeBookGUI.gradebook.get(GradeBookGUI.cbGradeBookSelect.getSelectedIndex()).getAssignments();
		for( Assignment a : assignments )
		{
			((DefaultTableModel) tableAssignment.getModel()).addRow(new Object[]{a.getName(),a.getTotalScore()});	
		}*/
		frame.getContentPane().setLayout(groupLayout);
				
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		 
		
	}
}
