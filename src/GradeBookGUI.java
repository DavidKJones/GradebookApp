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

public class GradeBookGUI {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<Student> student = new ArrayList<Student>();
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmExit;

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
		
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		student.add(new Student("S0001", "John Doe"));
		student.add(new Student("S0002", "Jane Doe"));
		student.add(new Student("S0003", "Bob Joe"));
		student.add(new Student("S0004", "Nathan Smith"));
		
		frame.setSize(800, 500);
		frame.getContentPane().setLayout(null);
		//table = new JTable(rowData, columnNames);
		table = new JTable(
				new DefaultTableModel(new Object[]{"Student Number", "Name" , "Percentage", "Grade"}, 0)
				{
					public boolean isCellEditable(int row, int column)
				    {
				      return false;//This causes all cells to be not editable
				    }
				}
				);
		table.setSelectionMode(0);
		model = (DefaultTableModel)table.getModel();
		updateTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 782, 380);
		frame.getContentPane().add(scrollPane);
		
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
		
		JButton button = new JButton("Assignments");
		button.setIcon(new ImageIcon(GradeBookGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(10, 387, 133, 29);
		frame.getContentPane().add(button);
		
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
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = JOptionPane.showInputDialog("Enter the students name");
				student.add(new Student("S"+0001, name));
				model.addRow(new Object[] {student.get(student.size()-1).getIdNumber(), student.get(student.size()-1).getName(), null, null});
			}
		});
	}
	
	/*
	 * Set up the table
	 */
	void updateTable()
	{
		for(int i = 0; i < student.size();i++)
		{
			model.addRow(new Object[] {student.get(i).getIdNumber(), student.get(i).getName(), null, null});
		}
	}
}
