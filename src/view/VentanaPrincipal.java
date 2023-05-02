package view;

import java.awt.EventQueue;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConversorController;
import model.Conversor;
import model.Objeto;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("CONVERSOR - Alura Latam");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCopyright = new JLabel("© Copyright by Fray Boris Espinoza Tarazona");
		lblCopyright.setForeground(new Color(0, 0, 0));
		lblCopyright.setBounds(91, 264, 282, 14);
		contentPane.add(lblCopyright);
		
		JLabel lblTitulo = new JLabel("Seleccione un Tipo de Conversor");
		lblTitulo.setBounds(122, 11, 196, 14);
		contentPane.add(lblTitulo);
		
		//ComboBox con tipo Objeto
		
		JComboBox<Objeto> cmbConversor = new JComboBox();		
		
		//Llenar Datos ComboBox
			
		ConversorController cc = new ConversorController();
		Map<Integer, Conversor> mcConversor = cc.llenarDatos();
		
		cmbConversor.addItem(new Objeto(0, "Ninguno", ""));		
		
		for (int i = 1; i <= mcConversor.size(); i++) {			
			
			cmbConversor.addItem(new Objeto(mcConversor.get(i).getCodigo(), mcConversor.get(i).getNombre(), mcConversor.get(i).getShortName()));

		}	
		
		cmbConversor.setBounds(91, 49, 241, 22);
		contentPane.add(cmbConversor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbConversor.getSelectedIndex() != 0) {
					dispose();
					VentanaDatos ventanaDatos = new VentanaDatos();
					ventanaDatos.setVisible(true);//Hacerlo visible
					ventanaDatos.setLocationRelativeTo(null);//Centrar la pantalla
					ventanaDatos.txtCantidad.requestFocus();//Dar foco
					ventanaDatos.lblCantidad.setText("Ingrese la cantidad de " + cmbConversor.getItemAt(cmbConversor.getSelectedIndex()).getShortName().toLowerCase() + " que desea convertir:");
					ventanaDatos.codigoConversor = cmbConversor.getItemAt(cmbConversor.getSelectedIndex()).getCodigo();
					ventanaDatos.shortNameConversor = cmbConversor.getItemAt(cmbConversor.getSelectedIndex()).getShortName();
				} else {
					cmbConversor.requestFocus();
				}
			}
		});
		btnOk.setBounds(56, 219, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //Cerrar la ventana				
			}
		});
		btnCancel.setBounds(271, 219, 89, 23);
		contentPane.add(btnCancel);		
		
	}
}
