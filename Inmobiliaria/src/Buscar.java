import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.NoSuchElementException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;

public class Buscar {

	private JFrame frameB;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTable table;

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
		frameB.setBounds(100, 100, 879, 824);

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

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		JLabel lblNewLabel = new JLabel("Referencia");

		JLabel lblTipo = new JLabel("Tipo");

		JLabel lblNewLabel_1 = new JLabel("Operacion");

		JLabel lblProvincia = new JLabel("Provincia");

		JLabel lblSuperficie = new JLabel("Superficie");

		JLabel lblPrecioVenta = new JLabel("Precio Venta");

		JLabel lblVendedor = new JLabel("Vendedor");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Referencia", "Tipo", "Operacion", "Provincia", "Superficie", "Precio Venta", "Fecha Venta",
				"Vendedor" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table);
		if (table.getColumnModel().getColumnCount() > 0) {
			table.getColumnModel().getColumn(0).setHeaderValue("Referencia");
			table.getColumnModel().getColumn(1).setHeaderValue("Tipo");
			table.getColumnModel().getColumn(2).setHeaderValue("Operacion");
			table.getColumnModel().getColumn(3).setHeaderValue("Provincia");
			table.getColumnModel().getColumn(4).setHeaderValue("Superficie");
			table.getColumnModel().getColumn(5).setHeaderValue("Precio Venta");
			table.getColumnModel().getColumn(6).setHeaderValue("Fecha Venta");
			table.getColumnModel().getColumn(7).setHeaderValue("Vendedor");
		}
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		JButton btnBuscar = new JButton("Buscar Referencia");
		
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					((DefaultTableModel)table.getModel()).setRowCount(0);
					LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
					datosInmobiliaria objeto = datos.encontrar(textField.getText());
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
									+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio()
									+ ", " + objeto.getFechaV() + ", " + objeto.getVendedor();
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				} catch (NoSuchElementException d) {
					JOptionPane.showMessageDialog(frameB, "No se encontro esta referencia");
				}		
				

			}
		});

		JButton btnBuscarTipo = new JButton("Buscar Tipo");
		btnBuscarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorTipo(textField_1.getText());
				String datosCompletos = "Referencia, Tipo, Operacion, Provincia, Superficie, Precio Venta, Fecha Venta, Vendedor \n";
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}
				
			}
		});

		JButton btnBuscarVendedor = new JButton("Buscar Vendedor");
		btnBuscarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorVendedor(textField_7.getText());
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
					
				}
			}
		});

		JButton btnBuscarTipoprovincia = new JButton("Buscar Tipo-Provincia");
		btnBuscarTipoprovincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorTipoProv(textField_1.getText(),
						textField_3.getText());
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}
			}
		});
		
		JButton btnBuscarTipooperacion = new JButton("Buscar Tipo-Operacion");
		btnBuscarTipooperacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorTipoOpe(textField_1.getText(),
						textField_2.getText());
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}
			}
		});
		
		JButton btnBuscarPrecioMayor = new JButton("Buscar precio mayor o igual");
		btnBuscarPrecioMayor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				try {
					MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorPrecio(Integer.parseInt(textField_5.getText()));
					for (int i = 0; i < lista.size(); i++) {
						datosInmobiliaria objeto = lista.getEn(i);
						String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
								+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
								+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}
					
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(frameB, "Ingresa un dato numerico valido");
				}
				
			}
		});
		
		JButton btnBuscarSuperficieMayor = new JButton("Buscar superficie mayor o igual");
		btnBuscarSuperficieMayor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				try {
					MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorSuperficie(Integer.parseInt(textField_4.getText()));
					for (int i = 0; i < lista.size(); i++) {
						datosInmobiliaria objeto = lista.getEn(i);
						String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
								+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
								+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}
					
				} catch (NumberFormatException b) {
					JOptionPane.showMessageDialog(frameB, "Ingresa un dato numerico valido");
				}
				
				
			}
		});
		
		JButton btnNewButton = new JButton("Buscar precio menor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				try {
					MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorPrecioM(Integer.parseInt(textField_5.getText()));
					for (int i = 0; i < lista.size(); i++) {
						datosInmobiliaria objeto = lista.getEn(i);
						String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
								+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
								+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}
				} catch (NumberFormatException c) {
					JOptionPane.showMessageDialog(frameB, "Ingresa un dato numerico valido");
				}
				
			}
		});
		
		JButton btnBuscarSuperficieMenor = new JButton("Buscar superficie menor");
		btnBuscarSuperficieMenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				try {
					MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorSuperficieM(Integer.parseInt(textField_4.getText()));
					for (int i = 0; i < lista.size(); i++) {
						datosInmobiliaria objeto = lista.getEn(i);
						String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
								+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
								+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
						String[] dataRow = datosList.split(",");
						model.addRow(dataRow);
					}
					
				} catch (NumberFormatException d) {
					JOptionPane.showMessageDialog(frameB, "Ingresa un dato numerico valido");
				}
				
			}
		});
		
		JButton btnBuscarTipooperacionprovincia = new JButton("Buscar Tipo-Operacion-Provincia");
		btnBuscarTipooperacionprovincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((DefaultTableModel)table.getModel()).setRowCount(0);
				LecturaCSV datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				MiListaEnlazada<datosInmobiliaria> lista = datos.encontrarPorTipoOpeProv(textField_1.getText(),
						textField_2.getText(), textField_3.getText());
				for (int i = 0; i < lista.size(); i++) {
					datosInmobiliaria objeto = lista.getEn(i);
					String datosList = objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor() + "\n";
					String[] dataRow = datosList.split(",");
					model.addRow(dataRow);
				}
			}
		});
		
		
		
		

		GroupLayout groupLayout = new GroupLayout(frameB.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addComponent(lblBuscar)
					.addContainerGap(659, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(115, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipo)
								.addComponent(lblNewLabel_1)
								.addComponent(lblProvincia)
								.addComponent(lblSuperficie)
								.addComponent(lblPrecioVenta)
								.addComponent(lblVendedor))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(12)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscarTipoprovincia)
						.addComponent(btnBuscarVendedor)
						.addComponent(btnBuscarTipo)
						.addComponent(btnBuscar)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBuscarSuperficieMayor)
								.addComponent(btnBuscarPrecioMayor))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(btnBuscarSuperficieMenor)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuscarTipooperacion)
							.addGap(30)
							.addComponent(btnBuscarTipooperacionprovincia)))
					.addGap(107))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 787, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblBuscar)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBuscar)
							.addGap(18)
							.addComponent(btnBuscarTipo)
							.addGap(18)
							.addComponent(btnBuscarVendedor)
							.addGap(18)
							.addComponent(btnBuscarTipoprovincia)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscarTipooperacion)
								.addComponent(btnBuscarTipooperacionprovincia))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscarPrecioMayor)
								.addComponent(btnNewButton))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBuscarSuperficieMayor)
								.addComponent(btnBuscarSuperficieMenor)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipo))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProvincia))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSuperficie))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecioVenta))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblVendedor))))
					.addGap(32)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		
		
		
				
		frameB.getContentPane().setLayout(groupLayout);
	}
}
