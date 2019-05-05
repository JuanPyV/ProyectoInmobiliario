import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Buscar {

	private JFrame frameB;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar window = new Buscar();
					window.frameB.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Buscar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameB = new JFrame();
		frameB.setBounds(100, 100, 630, 630);

		JLabel lblBuscar = new JLabel("Busqueda");
		lblBuscar.setFont(new Font("Dialog", Font.BOLD, 24));

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		JLabel lblNewLabel = new JLabel("Referencia");

		JLabel lblTipo = new JLabel("Tipo");

		JLabel lblNewLabel_1 = new JLabel("Operacion");

		JLabel lblProvincia = new JLabel("Provincia");

		JLabel lblSuperficie = new JLabel("Superficie");

		JLabel lblPrecioVenta = new JLabel("Precio Venta");

		JLabel lblFechaVenta = new JLabel("Fecha Venta");

		JLabel lblVendedor = new JLabel("Vendedor");

		JTextPane textPane = new JTextPane();
		JScrollPane textPaneScroll = new JScrollPane(textPane);
		textPane.setEditable(false);

		JButton btnBuscar = new JButton("Buscar Referencia");
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LecturaCSV datos = new LecturaCSV();
				datos.insertarDatos(new File("src/Inmuebles.csv"));
				datosInmobiliaria objeto = datos.encontrar(textField.getText());
				textPane.setText(
						"Referencia, Tipo, Operacion, Provincia, Superficie, Precio Venta, Fecha Venta, Vendedor  \n"
								+ objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
								+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio()
								+ ", " + objeto.getFechaV() + ", " + objeto.getVendedor());

			}
		});

		JButton btnBuscarTipo = new JButton("Buscar Tipo");
		btnBuscarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaCSV datos = new LecturaCSV();
				datos.insertarDatos(new File("src/Inmuebles.csv"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorTipo(textField_1.getText());
				String datosCompletos = "Referencia, Tipo, Operacion, Provincia, Superficie, Precio Venta, Fecha Venta, Vendedor \n";
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					datosCompletos = datosCompletos + datosList;
				}
				textPane.setText(datosCompletos);
			}
		});

		JButton btnBuscarVendedor = new JButton("Buscar Vendedor");
		btnBuscarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaCSV datos = new LecturaCSV();
				datos.insertarDatos(new File("src/Inmuebles.csv"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorVendedor(textField_7.getText());
				String datosCompletos = "Referencia, Tipo, Operacion, Provincia, Superficie, Precio Venta, Fecha Venta, Vendedor \n";
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					datosCompletos = datosCompletos + datosList;
				}
				textPane.setText(datosCompletos);
			}
		});

		JButton btnBuscarTipoprovincia = new JButton("Buscar Tipo-Provincia");
		btnBuscarTipoprovincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturaCSV datos = new LecturaCSV();
				datos.insertarDatos(new File("src/Inmuebles.csv"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorTipoProv(textField_1.getText(),
						textField_1.getText());
				String datosCompletos = "Referencia, Tipo, Operacion, Provincia, Superficie, Precio Venta, Fecha Venta, Vendedor \n";
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					datosCompletos = datosCompletos + datosList;
				}
				textPane.setText(datosCompletos);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frameB.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(textPaneScroll,
								GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup().addGap(34).addComponent(lblBuscar)
								.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
										.addComponent(lblTipo).addComponent(lblNewLabel_1).addComponent(lblProvincia)
										.addComponent(lblSuperficie).addComponent(lblPrecioVenta)
										.addComponent(lblFechaVenta).addComponent(lblVendedor))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_4, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_6, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(53)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(btnBuscarTipoprovincia)
														.addComponent(btnBuscarVendedor).addComponent(btnBuscarTipo)
														.addComponent(btnBuscar))))
								.addGap(19)))
				.addGap(33)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel).addComponent(lblBuscar).addComponent(btnBuscar))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTipo))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1).addComponent(btnBuscarTipo))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProvincia))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnBuscarVendedor))
										.addComponent(lblSuperficie))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecioVenta))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFechaVenta).addComponent(btnBuscarTipoprovincia))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblVendedor))
								.addGap(56)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(44, Short.MAX_VALUE)));
		frameB.getContentPane().setLayout(groupLayout);
	}
}
