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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class VentanaProceso extends JFrame {

	private JPanel contentPane;
	JLabel lblTipo;
	JComboBox<Tipo> cmbTipoConversor;
	int codigoConversor;
	double datoTipoConversor;
	String shortNameConversor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProceso frame = new VentanaProceso();
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
	public VentanaProceso() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTipo = new JLabel("Elige el tipo al que deseas convertir:");
		lblTipo.setBounds(10, 11, 280, 14);
		contentPane.add(lblTipo);
		
		cmbTipoConversor = new JComboBox();
		cmbTipoConversor.setBounds(10, 36, 414, 22);
		contentPane.add(cmbTipoConversor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (cmbTipoConversor.getSelectedIndex() != 0) {
					String resultado;
					int opcion;
					int codigoTipoConversor =  cmbTipoConversor.getItemAt(cmbTipoConversor.getSelectedIndex()).getCodigo();
					double valorTipoConversor = cmbTipoConversor.getItemAt(cmbTipoConversor.getSelectedIndex()).getValor();
					String simboloTipoConversor = cmbTipoConversor.getItemAt(cmbTipoConversor.getSelectedIndex()).getSimbolo();
					
					ConversorController cc = new ConversorController();
					
					resultado = cc.convertirTipoConversor(codigoConversor, codigoTipoConversor, datoTipoConversor, valorTipoConversor);
					
					dispose();
					
					opcion = JOptionPane.showConfirmDialog(null, "Tienes " + resultado + " " + simboloTipoConversor, "Information", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
					
					if (opcion == 0) {
												
						opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						switch (opcion) {
						case 0:
							VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
							ventanaPrincipal.setVisible(true);
							ventanaPrincipal.setLocationRelativeTo(null);
							break;
						case 1:
							JOptionPane.showConfirmDialog(null, "Programa Terminado", "Information", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
							break;
						case 2:
							setVisible(true);
							setLocationRelativeTo(null);
							
							Map<Integer, Conversor> mcController = cc.llenarDatos();
							
							Conversor conversorMap = mcController.get(codigoConversor);
							
							cmbTipoConversor.addItem(new Tipo(0, "Ninguno", 0, ""));
								
							for (int i = 1; i <= conversorMap.getTipoConversorMap().size(); i++) {
								
								cmbTipoConversor.addItem(new Tipo(conversorMap.getTipoConversorMap().get(i).getCodigo(), conversorMap.getTipoConversorMap().get(i).getNombre(), conversorMap.getTipoConversorMap().get(i).getValor(), conversorMap.getTipoConversorMap().get(i).getSimbolo()));
								
							}
							
							cmbTipoConversor.setSelectedIndex(0);
							
							cmbTipoConversor.requestFocus();
							
							break;							

						default:
							throw new IllegalArgumentException("[Valor inesperado para el dialogo: " + opcion + "]");
						}
						
					}
					
				} else {
					cmbTipoConversor.requestFocus();
				}
			}
		});
		btnOk.setBounds(10, 74, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(335, 74, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaDatos ventanaDatos = new VentanaDatos();
				ventanaDatos.setVisible(true);
				ventanaDatos.setLocationRelativeTo(null);				
				ventanaDatos.lblCantidad.setText("Ingrese la cantidad de " + shortNameConversor.toLowerCase() + " que desea convertir:");
				ventanaDatos.txtCantidad.requestFocus();
				ventanaDatos.shortNameConversor = shortNameConversor; 
				ventanaDatos.codigoConversor = codigoConversor;
			}
		});
		btnBack.setBounds(347, 7, 77, 23);
		contentPane.add(btnBack);
	}

}
