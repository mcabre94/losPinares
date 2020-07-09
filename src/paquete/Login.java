package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
	
	private String path;
	
	public Login() {
		this.path = "usuarios.txt";
	} 
	
	public boolean Logear (String u, String p) {
		Scanner lector;
		String user;
		String pass;
		try {
			lector = new Scanner(new File(path));
			String  linea;
			 while(lector.hasNextLine()) {		
				 linea = lector.nextLine();
				 String [] lineaSplitted = linea.split("\\|");
				 user = lineaSplitted[0];
				 pass = lineaSplitted[1];
				 if(u.equals(user) && p.equals(pass)) 
					 return true;
			 }
		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo usuarios.txt");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
