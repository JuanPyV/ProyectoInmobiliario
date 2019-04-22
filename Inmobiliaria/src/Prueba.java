import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Prueba {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba window = new Prueba();
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
	public Prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(chckbxNewCheckBox)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_1)
									.addComponent(btnNewButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(146)
							.addComponent(rdbtnNewRadioButton)))
					.addContainerGap(278, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1)
					.addGap(51)
					.addComponent(chckbxNewCheckBox)
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addComponent(rdbtnNewRadioButton)
					.addGap(45))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
