import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import java.awt.Color;

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
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Hello", "World", "I'm", "Alive"},
			},
			new String[] {
				"Student ID", "Name", "Grade", "GPA"
				
			}
		));
		table.setBackground(Color.WHITE);
		table.setBounds(12, 13, 758, 94);
		frame.getContentPane().add(table);
	}
}
