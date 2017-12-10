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
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;

public class GradeBookGUI {

	private JFrame frame;
	private JFrame frame2;
	private JScrollPane scrollPaneStudents;
	private JScrollPane scrollPaneAssignments;
	private JTable tableStudents;
	private JTable tableAssignments;
	private JPanel addStudent = new JPanel();
	private DefaultTableModel modelAssignments;
	private DefaultTableModel modelStudents;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JTextField txtStudentName;
	private JTextField txtStudentId;
	private JTextField txtGrade;
	private JTextField txtPercentage;
	private ArrayList<GradeBook> gradebook = new ArrayList<GradeBook>();
	private TotalPointsGradeBook totalGradeBook;
	private JTextField first = new JTextField(7);
    private JTextField last = new JTextField(7);


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
		totalGradeBook = new TotalPointsGradeBook();
		
		frame = new JFrame("Students");
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 167);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(848, 500);
		frame.getContentPane().setLayout(null);
		totalGradeBook.addAssignment(new Assignment("test",25));
		totalGradeBook.addStudent(new Student("S0000", null, null));
		
		//add student dialog 
		addStudent.add(new JLabel("First:"));
		addStudent.add(first);
		addStudent.add(new JLabel("Last:"));
		addStudent.add(last);
		
		/*
		 * creates the students table and model
		 */
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
		tableStudents.setAutoCreateRowSorter(true);
		scrollPaneStudents = new JScrollPane(tableStudents);
		scrollPaneStudents.setBounds(10, 44, 422, 345);
		frame.getContentPane().add(scrollPaneStudents);
		
		/*
		 * creates the assignments table for that particular student 
		 */
		tableAssignments = new JTable(new DefaultTableModel(new Object[]{"Name", "Total Points" , "Percent"}, 0)
		{
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		});
		
		tableAssignments.setSelectionMode(0);
		modelAssignments = (DefaultTableModel)tableAssignments.getModel();
		scrollPaneAssignments = new JScrollPane(tableAssignments);
		scrollPaneAssignments.setBounds(444, 248, 386, 141);
		frame.getContentPane().add(scrollPaneAssignments);
		
		/*
		 * 
		 * Buttons and Menus
		 * 
		 */
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//btnSave.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnSave.setBounds(733, 401, 97, 29);
		frame.getContentPane().add(btnSave);
		
		JButton btnAdd = new JButton("Add");
		//btnAdd.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(515, 401, 97, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		//btnEdit.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/images/wrench.gif")));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.setBounds(624, 401, 97, 29);
		frame.getContentPane().add(btnEdit);
		
		JButton btnAssignments = new JButton("Assignments");
		//btnAssignments.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		btnAssignments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAssignments.setBounds(10, 401, 133, 29);
		frame.getContentPane().add(btnAssignments);
		
		JLabel lblAssignments = new JLabel("Assignments");
		lblAssignments.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignments.setFont(new Font("Dialog", Font.BOLD, 24));
		lblAssignments.setBounds(444, 210, 386, 32);
		frame.getContentPane().add(lblAssignments);
		
		txtStudentName = new JTextField();
		txtStudentName.setEditable(false);
		txtStudentName.setFont(new Font("Dialog", Font.PLAIN, 56));
		txtStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentName.setBounds(444, 12, 386, 60);
		frame.getContentPane().add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentId = new JTextField();
		txtStudentId.setEditable(false);
		txtStudentId.setFont(new Font("Dialog", Font.PLAIN, 36));
		txtStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentId.setBounds(444, 84, 386, 38);
		frame.getContentPane().add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtGrade = new JTextField();
		txtGrade.setEditable(false);
		txtGrade.setFont(new Font("Dialog", Font.PLAIN, 54));
		txtGrade.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrade.setBounds(733, 134, 97, 64);
		frame.getContentPane().add(txtGrade);
		txtGrade.setColumns(10);
		
		txtPercentage = new JTextField();
		txtPercentage.setEditable(false);
		txtPercentage.setFont(new Font("Dialog", Font.PLAIN, 54));
		txtPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercentage.setBounds(444, 134, 277, 64);
		frame.getContentPane().add(txtPercentage);
		txtPercentage.setColumns(10);
		
		JComboBox cbGradeBookSelect = new JComboBox();
		cbGradeBookSelect.setToolTipText("Select a Gradebook");
		cbGradeBookSelect.setBounds(10, 12, 116, 25);
		frame.getContentPane().add(cbGradeBookSelect);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		//mntmOpen.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		mnFile.add(mntmOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		//mntmSave.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As");
		//mntmSaveAs.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		mnFile.add(mntmSaveAs);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		mntmExit = new JMenuItem("Exit");
		//mntmExit.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		//mntmAbout.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/images/about.gif")));
		mnHelp.add(mntmAbout);
		frame.setVisible(true);
		
		/*
		 * 
		 * Action Listeners
		 * 
		 */
		tableStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent event) {
		        if (tableStudents.getSelectedRow() > -1) {
		        	txtStudentId.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 0).toString());
		        	txtStudentName.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 1).toString()
		        						+ " "
		        						+ tableStudents.getValueAt(tableStudents.getSelectedRow(), 2).toString());
		        	txtPercentage.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 3).toString());
		        	txtGrade.setText(tableStudents.getValueAt(tableStudents.getSelectedRow(), 4).toString());
		        }
		    }
		});
		
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				first.setText(null);
				last.setText(null);
				int result = JOptionPane.showConfirmDialog(null, addStudent, "Please Enter Students Name", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION)
			    {
			    	if (first.getText().matches("[a-zA-Z]") || last.getText().matches("[a-zA-Z]+"))
			    	{
			    		String firstName = first.getText();
				    	String lastName = last.getText();
				    	String value = totalGradeBook.getStudent(totalGradeBook.getStudents().size()-1).getIdNumber().replaceAll("[^0-9]", "");
						int temp = Integer.parseInt(value)+1;
						String formatted = String.format("%04d", temp);
						totalGradeBook.addStudent(new Student("S"+formatted, firstName, lastName));
						modelStudents.addRow(new Object[] {totalGradeBook.getStudent(totalGradeBook.getStudents().size()-1).getIdNumber(), 
								totalGradeBook.getStudent(totalGradeBook.getStudents().size()-1).getFirstName(), 
								totalGradeBook.getStudent(totalGradeBook.getStudents().size()-1).getLastName(), 
								totalGradeBook.calculateStudentPercentage(totalGradeBook.getStudent(totalGradeBook.getStudents().size()-1)),
								totalGradeBook.getGrade(totalGradeBook.getStudent(totalGradeBook.getStudents().size()-1))});
			    	} else {
			    		JOptionPane.showMessageDialog(null, "Student must have a first and last name containing only letters. \n"
			    									+ "                                        Please try agian."
			    									, "Error", JOptionPane.ERROR_MESSAGE);
			    	}
			    }
			}
		});
		
		btnAssignments.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				createAssignnmentFrame();
			}
		});
		
		mntmOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GradeBookSerialization.openGradeBooks();
			}
		});
		
		mntmSaveAs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GradeBookSerialization.saveGradeBooks(gradebook, gradebook.toString());
			}
		});
		
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				GradeBookSerialization.saveGradeBooks(gradebook, gradebook.toString());
			}
		});
	}
	
	
	
	/*
	 * Set up the table
	 */
//	void buildStudentTable()
//	{
//		if(modelStudents.getRowCount()>0)
//		{
//			for(int i = 0;i<modelStudents.getRowCount();i++)
//			{
//				modelStudents.removeRow(i);
//			}
//		}
//		for(int i = 0; i < student.size();i++)
//		{
//			modelStudents.addRow(new Object[] {student.get(i).getIdNumber(), student.get(i).getFirstName(), student.get(i).getLastName(), null, null});
//		}
//	}
	
	private void createAssignnmentFrame()
	{
		frame2 = new JFrame("Assignments");
		frame2.getContentPane().setLayout(null);
		frame2.setBounds(100, 100, 800, 167);
		frame2.setSize(800, 500);
		frame2.setVisible(true);
	}
}
