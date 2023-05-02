package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConversorController;
import model.Conversor;
import model.Tipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaDatos extends JFrame {

	private JPanel contentPane;
	JTextField txtCantidad;
	JLabel lblCantidad;
	int codigoConversor;
	String shortNameConversor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDatos frame = new VentanaDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDatos() {
		setTitle("Datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCantidad = new JLabel("Ingrese la cantidad que desea convertir:");
		lblCantidad.setBounds(10, 11, 327, 14);
		contentPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();
				boolean valida = (key >= 45 && key <= 57) && key != 47;
				
				if (!valida) {
					e.consume();
				}
				
			}
		});
		txtCantidad.setBounds(10, 36, 414, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtCantidad.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Por favor ingresar una cantidad", "Error", JOptionPane.ERROR_MESSAGE);
					txtCantidad.requestFocus();
					throw new NumberFormatException();					
				}
				
				dispose();
				VentanaProceso ventanaProceso = new VentanaProceso();
				ventanaProceso.setVisible(true);
				ventanaProceso.setLocationRelativeTo(null);
				ventanaProceso.shortNameConversor = shortNameConversor;
				ventanaProceso.cmbTipoConversor.requestFocus();
				ventanaProceso.setTitle(shortNameConversor);
				ventanaProceso.lblTipo.setText("Elije la/el " + shortNameConversor.toLowerCase() + " que deseas convertir:");
				ventanaProceso.codigoConversor = codigoConversor;
				
				ConversorController cc = new ConversorController();
				
				Map<Integer, Conversor> mcController = cc.llenarDatos();
				
				Conversor conversorMap = mcController.get(codigoConversor);
				
				ventanaProceso.cmbTipoConversor.addItem(new Tipo(0, "Ninguno", 0, ""));
					
				for (int i = 1; i <= conversorMap.getTipoConversorMap().size(); i++) {
					
					ventanaProceso.cmbTipoConversor.addItem(new Tipo(conversorMap.getTipoConversorMap().get(i).getCodigo(), conversorMap.getTipoConversorMap().get(i).getNombre(), conversorMap.getTipoConversorMap().get(i).getValor(), conversorMap.getTipoConversorMap().get(i).getSimbolo()));
					
				}

				ventanaProceso.datoTipoConversor = Double.parseDouble(txtCantidad.getText());
				
			}
		});
		btnOk.setBounds(10, 73, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(335, 73, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(true);
				ventanaPrincipal.setLocationRelativeTo(null);				
			}
		});
		btnBack.setBounds(347, 7, 77, 23);
		contentPane.add(btnBack);
		

	}
}
