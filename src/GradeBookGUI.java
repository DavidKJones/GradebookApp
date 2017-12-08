import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.omg.CORBA.INITIALIZE;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.ScrollPane;
import java.awt.Panel;

public class GradeBookGUI {

	private JFrame frame;
	private JFrame frame2;
	private JScrollPane scrollPaneStudents;
	private JScrollPane scrollPaneAssignments;
	private JTable tableStudents;
	private JTable tableAssignments;
	private DefaultTableModel model;
	private ArrayList<Student> student = new ArrayList<Student>();
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JTextField txtStudentName;
	private JTextField txtStudentId;
	private JTextField txtGrade;
	private JTextField txtPercentage;


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
		
		
		frame = new JFrame("Students");
		frame.setBounds(100, 100, 800, 167);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.getContentPane().setLayout(null);
		
		tableAssignments = new JTable(new DefaultTableModel(new Object[]{"Name", "Total Points" , "Percent"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		tableAssignments.setSelectionMode(0);
		model = (DefaultTableModel)tableAssignments.getModel();
		buildTable();
		scrollPaneAssignments = new JScrollPane(tableAssignments);
		scrollPaneAssignments.setBounds(384, 248, 386, 132);
		frame.getContentPane().add(scrollPaneAssignments);
		
		tableStudents = new JTable(new DefaultTableModel(new Object[]{"Student ID", "Name" , "Percent", "Grade"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		tableStudents.setSelectionMode(0);
		model = (DefaultTableModel)tableStudents.getModel();
		tableStudents.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableStudents.getColumnModel().getColumn(1).setPreferredWidth(156);
		tableStudents.getColumnModel().getColumn(2).setPreferredWidth(40);
		tableStudents.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableStudents.setAutoCreateRowSorter(true);
		buildTable();
		scrollPaneStudents = new JScrollPane(tableStudents);
		scrollPaneStudents.setBounds(10, 12, 368, 368);
		frame.getContentPane().add(scrollPaneStudents);
		
		student.add(new Student("S0000", null));
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnSave.setBounds(673, 385, 97, 29);
		frame.getContentPane().add(btnSave);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(455, 385, 97, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/images/wrench.gif")));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.setBounds(564, 385, 97, 29);
		frame.getContentPane().add(btnEdit);
		
		JButton btnAssignments = new JButton("Assignments");
		btnAssignments.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		btnAssignments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAssignments.setBounds(10, 387, 133, 29);
		frame.getContentPane().add(btnAssignments);
		
		JLabel lblAssignments = new JLabel("Assignments");
		lblAssignments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignments.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAssignments.setBounds(384, 210, 386, 32);
		frame.getContentPane().add(lblAssignments);
		
		txtStudentName = new JTextField();
		txtStudentName.setEditable(false);
		txtStudentName.setFont(new Font("Dialog", Font.PLAIN, 56));
		txtStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentName.setBounds(384, 12, 386, 60);
		frame.getContentPane().add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentId = new JTextField();
		txtStudentId.setEditable(false);
		txtStudentId.setFont(new Font("Dialog", Font.PLAIN, 36));
		txtStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentId.setBounds(384, 84, 386, 38);
		frame.getContentPane().add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtGrade = new JTextField();
		txtGrade.setEditable(false);
		txtGrade.setFont(new Font("Dialog", Font.PLAIN, 54));
		txtGrade.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrade.setBounds(673, 134, 97, 64);
		frame.getContentPane().add(txtGrade);
		txtGrade.setColumns(10);
		
		txtPercentage = new JTextField();
		txtPercentage.setEditable(false);
		txtPercentage.setFont(new Font("Dialog", Font.PLAIN, 54));
		txtPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercentage.setBounds(384, 134, 277, 64);
		frame.getContentPane().add(txtPercentage);
		txtPercentage.setColumns(10);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		mnFile.add(mntmSaveAs);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/images/about.gif")));
		mnHelp.add(mntmAbout);
		frame.setVisible(true);
		
		
		
		//Action Listeners
		tableStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (tableStudents.getSelectedRow() > -1) {
		        	txtStudentName.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 1).toString());
		        	txtStudentId.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 0).toString());
		        	txtPercentage.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 2).toString());
		        	txtGrade.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 3).toString());
		        }
		    }
		});
		
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter the students name");
				String value = student.get(student.size()-1).getIdNumber().replaceAll("[^0-9]", "");
				int temp = Integer.parseInt(value)+1;
				String formatted = String.format("%04d", temp);
				student.add(new Student("S"+formatted, name));
				model.addRow(new Object[] {student.get(student.size()-1).getIdNumber(), student.get(student.size()-1).getName(), 100.00, "A+"});
			}
		});
		
		btnEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				buildTable();
			}
		});
		
		btnAssignments.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				createAssignnmentFrame();
			}
		});
	}
	
	/*
	 * Set up the table
	 */
	void buildTable()
	{
		if(model.getRowCount()>0)
		{
			for(int i = 0;i<model.getRowCount();i++)
			{
				model.removeRow(i);
			}
		}
		for(int i = 0; i < student.size();i++)
		{
			model.addRow(new Object[] {student.get(i).getIdNumber(), student.get(i).getName(), null, null});
		}
	}
	
	private void createAssignnmentFrame()
	{
		frame2 = new JFrame("Assignments");
		frame2.getContentPane().setLayout(null);
		frame2.setBounds(100, 100, 800, 167);
		frame2.setSize(800, 500);
		frame2.setVisible(true);
	}
}
