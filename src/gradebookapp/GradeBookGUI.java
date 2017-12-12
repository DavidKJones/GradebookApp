package gradebookapp;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class GradeBookGUI
{
	public static JFrame frmGradeBook;
	private JScrollPane scrollPaneStudents;
	private JScrollPane scrollPaneStudentAssignments;
	private static JTable tableStudents;
	private JTable tableAssignments;
	private static DefaultTableModel modelStudents;
	private static DefaultTableModel modelAssignments;
	private JPanel addStudent = new JPanel();
	private JMenuBar menuBar;
	private JMenu mnFile;
	public static JMenu mnEdit;
	public static JComboBox<GradeBook> cbGradeBookSelect = new JComboBox<GradeBook>();
	private JTextField txtStudentName;
	private JTextField txtStudentId;
	private JTextField txtGrade;
	private JTextField txtPercentage;
	public static JButton btnAssignments;
	public static ArrayList<GradeBook> gradebook = new ArrayList<GradeBook>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@SuppressWarnings("static-access")
			public void run()
			{
				try
				{
					GradeBookGUI window = new GradeBookGUI();
					window.frmGradeBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GradeBookGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		
		frmGradeBook = new JFrame("Students");
		frmGradeBook.setIconImage(Toolkit.getDefaultToolkit().getImage(GradeBookGUI.class.getResource("/image/gradebook.png")));
		frmGradeBook.setTitle("Grade Book");
		frmGradeBook.setResizable(false);
		frmGradeBook.setBounds(100, 100, 800, 167);
		frmGradeBook.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmGradeBook.setSize(848, 500);
		frmGradeBook.getContentPane().setLayout(null);

		//Student Table
		tableStudents = new JTable(new DefaultTableModel(new Object[]{"Student ID", "First", "Last" , "Percent", "Grade"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		tableStudents.setSelectionMode(0);
		modelStudents = (DefaultTableModel)tableStudents.getModel();
		tableStudents.getColumnModel().getColumn(0).setPreferredWidth(53);
		tableStudents.getColumnModel().getColumn(1).setPreferredWidth(78);
		tableStudents.getColumnModel().getColumn(2).setPreferredWidth(78);
		tableStudents.getColumnModel().getColumn(3).setPreferredWidth(40);
		tableStudents.getColumnModel().getColumn(4).setPreferredWidth(30);
		scrollPaneStudents = new JScrollPane(tableStudents);
		scrollPaneStudents.setBounds(10, 50, 422, 345);
		frmGradeBook.getContentPane().add(scrollPaneStudents);

		//Table of assignments for that student
		tableAssignments = new JTable(new DefaultTableModel(new Object[]{"Name", "Score" , "Percent", "Grade"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		tableAssignments.setSelectionMode(0);
		modelAssignments = (DefaultTableModel)tableAssignments.getModel();
		scrollPaneStudentAssignments = new JScrollPane(tableAssignments);
		scrollPaneStudentAssignments.setToolTipText("");
		scrollPaneStudentAssignments.setBounds(444, 254, 386, 141);
		frmGradeBook.getContentPane().add(scrollPaneStudentAssignments);
		
		btnAssignments = new JButton("Assignments");
		btnAssignments.setEnabled(false);
		btnAssignments.setToolTipText("View list of assignments");
		btnAssignments.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/javafx/scene/web/skin/UnorderedListBullets_16x16_JFX.png")));
		btnAssignments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAssignments.setBounds(10, 401, 133, 29);
		frmGradeBook.getContentPane().add(btnAssignments);
		
		JLabel lblAssignments = new JLabel("Assignments");
		lblAssignments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignments.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAssignments.setBounds(444, 210, 386, 32);
		frmGradeBook.getContentPane().add(lblAssignments);
		
		JTextField first = new JTextField(7);
		JTextField last = new JTextField(7);
		addStudent.add(new JLabel("First:"));
		addStudent.add(first);
		addStudent.add(new JLabel("Last:"));
		addStudent.add(last);
		
		txtStudentName = new JTextField();
		txtStudentName.setToolTipText("Student's Name");
		txtStudentName.setEditable(false);
		txtStudentName.setFont(new Font("Dialog", Font.PLAIN, 48));
		txtStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentName.setBounds(444, 12, 386, 60);
		frmGradeBook.getContentPane().add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentId = new JTextField();
		txtStudentId.setToolTipText("Student's ID");
		txtStudentId.setEditable(false);
		txtStudentId.setFont(new Font("Dialog", Font.PLAIN, 36));
		txtStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentId.setBounds(444, 84, 386, 38);
		frmGradeBook.getContentPane().add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtGrade = new JTextField();
		txtGrade.setToolTipText("Student's Grade");
		txtGrade.setEditable(false);
		txtGrade.setFont(new Font("Dialog", Font.PLAIN, 54));
		txtGrade.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrade.setBounds(733, 134, 97, 64);
		frmGradeBook.getContentPane().add(txtGrade);
		txtGrade.setColumns(10);
		
		txtPercentage = new JTextField();
		txtPercentage.setToolTipText("Student's Percentage");
		txtPercentage.setEditable(false);
		txtPercentage.setFont(new Font("Dialog", Font.PLAIN, 54));
		txtPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercentage.setBounds(444, 134, 277, 64);
		frmGradeBook.getContentPane().add(txtPercentage);
		txtPercentage.setColumns(10);
		
		cbGradeBookSelect.setToolTipText("Select a Gradebook");
		cbGradeBookSelect.setBounds(78, 12, 116, 25);
		for(int i = 0;i<gradebook.size();i++)
		{
			cbGradeBookSelect.addItem(gradebook.get(i));
		}
		frmGradeBook.getContentPane().add(cbGradeBookSelect);
		
		JLabel lblGradebook = new JLabel("Gradebook:");
		lblGradebook.setBounds(10, 12, 71, 26);
		frmGradeBook.getContentPane().add(lblGradebook);
		
		menuBar = new JMenuBar();
		frmGradeBook.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		mntmSaveAs.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		mnFile.add(mntmSaveAs);
		
		mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAddGradebook = new JMenuItem("Add Gradebook");
		mntmAddGradebook.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/image/add.gif")));
		mnEdit.add(mntmAddGradebook);
		
		JMenuItem mntmAddStudent = new JMenuItem("Add Student");
		mntmAddStudent.setEnabled(false);
		mntmAddStudent.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/image/add.gif")));
		mnEdit.add(mntmAddStudent);
		
		JMenuItem mntmDeleteGradebook = new JMenuItem("Delete Gradebook");
		mntmDeleteGradebook.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/image/minus.gif")));
		mntmDeleteGradebook.setEnabled(false);
		mnEdit.add(mntmDeleteGradebook);
		
		JMenuItem mntmDeleteStudent = new JMenuItem("Delete Student");
		mntmDeleteStudent.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/image/minus.gif")));
		mntmDeleteStudent.setEnabled(false);
		mnEdit.add(mntmDeleteStudent);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/image/about.gif")));
		mnHelp.add(mntmAbout);
		frmGradeBook.setVisible(true);
		
		/*
		 * Action Listeners
		 */
		
		//Grabs the data from the row and populates the text on the right
		tableStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event)
		    {
		        if (tableStudents.getSelectedRow() > -1)
		        {
		        	txtStudentId.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 0).toString());
		        	txtStudentName.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 1).toString()
		        				+ " " + tableStudents.getValueAt(tableStudents.getSelectedRow(), 2).toString());
		        	double percent = Double.parseDouble(tableStudents.getValueAt(tableStudents.getSelectedRow(), 3).toString());
		        	txtPercentage.setText(String.format("%.2f", percent)+"%");
		        	txtGrade.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 4).toString());
		        	buildAssignmentTable();
		        }
		    }

		});
		
		//Open the serialized gradebook array
		mntmOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GradeBookSerialization.openGradeBooks();
				updateGradeBookComboBox();
				mntmAddGradebook.setEnabled(true);
				if(gradebook.size() > 0)
				{
					cbGradeBookSelect.setSelectedIndex(0);
					mntmDeleteGradebook.setEnabled(true);
					mntmAddStudent.setEnabled(true);
					if(gradebook.get(cbGradeBookSelect.getSelectedIndex()).getStudents().size() > 0)
					{
						mntmDeleteStudent.setEnabled(true);
						btnAssignments.setEnabled(true);
					}
					mntmSave.setToolTipText(GradeBookSerialization.savePath.toString());	
				}
			}
		});
		
		mntmSaveAs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GradeBookSerialization.saveGradeBooksAs();
				mntmSave.setToolTipText(GradeBookSerialization.savePath.toString());
			}
		});
		
		//save the gradebook array
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GradeBookSerialization.saveGradeBooks();
				mntmSave.setToolTipText(GradeBookSerialization.savePath.toString());
			}
		});
		
		//add student
		mntmAddStudent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//add student dialog
				first.setText(null);
				last.setText(null);
				int result = JOptionPane.showConfirmDialog(null, addStudent, "Please Enter Students Name", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION)
			    {
			    	//validate the name for only letters
			    	if (first.getText().matches("[a-zA-Z]") || last.getText().matches("[a-zA-Z]+"))
			    	{
			    		String firstName = first.getText();
				    	String lastName = last.getText();
				    	String value;
				    	GradeBook gb = gradebook.get(cbGradeBookSelect.getSelectedIndex());
				    	if(gb.getStudents().size() > 0)
				    	{
				    		value = gb.getStudent(gb.getStudents().size()-1).getIdNumber().replaceAll("[^0-9]", "");
				    	} else {
				    		value = "0000";
				    	}
						int temp = Integer.parseInt(value)+1;
						String formatted = String.format("%04d", temp);
						gb.addStudent(new Student("S"+formatted, firstName, lastName));
						modelStudents.addRow(new Object[] {gb.getStudent(gb.getStudents().size()-1).getIdNumber(), 
								gb.getStudent(gb.getStudents().size()-1).getFirstName(), 
								gb.getStudent(gb.getStudents().size()-1).getLastName(), 
								gb.calculateStudentPercentage(gb.getStudent(gb.getStudents().size()-1)),
								gb.getGrade(gb.getStudent(gb.getStudents().size()-1))});
						txtStudentId.setText("");
			        	txtStudentName.setText("");
			        	txtPercentage.setText("");
			        	txtGrade.setText("");
						mntmDeleteStudent.setEnabled(true);
			    	} else {
			    		JOptionPane.showMessageDialog(null, "Student must have a first and last name containing only letters. \n"
			    									+ "                                        Please try agian."
			    									, "Error", JOptionPane.ERROR_MESSAGE);
			    	}
			    }
			}
		});
		
		//delete student currently selected
		mntmDeleteStudent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gradebook.get(cbGradeBookSelect.getSelectedIndex()).removeStudentAt(tableStudents.getSelectedRow());
				modelStudents.removeRow(tableStudents.getSelectedRow());
				txtStudentId.setText("");
	        	txtStudentName.setText("");
	        	txtPercentage.setText("");
	        	txtGrade.setText("");
				if(gradebook.get(cbGradeBookSelect.getSelectedIndex()).getStudents().size()==0)
				{
					mntmDeleteStudent.setEnabled(false);
				}
			}
		});
		
		//about button
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Created by: Ayrton Flores, David Jones, & Mason Parry", "About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		//Grade Book combo box
		cbGradeBookSelect.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent itemEvent)
			{
				txtStudentId.setText("");
	        	txtStudentName.setText("");
	        	txtPercentage.setText("");
	        	txtGrade.setText("");
				if(cbGradeBookSelect.getSelectedIndex() != -1)
				{
					buildStudentTable();
					buildAssignmentTable();
				}
			}
		});
		
		//add grade book
		mntmAddGradebook.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog(null, "Please Enter name of gradebook: ", "", JOptionPane.OK_CANCEL_OPTION);
			    if(name != null)
			    {
			    	txtStudentId.setText("");
		        	txtStudentName.setText("");
		        	txtPercentage.setText("");
		        	txtGrade.setText("");
			    	gradebook.add(new TotalPointsGradeBook(name));
			    	mntmAddStudent.setEnabled(true);
			    	mntmDeleteGradebook.setEnabled(true);
			    	updateGradeBookComboBox();
			    	cbGradeBookSelect.setSelectedIndex(cbGradeBookSelect.getItemCount()-1);
					mntmSave.setEnabled(true);
					mntmSaveAs.setEnabled(true);
					btnAssignments.setEnabled(true);
			    }
			}
		});
		
		//delete grade book
		mntmDeleteGradebook.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete: "+gradebook.get(cbGradeBookSelect.getSelectedIndex()), "Confirm", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION)
		        {
		        	txtStudentId.setText("");
		        	txtStudentName.setText("");
		        	txtPercentage.setText("");
		        	txtGrade.setText("");
		        	gradebook.remove(gradebook.get(cbGradeBookSelect.getSelectedIndex()));
		        	updateGradeBookComboBox();
		        	if(cbGradeBookSelect.getItemCount()<1)
		        	{
		        		modelAssignments.setRowCount(0);
		        		modelStudents.setRowCount(0);
		        		mntmDeleteGradebook.setEnabled(false);
		        		mntmDeleteStudent.setEnabled(false);
		        		mntmAddStudent.setEnabled(false);
		        		btnAssignments.setEnabled(false);
		        	}
		        }
			}
		});
		
		//closing the program
		frmGradeBook.addWindowListener(new java.awt.event.WindowAdapter()
		{
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent)
		    {
		    	int result = JOptionPane.showConfirmDialog(frmGradeBook,"Are you sure you want to exit the application?",
		    			"Exit Application",JOptionPane.YES_NO_OPTION);
		
		        if (result == JOptionPane.YES_OPTION)
		        {
		        	frmGradeBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        }
		    }
		});
		
		//Goto assignments window
		btnAssignments.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				 gradebookapp.GradebookAssignmentGUI.create();
			}
		});
	}
	
	/**
	 * Updates the list of the grade book combo box list.
	 */
	private void updateGradeBookComboBox()
	{
		//removes all gradebooks from the list if they exist
		if (cbGradeBookSelect.getItemCount() > 0)
		{
			cbGradeBookSelect.removeAllItems();
		}
		//rebuilds the list for the combobox
		for(int i = 0;i<gradebook.size();i++)
		{
			cbGradeBookSelect.addItem(gradebook.get(i));
		}
	}

	/**
	 * Builds the visual table of students on screen.
	 */
	public static void buildStudentTable()
	{
		//remove all students if they exist from the table
		if(modelStudents.getRowCount()>0)
		{
			modelStudents.setRowCount(0);
		}

		//rebuild the table
		GradeBook gb = gradebook.get(cbGradeBookSelect.getSelectedIndex());
		for(int i = 0; i < gb.getStudents().size();i++)
		{
			double percent = gb.calculateStudentPercentage(gb.getStudent(i));
        	String percentText = String.format("%.2f", percent);
			modelStudents.addRow(new Object[] {gb.getStudent(i).getIdNumber(), 
					gb.getStudent(i).getFirstName(), 
					gb.getStudent(i).getLastName(), 
					percentText,
					gb.getGrade(gb.getStudent(i))});
		}
	}
	
	/**
	 * Builds the visual table for assignments for that particular student on the screen.
	 */
	public static void buildAssignmentTable()
	{
		//check if the assignment table is empty, and if not make it empty
		GradeBook gb = gradebook.get(cbGradeBookSelect.getSelectedIndex());
		if(modelAssignments.getRowCount()>0)
		{
			modelAssignments.setRowCount(0);
		}
		
		//rebuild the table
		if(gb.getAssignments().size()>0)
		{
			if(tableStudents.isCellSelected(tableStudents.getSelectedRow(), tableStudents.getSelectedColumn()))
			{
				for(int i = 0;i<gb.getAssignments().size();i++)
				{
					double percent = gb.getStudent(tableStudents.getSelectedRow()).getAssignment(i).calculatePercentage();
		        	String percentText = String.format("%.2f", percent);
					modelAssignments.addRow(new Object[] {gb.getAssignmentAt(i).getName(),
							gb.getStudent(tableStudents.getSelectedRow()).getAssignment(i).getStudentScore() + " / " + gb.getAssignmentAt(i).getTotalScore(),
							percentText,
							gb.getStudent(tableStudents.getSelectedRow()).getAssignment(i).getLetterScore()});
				}
			}
		}
	}
}
