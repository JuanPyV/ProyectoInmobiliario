import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMain extends JPanel {

	private JFrame frameV;
	private Image imagen;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMain window = new VentanaMain();
					window.frameV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMain() {
		initialize();


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameV = new JFrame();
		frameV.setBounds(100, 100, 650, 490);
		frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		JLabel lblNewLabel = new JLabel("Inmobiliaria");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));

		JPanel panel = new JPanel();
		this.imagen = new ImageIcon("inmobiliaria.png").getImage();


		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar.main(null);

			}
		});

		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar.main(null);

			}
		});

		JButton btnNewButton_2 = new JButton("Ver Datos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaDatos.main(null);
			}
		});

		JButton btnNewButton_3 = new JButton("Borrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Borrar.main(null);
			}
		});


		ImageIcon imagen = new ImageIcon("src/inmobiliaria.png");
		Image image = imagen.getImage();
		Image newimg = image.getScaledInstance(650, 360,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imagencita = new ImageIcon(newimg);
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(imagencita);

		GroupLayout groupLayout = new GroupLayout(frameV.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(btnNewButton)
					.addGap(49)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(50)
					.addComponent(btnNewButton_3)
					.addGap(112))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(245)
					.addComponent(lblNewLabel)
					.addContainerGap(253, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addGap(34)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(129, Short.MAX_VALUE))
		);
		frameV.getContentPane().setLayout(groupLayout);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.imagen, 100, 100, this);

	}
}
