package paquete;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
class bdatoa
{
	
		public static void ps(String x)
	{
		//	esto es para escribir menos y no poner un System.out.print
		System.out.print(x);        
	} 
	
	public static int LeerEntero()
	{				
		String l�nea= new String("");
		try{ 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			l�nea = br.readLine();  //leo una linea del buffer
		}catch(Exception e){ e.printStackTrace();} //si no puede leer entra x catch
		int ne=0;
		try {ne=Integer.parseInt(l�nea);
		} catch  (Exception e) {};
		return(ne);		
	}
	public static String LeerCadena()
	{
		String l�nea= new String(""); 
		try{ 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			l�nea = br.readLine(); //leo linea de buffer
		}catch(Exception e){ e.printStackTrace();} // sino se puede entro x catch
		return(l�nea);		
	}


	public static void datosDelPaciente(String nombrePac,String codigoPac) throws FileNotFoundException {
		// ingreso de datos, datos del paciente
		String codpac,nompac,op;
		DataOutputStream datopac=null;
		final Pattern nombre = Pattern.compile("^[a-zA-Z�-��-�,' ]+$");
		final Pattern numerico = Pattern.compile("^[0-9]+$");
		
		/* Se abre el archivo a analizar */
		datopac=new DataOutputStream (new FileOutputStream("datopac.txt",true));//abre el archivo datos de pacientes
		try
		{

			/* Se lee el codigo de paciente */
			codpac = codigoPac;
			/* Se testea contra la regexp numerica */
			/* para ver si es v�lido el ingreso */
		    if (!numerico.matcher(codpac).matches()) {
		        throw new IllegalArgumentException("El codigo paciente debe ser num�rico\n");
		    }
			
		    /* Se pide el ingreso del nombre del paciente */
			nompac = nombrePac;
			/* Se testea contra la regexp de nombre, que chequea que contenga solo letras, espacios o coma*/
			/* para ver si es v�lido el ingreso */
		    if (!nombre.matcher(nompac).matches()) {
		        throw new IllegalArgumentException("El nombre debe contener solo letras\n");
		    }
		    
		    /* Se chequea si tiene entre 3 y 30 caracteres el nombre*/
			/* para ver si es v�lido el ingreso */
		    if(nompac.length() < 3 || nompac.length() > 30) {
		    	throw new IllegalArgumentException("El nombre debe tener entre 3 y 30 caracteres\n");
		    }
			
//		    ps(codpac);
//		    ps(nompac);
		    /* Se escribe el codigo de paciente en el archivo*/
		    datopac.writeUTF(codpac);
		    /* Se escriben el nombre del paciente en el archivo*/
		    datopac.writeUTF(nompac);
		    
			datopac.close(); 

		}catch(IOException ioe){}; 
	
	}

	public static void situacionPaciente(String codPac,String codMed,String diagnostic) throws FileNotFoundException {	
		//ingreso de datos, situacion del paciente
		String codp,codm,enfpac,op;
		DataOutputStream situpac=null;
		situpac=new DataOutputStream (new FileOutputStream("situpac.txt",true));//abre archivo situacionpacientes

		try
		{
			codp = codPac;
			situpac.writeUTF(codp);
			codm = codMed;
			situpac.writeUTF(codm);
			enfpac = diagnostic;
			situpac.writeUTF(enfpac);
			situpac.close();
		}catch(IOException ioe){};//si el archivo no exxiste o no se puede abrir sale
	}
	public static void imprimePacientes(String codpa,String nompa,DataInput datopac,String codp, DefaultListModel<String> lista ) throws IOException {
		//este metodo muestra
		//los pacientes cargados en el sistema
		
		int sw1=1;
		while (sw1!=0)
		{ try
		{
			codpa=datopac.readUTF();
			nompa=datopac.readUTF();

			if (codpa.equals(codp))  //compara el codigo del 
			//paciente de la tabla "situpac" 
				//con el codigo del paciente de 
				//la tabla "datopac"
			{
//				ps("::: Paciente: "+nompa+"\n");
				((DefaultListModel<String>) lista).addElement(nompa);
			}
		}catch(EOFException e){sw1=0;}
		}
	}
	public static void datosMedico(String nombreMed,String codMed,String especMed) throws IOException {
		String codmed,nommed,espmed,op;
		DataOutputStream datomed=null;
		datomed=new DataOutputStream (new FileOutputStream("datomed.txt"));//abro archivo de datos de medico
		try
		{ 
			codmed = codMed;
			datomed.writeUTF(codmed);
			nommed = nombreMed;
			datomed.writeUTF(nommed);
			espmed = especMed;
			datomed.writeUTF(espmed);
		}catch(IOException ioe){}; //si no se puede abrir  el archivo sale
		datomed.close();
	}

