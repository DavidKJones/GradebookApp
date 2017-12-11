package gradebookapp;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;


public class GradebookAssignmentGUI extends JFrame{

	private JFrame frmAssignments;
	String[] columns = new String[] {"Assignment name", "Total Points"};
	private JTable atable;
	private JTable stable;
	private CellEditor cell;
	private JPanel addAssignment = new JPanel();
	private JScrollPane scrollPaneAssignments;
	private JScrollPane scrollPaneStudents;
	private DefaultTableModel modelAssignments;
	private DefaultTableModel modelStudents;
	private GradeBook gb = GradeBookGUI.gradebook.get(GradeBookGUI.cbGradeBookSelect.getSelectedIndex());
	private JTextField txtAsgnName;
	private JTextField txtTotalPoints;
	
	/**
	 * Launch the application.
	 */
	public static void create() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradebookAssignmentGUI window = new GradebookAssignmentGUI();
					window.frmAssignments.setVisible(true);
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
	@SuppressWarnings("serial")
	private void initialize() {
		GradeBookGUI.cbGradeBookSelect.setEnabled(false);
		GradeBookGUI.menuBar.setEnabled(false);
		frmAssignments = new JFrame();
		frmAssignments.setTitle("Assignments");
		frmAssignments.setIconImage(Toolkit.getDefaultToolkit().getImage(GradebookAssignmentGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		frmAssignments.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAssignments.setBounds(100, 100, 800, 500);
		
		//assignments table
		atable = new JTable(new DefaultTableModel(new Object[]{"Name", "Total Points"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		atable.setSelectionMode(0);
		modelAssignments = (DefaultTableModel)atable.getModel();
		atable.getColumnModel().getColumn(0).setPreferredWidth(120);
		atable.getColumnModel().getColumn(1).setPreferredWidth(20);
		frmAssignments.getContentPane().setLayout(null);
		scrollPaneAssignments = new JScrollPane(atable);
		scrollPaneAssignments.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneAssignments.setBounds(12, 13, 318, 389);
		frmAssignments.getContentPane().add(scrollPaneAssignments);
		buildAssignmentTable();
		
		//students table
		stable = new JTable(new DefaultTableModel(new Object[]{"Name", "Earned Points", "Percent", "Grade"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
				return column == 1;//This causes all cells to be not editable
		    }
		});
		
		stable.setSelectionMode(0);
		modelStudents = (DefaultTableModel)stable.getModel();
		stable.getColumnModel().getColumn(0).setPreferredWidth(40);
		stable.getColumnModel().getColumn(1).setPreferredWidth(40);
		stable.getColumnModel().getColumn(2).setPreferredWidth(40);
		stable.getColumnModel().getColumn(3).setPreferredWidth(40);
		frmAssignments.getContentPane().setLayout(null);
		scrollPaneStudents = new JScrollPane(stable);
		scrollPaneStudents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneStudents.setBounds(342, 113, 428, 289);
		frmAssignments.getContentPane().add(scrollPaneStudents);
		stable.setCellEditor(new DefaultCellEditor(new JTextField()));
		cell = stable.getCellEditor();
		
		//Buttons
		JButton btnAddAssignment = new JButton("Add");
		btnAddAssignment.setIcon(new ImageIcon(GradebookAssignmentGUI.class.getResource("/image/add.gif")));
		btnAddAssignment.setBounds(12, 415, 97, 25);
		frmAssignments.getContentPane().add(btnAddAssignment);
		
		JButton btnDeleteAssignment = new JButton("Delete");
		btnDeleteAssignment.setEnabled(false);
		btnDeleteAssignment.setIcon(new ImageIcon(GradebookAssignmentGUI.class.getResource("/image/minus.gif")));
		btnDeleteAssignment.setBounds(124, 415, 97, 25);
		frmAssignments.getContentPane().add(btnDeleteAssignment);
		
		JButton btnEditAssignment = new JButton("Edit");
		btnEditAssignment.setEnabled(false);
		btnEditAssignment.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/image/wrench.gif")));
		btnEditAssignment.setBounds(233, 415, 97, 25);
		frmAssignments.getContentPane().add(btnEditAssignment);
		
		txtAsgnName = new JTextField();
		txtAsgnName.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsgnName.setFont(new Font("Dialog", Font.PLAIN, 30));
		txtAsgnName.setEditable(false);
		txtAsgnName.setBounds(342, 56, 283, 44);
		frmAssignments.getContentPane().add(txtAsgnName);
		txtAsgnName.setColumns(10);
		
		txtTotalPoints = new JTextField();
		txtTotalPoints.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPoints.setFont(new Font("Dialog", Font.PLAIN, 30));
		txtTotalPoints.setEditable(false);
		txtTotalPoints.setBounds(637, 56, 133, 44);
		frmAssignments.getContentPane().add(txtTotalPoints);
		txtTotalPoints.setColumns(10);
		
		JLabel lblAssignmentName = new JLabel("Assignment Name");
		lblAssignmentName.setFont(new Font("Dialog", Font.BOLD, 26));
		lblAssignmentName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignmentName.setBounds(342, 13, 283, 30);
		frmAssignments.getContentPane().add(lblAssignmentName);
		
		JLabel lblTotalPoints = new JLabel("Points");
		lblTotalPoints.setFont(new Font("Dialog", Font.BOLD, 26));
		lblTotalPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPoints.setBounds(637, 13, 133, 30);
		frmAssignments.getContentPane().add(lblTotalPoints);
		
		JButton btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.setIcon(new ImageIcon(GradebookAssignmentGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnSave.setBounds(673, 415, 97, 25);
		frmAssignments.getContentPane().add(btnSave);
		
		//Add assignment panel
		JTextField name = new JTextField(7);
		SpinnerModel sm = new SpinnerNumberModel(0, 0, 999, 1); //default value,lower bound,upper bound,increment by
		JSpinner spinner = new JSpinner(sm);
		Component mySpinnerEditor = spinner.getEditor();
		JFormattedTextField jftf = ((JSpinner.DefaultEditor) mySpinnerEditor).getTextField();
		jftf.setColumns(3);
		addAssignment.add(new JLabel("Assignment Name:"));
		addAssignment.add(name);
		addAssignment.add(new JLabel("Total Points:"));
		addAssignment.add(spinner);
		
		//add assignment
		btnAddAssignment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				name.setText(null);
				spinner.setValue(0);
				int result = JOptionPane.showConfirmDialog(null, addAssignment, "Enter name and total points", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION)
			    {
				    int total = (Integer)spinner.getValue();
			    	gb.addAssignment(new Assignment(name.getText(),total));
			    	modelAssignments.addRow(new Object[] {gb.getAssignmentAt((gb.getAssignments().size()-1)).getName(),
			    						gb.getAssignmentAt((gb.getAssignments().size()-1)).getTotalScore()});
			    }
			}
		});
		
		//delete the current assignment
		btnDeleteAssignment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				gb.removeAssignment(gb.getAssignmentAt(atable.getSelectedRow()));
				modelAssignments.removeRow(atable.getSelectedRow());
				if(gb.getAssignments().size()==0)
				{
					btnDeleteAssignment.setEnabled(false);
					btnEditAssignment.setEnabled(false);
				}
			}
		});
		
		//edit assignment
		btnEditAssignment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				name.setText(atable.getValueAt(atable.getSelectedRow(), 0).toString());
				spinner.setValue(atable.getValueAt(atable.getSelectedRow(), 1));
				int result = JOptionPane.showConfirmDialog(null, addAssignment, "Change name and total points", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION)
			    {
			    	int total = (Integer) spinner.getValue();
			    	gb.getAssignmentAt(atable.getSelectedRow()).setName(name.getText());
			    	modelAssignments.setValueAt(name.getText(), atable.getSelectedRow(), 0);
			    	modelAssignments.setValueAt(total, atable.getSelectedRow(), 1);
			    }
			}
		});
		
		//save grades
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int score;
				for(int i = 0;i<stable.getRowCount();i++)
				{
					try
					{
						String regex = "[0-9]+";
						if(!stable.getValueAt(i, 1).toString().matches(regex))
						{
							throw new InvalidScoreException();
						}
						
						score = Integer.parseInt(stable.getValueAt(i, 1).toString());
						gb.getStudent(i).getAssignment(atable.getSelectedRow()).setStudentScore(score);
					}
					catch(InvalidScoreException ex)
					{
						JOptionPane.showMessageDialog(null, stable.getValueAt(i, 0)+ "'s score has an invalid score of " + stable.getValueAt(i, 1).toString(), "invalid input", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				GradeBookGUI.buildStudentTable();
				buildStudentTable();
			}
		});
		
		//Grabs the data from the row and populates the text on the right
		atable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
		    @Override
		    public void valueChanged(ListSelectionEvent event)
		    {
		    	if(atable.getRowCount()>0)
		    	{
		    		btnDeleteAssignment.setEnabled(true);
					btnEditAssignment.setEnabled(true);
		    	} else {
		    		btnDeleteAssignment.setEnabled(false);
					btnEditAssignment.setEnabled(false);
		    	}
		    	txtAsgnName.setText(atable.getValueAt(atable.getSelectedRow(), 0).toString());
		    	txtTotalPoints.setText(atable.getValueAt(atable.getSelectedRow(), 1).toString());
		    	buildStudentTable();
		    }
		});
		
		//Sets the save button to enable and disabled depending on whether a student is selected
				atable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
				{
				    @Override
				    public void valueChanged(ListSelectionEvent event)
				    {
				    	if(atable.getRowCount()>0)
				    	{
				    		btnSave.setEnabled(true);
				    	} else {
							btnSave.setEnabled(false);
				    	}
				    }
				});
		//close assignment window and re-enable the main window
		frmAssignments.addWindowListener(new java.awt.event.WindowAdapter()
		{
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent)
		    {
		    	GradeBookGUI.cbGradeBookSelect.setEnabled(true);
		    	GradeBookGUI.menuBar.setEnabled(true);
		    }
		});
	}
	
	//build the table
	void buildAssignmentTable()
	{
		if(gb.getAssignments().size()>0)
		{
			for(int i = 0;i<gb.getAssignments().size();i++)
			{
				modelAssignments.addRow(new Object[] {gb.getAssignmentAt((i)).getName(),gb.getAssignmentAt(i).getTotalScore()});
			}
		}
	}
	
	//build the table
	void buildStudentTable()
	{
		if(stable.getRowCount()>0)
		{
			if(modelStudents.getRowCount()>0)
			{
				modelStudents.setRowCount(0);
			}
		}
		if(gb.getStudents().size()>0)
		{
			for(int i = 0;i<gb.getStudents().size();i++)
			{
				modelStudents.addRow(new Object[] {gb.getStudent(i).getFirstName() + " " + gb.getStudent(i).getLastName(),
													gb.getStudent(i).getAssignment(atable.getSelectedRow()).getStudentScore(),
													gb.getStudent(i).getAssignment(atable.getSelectedRow()).calculatePercentage(),
													gb.getStudent(i).getAssignment(atable.getSelectedRow()).getLetterScore()});
			}
		}
	}
}
