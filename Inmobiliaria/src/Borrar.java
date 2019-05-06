import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Borrar {

	private JFrame frame;
	private JTextField borrarRef;
	private LecturaCSV datos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrar window = new Borrar();
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
	public Borrar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);

		frame.getContentPane().setLayout(null);

		JLabel lblBorrar = new JLabel("Borrar Registro");
		lblBorrar.setFont(new Font("Dialog", Font.BOLD, 24));
		lblBorrar.setBounds(10, 11, 198, 32);
		frame.getContentPane().add(lblBorrar);

		JLabel lblReferencia = new JLabel("Referencia:");
		lblReferencia.setBounds(69, 122, 66, 14);
		frame.getContentPane().add(lblReferencia);

		borrarRef = new JTextField();
		borrarRef.setBounds(165, 119, 86, 20);
		frame.getContentPane().add(borrarRef);
		borrarRef.setColumns(10);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(316, 118, 89, 23);
		frame.getContentPane().add(btnBorrar);

		JLabel valorBorrado = new JLabel("");
		valorBorrado.setBounds(49, 196, 356, 23);
		frame.getContentPane().add(valorBorrado);
		
		JLabel lblValorBorrado = new JLabel("Valor Borrado:");
		lblValorBorrado.setBounds(49, 171, 86, 14);
		frame.getContentPane().add(lblValorBorrado);

		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					datos = LecturaCSV.cargarListaDatos(new File("datosInmueble.bin"));
					datosInmobiliaria objeto = datos.encontrar(borrarRef.getText());
					String ref = borrarRef.getText();
					datos.getLista().delete(ref);
					datos.lecturaDatos();
					valorBorrado.setText(objeto.getRef() + ", " + objeto.getTipo() + ", " + objeto.getOperacion() + ", "
							+ objeto.getProvincia() + ", " + objeto.getSuperficie() + ", " + objeto.getPrecio() + ", "
							+ objeto.getFechaV() + ", " + objeto.getVendedor());
				} catch (NullPointerException exp) {
					valorBorrado.setText("Borrado");
					throw new NullPointerException("No se encontró esta referencia");
				}

			}
		});
	}
}