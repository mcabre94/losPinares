package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Informes {

	public JFrame frame;
	private JTextField codMedPac;
	private JTextField codMedDiag;
	JList listadoPacientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informes window = new Informes();
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
	public Informes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informes");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 517, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar");
		
		btnNewButton.setBounds(108, 83, 86, 23);
		frame.getContentPane().add(btnNewButton);
		
		codMedPac = new JTextField();
		codMedPac.setBounds(20, 84, 78, 20);
		frame.getContentPane().add(codMedPac);
		codMedPac.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de medico");
		lblNewLabel_1.setBounds(20, 103, 115, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 117, 174, 202);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 174, 202);
		panel.add(scrollPane);
		
		listadoPacientes = new JList();
		scrollPane.setViewportView(listadoPacientes);
		
		JLabel lblNewLabel_2 = new JLabel("Listado de pacientes por medico");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 58, 184, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		codMedDiag = new JTextField();
		codMedDiag.setColumns(10);
		codMedDiag.setBounds(321, 83, 86, 20);
		frame.getContentPane().add(codMedDiag);
		
		JButton btnNewButton_1 = new JButton("Ingresar");
		
		btnNewButton_1.setBounds(417, 83, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Diagnosticos dados por el medico");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(321, 58, 184, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Codigo de medico");
		lblNewLabel_1_1.setBounds(321, 103, 106, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(321, 117, 185, 202);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 185, 202);
		panel_1.add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		DefaultListModel<String> modeloLista=new DefaultListModel<String>();
		listadoPacientes.setModel(modeloLista);		
		
		DefaultListModel<String> modeloLista2=new DefaultListModel<String>();
		
		list_1.setModel(modeloLista2);		
        
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloLista.clear();
				if(codMedPac.getText()!= null)
				bdatoa.listadosPacienteMedico(codMedPac.getText(), modeloLista);
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modeloLista2.clear();
					if(codMedDiag.getText() != null)
					bdatoa.enfermedadesMedico(codMedDiag.getText(),modeloLista2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
