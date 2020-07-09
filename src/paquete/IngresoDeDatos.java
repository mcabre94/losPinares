package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
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
		
		btnNewButton.setBounds(10, 128, 266, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo paciente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(148, 309, 128, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo medico");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 206, 128, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		ingresoCodigoMedico = new JTextField();
		ingresoCodigoMedico.setBounds(10, 167, 128, 28);
		frame.getContentPane().add(ingresoCodigoMedico);
		ingresoCodigoMedico.setColumns(10);
		
		codPacDiag = new JTextField();
		codPacDiag.setColumns(10);
		codPacDiag.setBounds(148, 282, 128, 28);
		frame.getContentPane().add(codPacDiag);
		
		JButton btnIngresarDiagnostico = new JButton("Ingresar diagnostico");
		
		btnIngresarDiagnostico.setBounds(10, 348, 266, 23);
		frame.getContentPane().add(btnIngresarDiagnostico);
		
		diagnostico = new JTextField();
		diagnostico.setColumns(10);
		diagnostico.setBounds(286, 282, 128, 28);
		frame.getContentPane().add(diagnostico);
		
		JLabel lblNewLabel_2_1 = new JLabel("Diagnostico");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(286, 309, 128, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		codMedDiag = new JTextField();
		codMedDiag.setColumns(10);
		codMedDiag.setBounds(10, 282, 128, 28);
		frame.getContentPane().add(codMedDiag);
		
		JLabel lblNewLabel_2_2 = new JLabel("Codigo medico");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(10, 309, 128, 28);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JButton btnIngresarMedico = new JButton("Ingresar medico");
		
		btnIngresarMedico.setBounds(10, 238, 266, 23);
		frame.getContentPane().add(btnIngresarMedico);
		
		ingresoNombreMedico = new JTextField();
		ingresoNombreMedico.setColumns(10);
		ingresoNombreMedico.setBounds(148, 167, 128, 28);
		frame.getContentPane().add(ingresoNombreMedico);
		
		ingresoEspecMedico = new JTextField();
		ingresoEspecMedico.setColumns(10);
		ingresoEspecMedico.setBounds(286, 167, 128, 28);
		frame.getContentPane().add(ingresoEspecMedico);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre y apellido");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(148, 199, 128, 28);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblEspecializacion = new JLabel("Especializacion");
		lblEspecializacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecializacion.setBounds(286, 199, 128, 28);
		frame.getContentPane().add(lblEspecializacion);
		
		JLabel errorIngresoPaciente = new JLabel("");
		//errorIngresoPaciente.setEnabled(false);
		errorIngresoPaciente.setForeground(Color.RED);
		errorIngresoPaciente.setBounds(10, 113, 266, 13);
		frame.getContentPane().add(errorIngresoPaciente);
		
		JLabel resultadoIngresoMedico = new JLabel("");
		resultadoIngresoMedico.setForeground(Color.GREEN);
		resultadoIngresoMedico.setBounds(10, 225, 266, 13);
		frame.getContentPane().add(resultadoIngresoMedico);
		
		JLabel resultadoIngresoDiagnostico_1 = new JLabel("");
		resultadoIngresoDiagnostico_1.setForeground(Color.GREEN);
		resultadoIngresoDiagnostico_1.setBounds(10, 335, 266, 13);
		frame.getContentPane().add(resultadoIngresoDiagnostico_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					errorIngresoPaciente.setText("");
					if(ingresoNombrePaciente.getText() != null && ingresoCodigoPaciente.getText() != null)
					bdatoa.datosDelPaciente(ingresoNombrePaciente.getText(),ingresoCodigoPaciente.getText());
					errorIngresoPaciente.setForeground(Color.GREEN);
					errorIngresoPaciente.setText("Se guardó correctamente el paciente");
					
					Timer t = new Timer(3000, new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	errorIngresoPaciente.setText("");
			            }
			        });
			        t.setRepeats(false);
			        t.start();
			        
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO: handle exception
					errorIngresoPaciente.setForeground(Color.RED);
					errorIngresoPaciente.setText(e.getMessage());
					//errorIngresoPaciente.show();
					
				}
			}
		});
		btnIngresarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultadoIngresoMedico.setText("");
					if(ingresoNombreMedico.getText() != null && ingresoCodigoMedico.getText() != null && ingresoEspecMedico.getText() != null)
					bdatoa.datosMedico(ingresoNombreMedico.getText(),ingresoCodigoMedico.getText(),ingresoEspecMedico.getText());
					resultadoIngresoMedico.setText("Se guardó correctamente el médico");
					
					Timer t = new Timer(3000, new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	resultadoIngresoMedico.setText("");
			            }
			        });
			        t.setRepeats(false);
			        t.start();
			        
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIngresarDiagnostico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					resultadoIngresoDiagnostico_1.setText("");
					if(codPacDiag.getText() != null && codMedDiag.getText() != null && diagnostico.getText() != null)
					bdatoa.situacionPaciente(codPacDiag.getText(), codMedDiag.getText(), diagnostico.getText());
					resultadoIngresoDiagnostico_1.setText("Se guardó correctamente el diagnóstico");
					
					Timer t = new Timer(3000, new ActionListener() {

			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	resultadoIngresoDiagnostico_1.setText("");
			            }
			        });
			        t.setRepeats(false);
			        t.start();
			        
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