	@SuppressWarnings("resource")
	public static void listadosPacienteMedico(String codMed,DefaultListModel<String> lista) {
		String codp="",espm = "",codpa="",enfp="",nompa="",codm="", codme="", nomm="", codtem; //variables a utilizar
		int sw,sw1;
		ArrayList<String> pacientes = new ArrayList<>();
		try
		{

//			ps("Digite el codigo del medico que desea consultar: ");
			//codtem=LeerCadena();
			codtem = codMed;

			DataInputStream datomed=null;
			datomed=new DataInputStream (new FileInputStream("datomed.txt"));//abro archivo datomedico

			sw=1;
			while (sw!=0)//es casi un while true pero corta cuando deja de leer
			{ try
			{
				codm=datomed.readUTF();
				nomm=datomed.readUTF();

			}catch(EOFException e){sw=0;} //esto provoca el corte del while

			if (codm.equals(codtem)) //compara el codigo extraido de la 
				//tabla "datomed" con el codigo 
				//digitado
			{
				ps("::: El medico "+nomm+" atiende a los siguientes pacientes: "+"\n");
				DataInputStream situpac=null;
				situpac=new DataInputStream (new FileInputStream("situpac.txt"));


				sw=1;
				while (sw!=0) //es casi un while true pero corta cuando deja de leer
				{ try
				{
					codp=situpac.readUTF();
					codme=situpac.readUTF();
					enfp=situpac.readUTF();
					if (codme.equals(codtem))   //compara el codigo medico de la 
						//tabla "datomed" con el de la 
						//tabla "situpac"
					{
						DataInputStream datopac=null;
						datopac=new DataInputStream (new FileInputStream("datopac.txt"));

						imprimePacientes(codpa, nompa, datopac, codp, lista);
						

					}
				}catch(EOFException e){sw=0;} //esto provoca el corte del while
				} 
			}
			} 

		} catch(IOException ioe){};
	}

	@SuppressWarnings("resource")
	public static void enfermedadesMedico(String codMed, DefaultListModel<String> lista) throws IOException {
		String codtem,codm,nomm,codp,codme,enfp;//variables locales
		int sw1,sw;
		ps("Digite el codigo del medico que desea consultar: ");
		//codtem=LeerCadena();
		codtem=codMed;

		DataInputStream datomed=null;
		datomed=new DataInputStream (new FileInputStream("datomed.txt"));//abro archivo datomedico

		sw1=1;
		while (sw1!=0)//leo mientras sw1 sea distinto de 0 que sucede cuando deja de leer
		{ try
		{
			codm=datomed.readUTF();
			nomm=datomed.readUTF();
			if (codm.equals(codtem)) //compara el codigo digitado
				//con el codigo del medico de la
				//tabla "datomed" 
			{
				ps("El medico " +nomm+" trata las siguientes enfermedades:"+"\n");

				DataInputStream situpac=null;
				situpac=new DataInputStream (new FileInputStream("situpac.txt"));//leo archivo situpac

				sw=1;
				while (sw!=0)
				{ try
				{
					codp=situpac.readUTF();
					codme=situpac.readUTF();
					enfp=situpac.readUTF();

					if(codtem.equals(codme))   //compara el codigo del medico
						// de la tabla "datomed"
						//con el codigo del medico en la 
						//tabla "situpac" 

					{
						((DefaultListModel<String>) lista).addElement(enfp);
						ps(">>>> "+enfp+"\n");
					}  
				}catch(EOFException e){sw=0;} //corte de while dejo de leer
				}	 
			}
		}catch(EOFException e){sw1=0;} 
		}
	}
	
