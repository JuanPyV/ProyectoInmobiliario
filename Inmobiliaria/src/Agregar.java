import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Agregar {

	private JFrame frameA;
	private JTextField tipo;
	private JTextField operacion;
	private JTextField provincia;
	private JTextField superficie;
	private JTextField precioVenta;
	private JTextField fechaVenta;
	private JTextField vendedor;
	private LecturaCSV escribir;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agregar window = new Agregar();
					window.frameA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Agregar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameA = new JFrame();
		frameA.setBounds(100, 100, 640, 490);

		JLabel lblAgregar = new JLabel("Agregar Venta");
		lblAgregar.setFont(new Font("Dialog", Font.BOLD, 24));

		tipo = new JTextField();
		tipo.setColumns(10);

		operacion = new JTextField();
		operacion.setColumns(10);

		provincia = new JTextField();
		provincia.setColumns(10);

		superficie = new JTextField();
		superficie.setColumns(10);

		precioVenta = new JTextField();
		precioVenta.setColumns(10);

		fechaVenta = new JTextField();
		fechaVenta.setColumns(10);

		vendedor = new JTextField();
		vendedor.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo");

		JLabel lblOperacion = new JLabel("Operacion");

		JLabel lblProvincia = new JLabel("Provincia");

		JLabel lblSuperficie = new JLabel("Superficie");

		JLabel lblNewLabel = new JLabel("Precio Venta");

		JLabel lblFechaVenta = new JLabel("Fecha Venta");

		JLabel lblVendedor = new JLabel("Vendedor");

		JButton btnAgregar = new JButton("Agregar");

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escribir = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
				String tip = tipo.getText();
				String op = operacion.getText();
				String prov = provincia.getText();
				String sup = superficie.getText();
				String precio = precioVenta.getText();
				String fecha = fechaVenta.getText();
				String vend = vendedor.getText();

				// crear objeto para insertar
				
				System.out.println(escribir.refMasAlta());
				datosInmobiliaria objeto = new datosInmobiliaria(escribir.refMasAlta(), tip, op, prov, sup, precio, fecha, vend);
				System.out.println(escribir.getSize());
				escribir.meterATabla(objeto);
				System.out.println(escribir.getSize());
				escribir.lecturaDatos();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frameA.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(162)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipo)
						.addComponent(lblOperacion)
						.addComponent(lblProvincia)
						.addComponent(lblSuperficie)
						.addComponent(lblNewLabel)
						.addComponent(lblFechaVenta)
						.addComponent(lblVendedor))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(precioVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
								.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addGap(101))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(vendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(298, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(operacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(provincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(superficie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(fechaVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(298, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblAgregar)
					.addContainerGap(440, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lblAgregar)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(operacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOperacion))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(provincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProvincia))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(superficie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSuperficie))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(precioVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnAgregar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(fechaVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaVenta))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVendedor))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		frameA.getContentPane().setLayout(groupLayout);
	}
}
