package frontend;

import java.awt.BorderLayout;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepciones.Incorrecto;
import excepciones.UsuarioRepetido;
import sqlite.DBManager;
import usuarios.Estudiante;
import usuarios.Trabajador;

import javax.swing.JButton;

/**
 * Esta clase sirve para automatricular estudiantes en nuestra plataforma de la universidad
 * @author Amaia y Olatz
 *
 */

public class Automatriculacion extends JFrame {

	private JPanel contentPane;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido1;
	private JTextField apellido2;
	private JTextField user;
	private JTextField pass;
	private JTextField email;
	private JTextField iban;
	private JButton btnOk;
	private JButton btnAtrs;


	/**
	 * Aqu� se realiza la automatriculaci�n
	 * @param diccionarioEstudiantes lista de todos los estudiantes
	 * @param diccionarioTrabajadores lista de todos los trabajadores
	 * @param atras informaci�n de la clase principio
	 */
	
	public Automatriculacion(ArrayList <Estudiante> diccionarioEstudiantes, ArrayList <Trabajador> diccionarioTrabajadores, Principio atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(15, 35, 69, 20);
		contentPane.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(3, 71, 81, 20);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido1:");
		lblApellido.setBounds(3, 107, 81, 20);
		contentPane.add(lblApellido);
		
		JLabel lblApellido_1 = new JLabel("Apellido 2:");
		lblApellido_1.setBounds(3, 165, 81, 20);
		contentPane.add(lblApellido_1);
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setBounds(219, 35, 69, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Pass:");
		lblPassword.setBounds(219, 74, 81, 20);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(219, 129, 69, 20);
		contentPane.add(lblEmail);
		
		JLabel lblIban = new JLabel("Iban:");
		lblIban.setBounds(219, 168, 69, 20);
		contentPane.add(lblIban);
		
		dni = new JTextField();
		dni.setBounds(58, 32, 146, 26);
		contentPane.add(dni);
		dni.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(68, 71, 146, 26);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido1 = new JTextField();
		apellido1.setBounds(78, 107, 146, 26);
		contentPane.add(apellido1);
		apellido1.setColumns(10);
		
		apellido2 = new JTextField();
		apellido2.setBounds(70, 162, 146, 26);
		contentPane.add(apellido2);
		apellido2.setColumns(10);
		
		user = new JTextField();
		user.setBounds(267, 32, 146, 26);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(267, 68, 146, 26);
		contentPane.add(pass);
		pass.setColumns(10);
		
		email = new JTextField();
		email.setBounds(282, 126, 146, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		iban = new JTextField();
		iban.setBounds(282, 162, 146, 26);
		contentPane.add(iban);
		iban.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(298, 199, 115, 29);
		contentPane.add(btnOk);
		
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(173, 199, 115, 29);
		contentPane.add(btnAtrs);
		
		btnAtrs.addActionListener(new ActionListener() {
			
			/**
			 * Este m�todo sirve para volver atr�s
			 */
			
			public void actionPerformed(ActionEvent e) {

				atras.setVisible(true);
				Automatriculacion.this.setVisible(false);
			}
		});
		
		
		btnOk.addActionListener(new ActionListener() {
			
			/**
			 * Este m�todo sirve para escribir los datos seleccionados y aceptar
			 */
			
			public void actionPerformed(ActionEvent e) {

				String dniUsuario;
				String nombreUsuario;
				String apellido1Usuario;
				String apellido2Usuario;
				String userUsuario;
				String contrasenaUsuario;
				String emailUsuario;
				String ibanUsuario;
				
				
				dniUsuario= dni.getText();
				
				dniUsuario = dniUsuario.toUpperCase();
	            char [] arrayDNI = new char [dniUsuario.length()];
	            arrayDNI = dniUsuario.toCharArray();
	            
	            if (dniUsuario.length() != 9)
	            {
	                
	            	
	            	JOptionPane.showMessageDialog(Automatriculacion.this, "Introduzca 9 caracteres, 8 numeros al principio "
	            			+ "y una letra despu�s", "Error" , JOptionPane.ERROR_MESSAGE);
	            	dniUsuario = dni.getText();
	                dniUsuario = dniUsuario.toUpperCase();
	                arrayDNI = new char [dniUsuario.length()];
	                arrayDNI = dniUsuario.toCharArray();

	            }

	            
				nombreUsuario = nombre.getText();
				apellido1Usuario=apellido1.getText();
				apellido2Usuario=apellido2.getText();
				userUsuario=user.getText();
				contrasenaUsuario=pass.getText();
				emailUsuario=email.getText();        
				ibanUsuario=iban.getText();
				
	            ibanUsuario = ibanUsuario.toUpperCase();
	            char [] arrayIban = new char [ibanUsuario.length()];
	            arrayIban = ibanUsuario.toCharArray();

	            if (ibanUsuario.length() != 24)
	            {
	                
	                JOptionPane.showMessageDialog(Automatriculacion.this, "Introduzca 24 caracteres, 2 caracteres al principio "
	            			+ "y 22 n�meros despu�s", "Error" , JOptionPane.ERROR_MESSAGE);
	            	dniUsuario = dni.getText();
	                ibanUsuario = ibanUsuario.toUpperCase();
	                arrayIban = new char [ibanUsuario.length()];
	                arrayIban = ibanUsuario.toCharArray();

	            }

				
				
				try {
					
					
					comprobarcorreo (emailUsuario);
					comprobarPersonas(userUsuario, diccionarioEstudiantes, diccionarioTrabajadores);
					comprobarDniRepetido(dniUsuario, diccionarioEstudiantes, diccionarioTrabajadores);
					comprobardninumeros(arrayDNI);
					comprobardniletra(arrayDNI);
					comprobaribanletra(arrayIban);
					comprobaribannumeros(arrayIban);
					


					Estudiante user = new Estudiante(nombreUsuario, apellido1Usuario, apellido2Usuario, dniUsuario, userUsuario, contrasenaUsuario,
							emailUsuario, ibanUsuario, "estudiante", 0.0, 0,0);
					diccionarioEstudiantes.add(user);
					
					DBManager.insertEstudiante(nombreUsuario, apellido1Usuario, apellido2Usuario, dniUsuario, userUsuario, contrasenaUsuario,
							emailUsuario, ibanUsuario, "estudiante", 0.0, 0,0);

					

					JOptionPane.showMessageDialog(Automatriculacion.this, "Ya se dado alta al usuario");

				} catch (UsuarioRepetido i) {

					JOptionPane.showMessageDialog(Automatriculacion.this, i.getMessage());
				} catch (Incorrecto i) {

					JOptionPane.showMessageDialog(Automatriculacion.this, i.getMessage());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			/**
			 * Este m�todo sirve para comprobar que el correo introducido por el usuario acaba en @gmail.com
			 * @param emailUsuario el email de usuario
			 * @throws Incorrecto si no introduce el correo con el patr�n indicado saltar� la excepci�n Incorrecto
			 */
			

			private void comprobarcorreo(String emailUsuario) throws Incorrecto {
				// TODO Auto-generated method stub
				
				String patron1 = ".*@gmail\\.com";
	            Pattern pat1 = Pattern.compile( patron1 );

	            if (pat1.matcher(emailUsuario).matches())
	            {
	                
	            }
	            else
	            {
	                throw new Incorrecto ("El correo tiene que terminar en @gmail.com");
	            }
				
			}
			
			/**
			 * Este m�todo sirve para comprobar que no haya otro user igual
			 * @param userUsuario user del usuario
			 * @param diccionarioEstudiantes la lista de todos los estudiantes
			 * @param diccionarioTrabajadores la lista de todos los trabajadores
			 * @throws UsuarioRepetido si se mete un user repetido saltar� la excepci�n UsuarioRepetido
			 */


			private void comprobarPersonas(String userUsuario, ArrayList<Estudiante> diccionarioEstudiantes, ArrayList <Trabajador> diccionarioTrabajadores)
					throws UsuarioRepetido {
				
				for (Estudiante a : diccionarioEstudiantes) {
					if (a.getUser().equals(userUsuario)) {
						throw new UsuarioRepetido("No puedes introducir el user de usuario repetido");
					}
				}

			}
			
			/**
			 * Este m�todo sirve para comprobar que no hay un dni igual en nuestra universidad
			 * @param dni dni introducido
			 * @param diccionarioEstudiantes lista de todos los estudiantes
			 * @param diccionarioTrabajadores lista de todos los trabajadores
			 * @throws UsuarioRepetido si se mete un dni repetido saltar� la excepci�n UsuarioRepetido
			 */
			
			private void comprobarDniRepetido (String dni, ArrayList<Estudiante> diccionarioEstudiantes, ArrayList <Trabajador>diccionarioTrabajadores) 
			throws UsuarioRepetido{
				
				for (Estudiante a: diccionarioEstudiantes) {
					if(a.getDni().equals(dni)) {
						throw new UsuarioRepetido ("No puedes introducir un dni repetido");
					}
				}
				
				for (Trabajador a: diccionarioTrabajadores) {
					if(a.getDni().equals(dni)) {
						throw new UsuarioRepetido ("No puedes introducir un dni repetido");
					}
				}
			}
			
			/**
			 * Este m�todo sirve para comprobar que un dni est� compuesto de 8 n�meros al principio
			 * @param arrayDNI el array del DNI. En cada posici�n hay un caracter.
			 * @throws Incorrecto si no son n�meros los primeros 8 caracteres saltar� la excepci�n Incorrecto
			 */
			
			 private void comprobardninumeros(char[] arrayDNI) throws Incorrecto
			    {
			        
			        char ascii=0;

			        for (byte i=0; i<8; i++)
			        {
			            ascii = arrayDNI[i];

			            if (ascii>=48 && ascii<=57)
			            {
			                
			            }

			            else
			            {
			                
			                throw new Incorrecto ("El dni tiene que tener 8 n�meros al principio");
			            }
			        }


			    }
			 
			 /**
			  * Este m�todo sirve para comprobar que el noveno caracter del dni es una letra
			  * @param arrayDNI el array del DNI. En cada posici�n hay un caracter.
			 * @throws Incorrecto si no son n�meros los primeros 8 caracteres saltar� la excepci�n Incorrecto
			  */

			    private void comprobardniletra(char[] arrayDNI) throws Incorrecto
			    {

			      
			        char ultimaletra = arrayDNI[arrayDNI.length-1];

			        if (ultimaletra>=65 && ultimaletra<=90)
			        {
			           
			        }

			        else
			        {
			            
			            throw new Incorrecto ("El dni tiene que tener una letra al final");
			        }
			        
			       

			    }
			    
			    /**
			     * Este m�todo sirve para comprobar que los �ltimos 22 son n�meros
			     * @param arrayIban el array del iban. En cada posici�n hay un caracter.
			     * @throws Incorrecto si no es correcto salta la excepci�n Incorrecto
			     */
			    
			    public void comprobaribannumeros(char[] arrayIban) throws Incorrecto
			    {
			        
			        char ascii=0;

			        for (byte i=2; i<23; i++)
			        {
			            ascii = arrayIban[i];

			            if (ascii>=48 && ascii<=57)
			            {
			                
			            }

			            else
			            {
			                throw new Incorrecto ("El iban tiene que tener 22 d�gitos al final");
			            }
			        }

			       
			    }
			    
			    /**
			     * Sirve para comprobar que al principio del iban hay dos letras
			     * @param arrayIban el array del iban. En cada posici�n hay un caracter.
			     * @throws Incorrecto si no es correcto salta la excepci�n Incorrecto
			     */

			    public void comprobaribanletra(char[] arrayIban) throws Incorrecto {

			        char primeraLetra = arrayIban[0];
			        char segundaLetra=arrayIban [1];


			        if ((primeraLetra>=65 && primeraLetra<=90) && (segundaLetra >=65 && segundaLetra<=90))
			        {
			           
			        }

			        else
			        {
			            throw new Incorrecto ("El iban tiene que tener dos letras al principio");
			        }

			       
			    }

			
			
			
		});
		
		
		
		
	}
}
