package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class IngresoDeDatos {

	public JFrame frame;
	public JTextField ingresoNombrePaciente;
	public JTextField ingresoCodigoPaciente;
	public JTextField ingresoCodigoMedico;
	public JTextField codPacDiag;
	public JTextField diagnostico;
	public JTextField codMedDiag;
	public JTextField ingresoNombreMedico;
	public JTextField ingresoEspecMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresoDeDatos window = new IngresoDeDatos();
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
	public IngresoDeDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 439, 439);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ingresoNombrePaciente = new JTextField();
		ingresoNombrePaciente.setBounds(148, 63, 128, 28);
		frame.getContentPane().add(ingresoNombrePaciente);
		ingresoNombrePaciente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre y apellido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(ingresoNombrePaciente);
		lblNewLabel.setBounds(148, 90, 128, 28);
		frame.getContentPane().add(lblNewLabel);
		
		ingresoCodigoPaciente = new JTextField();
		ingresoCodigoPaciente.setBounds(10, 63, 128, 28);
		frame.getContentPane().add(ingresoCodigoPaciente);
		ingresoCodigoPaciente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo paciente");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 90, 128, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ingreso de datos");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 423, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ingresar paciente");
		
		btnNewButton.setBounds(10, 116, 266, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo paciente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(148, 294, 128, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo medico");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 189, 128, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		ingresoCodigoMedico = new JTextField();
		ingresoCodigoMedico.setBounds(10, 150, 128, 28);
		frame.getContentPane().add(ingresoCodigoMedico);
		ingresoCodigoMedico.setColumns(10);
		
		codPacDiag = new JTextField();
		codPacDiag.setColumns(10);
		codPacDiag.setBounds(148, 267, 128, 28);
		frame.getContentPane().add(codPacDiag);
		
		JButton btnIngresarDiagnostico = new JButton("Ingresar diagnostico");
		
		btnIngresarDiagnostico.setBounds(10, 333, 266, 23);
		frame.getContentPane().add(btnIngresarDiagnostico);
		
		diagnostico = new JTextField();
		diagnostico.setColumns(10);
		diagnostico.setBounds(286, 267, 128, 28);
		frame.getContentPane().add(diagnostico);
		
		JLabel lblNewLabel_2_1 = new JLabel("Diagnostico");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(286, 294, 128, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		codMedDiag = new JTextField();
		codMedDiag.setColumns(10);
		codMedDiag.setBounds(10, 267, 128, 28);
		frame.getContentPane().add(codMedDiag);
		
		JLabel lblNewLabel_2_2 = new JLabel("Codigo medico");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(10, 294, 128, 28);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JButton btnIngresarMedico = new JButton("Ingresar medico");
		
		btnIngresarMedico.setBounds(10, 221, 266, 23);
		frame.getContentPane().add(btnIngresarMedico);
		
		ingresoNombreMedico = new JTextField();
		ingresoNombreMedico.setColumns(10);
		ingresoNombreMedico.setBounds(148, 150, 128, 28);
		frame.getContentPane().add(ingresoNombreMedico);
		
		ingresoEspecMedico = new JTextField();
		ingresoEspecMedico.setColumns(10);
		ingresoEspecMedico.setBounds(286, 150, 128, 28);
		frame.getContentPane().add(ingresoEspecMedico);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre y apellido");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(148, 182, 128, 28);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblEspecializacion = new JLabel("Especializacion");
		lblEspecializacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecializacion.setBounds(286, 182, 128, 28);
		frame.getContentPane().add(lblEspecializacion);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(ingresoNombrePaciente.getText() != null && ingresoCodigoPaciente.getText() != null)
					bdatoa.datosDelPaciente(ingresoNombrePaciente.getText(),ingresoCodigoPaciente.getText());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnIngresarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(ingresoNombreMedico.getText() != null && ingresoCodigoMedico.getText() != null && ingresoEspecMedico.getText() != null)
					bdatoa.datosMedico(ingresoNombreMedico.getText(),ingresoCodigoMedico.getText(),ingresoEspecMedico.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIngresarDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(codPacDiag.getText() != null && codMedDiag.getText() != null && diagnostico.getText() != null)
					bdatoa.situacionPaciente(codPacDiag.getText(), codMedDiag.getText(), diagnostico.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
