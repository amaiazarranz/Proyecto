package frontend;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import excepciones.NombreUsuarioRepetido;
import sqlite.DBManager;
import usuarios.Estudiante;
import usuarios.Trabajador;

import javax.swing.JButton;

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
	 * Create the frame.
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
			public void actionPerformed(ActionEvent e) {

				atras.setVisible(true);
				Automatriculacion.this.setVisible(false);
			}
		});
		
		
		btnOk.addActionListener(new ActionListener() {
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
				nombreUsuario = nombre.getText();
				apellido1Usuario=apellido1.getText();
				apellido2Usuario=apellido2.getText();
				userUsuario=user.getText();
				contrasenaUsuario=pass.getText();
				emailUsuario=email.getText();
				ibanUsuario=iban.getText();
				
				
				try {

					comprobarPersonas(userUsuario, diccionarioEstudiantes, diccionarioTrabajadores);


					Estudiante user = new Estudiante(nombreUsuario, apellido1Usuario, apellido2Usuario, dniUsuario, userUsuario, contrasenaUsuario,
							emailUsuario, ibanUsuario, "estudiante", 0.0, 0,0);
					diccionarioEstudiantes.add(user);
					
					DBManager.insertEstudiante(nombreUsuario, apellido1Usuario, apellido2Usuario, dniUsuario, userUsuario, contrasenaUsuario,
							emailUsuario, ibanUsuario, "estudiante", 0.0, 0,0);

					

					JOptionPane.showMessageDialog(Automatriculacion.this, "Ya se dado alta al usuario");

				} catch (NombreUsuarioRepetido i) {

					JOptionPane.showMessageDialog(Automatriculacion.this, i.getMessage());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			

			private void comprobarPersonas(String userUsuario, ArrayList<Estudiante> diccionarioEstudiantes, ArrayList <Trabajador> diccionarioTrabajadores)
					throws NombreUsuarioRepetido {
				
				for (Estudiante a : diccionarioEstudiantes) {
					if (a.getUser().equals(userUsuario)) {
						throw new NombreUsuarioRepetido("No puedes introducir el user de usuario repetido");
					}
				}

			}
		});
		
		
		
		
	}
}