	public static void informes() throws IOException {
		int op2;
		do//menu de control de pacientes
		{
			ps("   ..............................................."+"\n");
			ps("   :-:  C O N T R O L  D E  P A C I E N T E S  :-:"+"\n");
			ps("   ..............................................."+"\n");
			ps("   :-:           - I N F O R M E S -           :-:"+"\n");
			ps("   :-:.........................................:-:"+"\n");
			ps("   :-: 1. Listado de pacientes por medico      :-:"+"\n");
			ps("   :-: 2. Enfermedades que atiende cada medico :-:"+"\n");
			ps("   :-: 3. Anterior                             :-:"+"\n");
			ps("   ..............................................."+"\n");
			ps("   ....Elija la opcion deseada: ");
			op2=LeerEntero();
			if (op2<1||op2>3)
			{ps("Seleccione una de las opciones del menu"+"\n");
			}	   	 	

			switch (op2)//hago un switch en base a la seleccion 
			{
			case 1:
				//listadosPacienteMedico();
				break;       	 	  	
			case 2:
				//enfermedadesMedico();       	 	  
				break;
			}

		}while (op2!=3);//esto corta si pongo anterior osea 3
	}
	
	public static void ingresoPacientes() throws IOException {
		int op2;
		do 
		{ //ingreso de pacientes
		

			ps("   ..............................................."+"\n");
			ps("   :-: -I N G R E S O  D E  P A C I E N T E S- :-:"+"\n");
			ps("   :-:.........................................:-:"+"\n");
			ps("   :-: 1.  Datos del paciente                  :-:"+"\n");
			ps("   :-: 2.  Situacion del paciente              :-:"+"\n");
			ps("   :-: 3.  Datos del medico                    :-:"+"\n");
			ps("   :-: 4.  vOLVER                              :-:"+"\n");
			ps("   ..............................................."+"\n");
			ps("   ....Elija la opcion deseada: ");

			op2=LeerEntero();

			if (op2<1||op2>4)
			{ps("Debe digitar una opcion del menu"+"\n");
			}

			switch (op2)   // selecciono en base a la eleccion del user
			{
			case 1:   
				//datosDelPaciente();//esto esta modularizo para reducir cc
				break;

			case 2:
				//situacionPaciente();
				break;  
			case 3:
				//datosMedico();//cargo datos del medico
			} 
		}while (op2!=4); //corta cuando vuelve o pone 4
	}
	
	public static void main(String args[])
			throws Exception
	{
		int op1;  //variables de selecci�n usadas en los diferentes men�s 
		do
		{
			op1=0;

			ps("   .............................................."+"\n");
			ps("   :-:         CENTRO ASISTENCIAL             :-:"+"\n");
			ps("   :-:   >>>> L O S  P I N A R E S   <<<<     :-:"+"\n");
			ps("   :-:  C O N T R O L  D E  P A C I E N T E S :-:"+"\n");
			ps("   :-:........................................:-:"+"\n");
			ps("   :-: 1.  Ingreso de datos                   :-:"+"\n");
			ps("   :-: 2.  Informes                           :-:"+"\n");
			ps("   :-: 3.  Salir                              :-:"+"\n");
			ps("   .............................................."+"\n");
			ps("   ....Elija la opcion deseada: ");
			//ps("\n");
			op1=LeerEntero();
			if (op1<1||op1>3)
			{ps("Debe digitar una opcion del menu"+"\n");
			}


			if (op1==1)   //seleci�n ingreso de pacientes           
			{ 
				ingresoPacientes();
			}
			else
			{
				if (op1==2)     //seleci�n informes 
				{
					informes();
				}
			}
		}while (op1!=3);

	}
}
