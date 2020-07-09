package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazLogin {

	private JFrame frame;
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazLogin window = new InterfazLogin();
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
	public InterfazLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 430, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtMsj = new JTextPane();
		txtMsj.setForeground(Color.RED);
		txtMsj.setEditable(false);
		txtMsj.setBackground(Color.LIGHT_GRAY);
		txtMsj.setBounds(218, 107, 178, 20);
		frame.getContentPane().add(txtMsj);
		
		
		JButton btnLogin = new JButton("Iniciar Sesion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMsj.setText("");
					Login log = new Login();
					boolean logeado = log.Logear(textUser.getText(), passwordField.getText());
					if (logeado) {
						System.out.println("LOGEADO CON EXITO");
						frame.dispose();
						Interfaz interfaz = new Interfaz();
						interfaz.frame.setVisible(true);
					} else {
						txtMsj.setText("Usuario y/o pass incorrectos");
					}
			}
		});
		btnLogin.setBounds(218, 73, 121, 23);
		frame.getContentPane().add(btnLogin);
		
		textUser = new JTextField();
		textUser.setBounds(104, 43, 86, 20);
		frame.getContentPane().add(textUser);
		textUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 74, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JTextPane txtpnUsuario = new JTextPane();
		txtpnUsuario.setEditable(false);
		txtpnUsuario.setText("Usuario:");
		txtpnUsuario.setBackground(Color.LIGHT_GRAY);
		txtpnUsuario.setForeground(Color.BLACK);
		txtpnUsuario.setBounds(10, 43, 84, 20);
		frame.getContentPane().add(txtpnUsuario);
		
		JTextPane txtpnContrasea = new JTextPane();
		txtpnContrasea.setEditable(false);
		txtpnContrasea.setText("Contrase\u00F1a:");
		txtpnContrasea.setBackground(Color.LIGHT_GRAY);
		txtpnContrasea.setBounds(10, 74, 84, 20);
		frame.getContentPane().add(txtpnContrasea);
		
		
	}
}
