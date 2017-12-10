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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;


public class GradebookAssignmentGUI extends JFrame{

	private JFrame frame;
	String[] columns = new String[] {"Assignment name", "Total Points"};
	private JTable table;
	private JPanel addAssignment = new JPanel();
	private JTextField assignment = new JTextField(7);
    private JTextField totalPoints = new JTextField(7);
	private JScrollPane scrollPaneStudents;
	private DefaultTableModel modelStudents;
	private JPanel addStudent = new JPanel();
	
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
		frame.setBounds(100, 100, 557, 480);
		
		table = new JTable(new DefaultTableModel(new Object[]{"Name", "Total Points"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		table.setSelectionMode(0);
		modelStudents = (DefaultTableModel)table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(1).setPreferredWidth(78);
		scrollPaneStudents = new JScrollPane(table);
		scrollPaneStudents.setBounds(12, 13, 510, 345);
		frame.getContentPane().add(scrollPaneStudents);
				
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddAssignment = new JButton("Add Assignment");
		btnAddAssignment.setIcon(new ImageIcon(GradebookAssignmentGUI.class.getResource("/image/add.gif")));
		btnAddAssignment.setBounds(12, 371, 162, 25);
		frame.getContentPane().add(btnAddAssignment);
		
		JButton btnDeleteAssignment = new JButton("Delete Assignment");
		btnDeleteAssignment.setIcon(new ImageIcon(GradebookAssignmentGUI.class.getResource("/image/minus.gif")));
		btnDeleteAssignment.setBounds(186, 371, 162, 25);
		frame.getContentPane().add(btnDeleteAssignment);
		
		JButton btnEditAssignment = new JButton("Edit Assignment");
		btnEditAssignment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditAssignment.setSelectedIcon(new ImageIcon(GradebookAssignmentGUI.class.getResource("/image/wrench.gif")));
		btnEditAssignment.setBounds(360, 371, 162, 25);
		frame.getContentPane().add(btnEditAssignment);
		
		JTextField name = new JTextField(7);
		JTextField total = new JTextField(7);
		addStudent.add(new JLabel("Name:"));
		addStudent.add(name);
		addStudent.add(new JLabel("Total Points:"));
		addStudent.add(total);
		
		btnAddAssignment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				name.setText(null);
				t.setText(null);
				int result = JOptionPane.showConfirmDialog(null, addStudent, "Please Enter Students Name", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION)
			    {
			}
		}});
		
		btnEditAssignment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		btnDeleteAssignment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
	}
}
