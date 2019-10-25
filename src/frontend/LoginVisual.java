package frontend;

import sqlite.SelectData;

import usuarios.Estudiante;
import usuarios.Persona;
import usuarios.Profesor;
import usuarios.Secretario;
import usuarios.Trabajador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import excepciones.UsuariosNoExiste;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginVisual extends JFrame{

    private JTextField textUsuario;
    private JPasswordField textContrasena;
    private String usuario;
    private String password;
    JPanel f;
    ArrayList<Estudiante> diccionarioEstudiantes;
    ArrayList <Trabajador> diccionarioTrabajadores;

	
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    Persona estu = new Estudiante();
	Persona secre = new Secretario();
	Persona profe= new Profesor();
	

    public LoginVisual(ArrayList <Estudiante> diccionarioEstudiantes, ArrayList <Trabajador> diccionarioTrabajadores, Principio principio) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // diccionarioEstudiantes= SelectData.selectAllEstudiantes();
       // diccionarioTrabajadores= SelectData.selectAllTrabajadores();

        setBounds(100, 100, 450, 300);
        f=new JPanel();
        f.setBorder(new EmptyBorder(5, 5, 5, 5));
        f.setLayout(null);

        setContentPane(f);

        JLabel lblUsuario = new JLabel("Usuario:" );
        lblUsuario.setBounds(20, 100, 300, 30);
        lblUsuario.setForeground(Color.WHITE);
        f.add(lblUsuario);

        textUsuario = new JTextField (20);
        textUsuario.setBounds(100, 100, 300, 30);
        f.add(textUsuario);

        JLabel lblContrasena = new JLabel("Contrasena:" );
        lblContrasena.setBounds(20, 140, 300, 30);
        lblContrasena.setForeground(Color.WHITE);
        f.add(lblContrasena);

        textContrasena = new JPasswordField (20);
        textContrasena.setEchoChar('*');
        textContrasena.setToolTipText("Contrasena");
        textContrasena.setBounds(100, 140, 300, 30);
        f.add(textContrasena);

        JButton boton1 = new JButton("Entrar");
        boton1.setBounds(213, 186, 200, 30);
        
        boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				usuario = textUsuario.getText();

				password = textContrasena.getText();

				try {

					boolean encontradoPersona = comprobarPersona(usuario, password, diccionarioEstudiantes, diccionarioTrabajadores);
					
					if(encontradoPersona) {
						
						if(secre.getTipopersona().equals("estudiante")) {
						
						VentanaEstudiantes ventana= new VentanaEstudiantes (diccionarioEstudiantes, estu, LoginVisual.this);
						ventana.setVisible(true);
						LoginVisual.this.dispose();
						
						}
						
						else if (secre.getTipopersona().equals("secretario")) {
							
							VentanaSecretario ventana = new VentanaSecretario (diccionarioTrabajadores, diccionarioEstudiantes, secre, LoginVisual.this);
							ventana.setVisible(true);
							LoginVisual.this.dispose();
							
						} 
						else {
							VentanaProfesor ventana = new VentanaProfesor (diccionarioTrabajadores, diccionarioEstudiantes, profe, LoginVisual.this);
							ventana.setVisible(true);
							LoginVisual.this.dispose();
							
						}
					}
				

				} catch (UsuariosNoExiste e1) {
					JOptionPane.showMessageDialog(LoginVisual.this, e1.getMessage());
				}
				
				
			}

		});

        f.add(boton1);
        f.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        
        //poner el ultimo elemento para ponerlo abajo
        
        JLabel foto = new JLabel("New label");
		foto.setIcon(new ImageIcon("images/Deusto1.jpg"));
		foto.setBounds(15, 16, 400, 200);
		f.add(foto);
		
		JButton btnCancel = new JButton("Atrás");
		btnCancel.setBounds(15, 187, 183, 29);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				principio.setVisible(true);
				LoginVisual.this.setVisible(false);
			}
		});
		f.add(btnCancel);

        setVisible(true);
    }
    
    
    private boolean comprobarPersona(String usuario, String password, ArrayList<Estudiante> diccionarioEstudiante, ArrayList<Trabajador> diccionarioTrabajadores)
			throws UsuariosNoExiste {

		boolean existe = false;
		

		for (Estudiante a : diccionarioEstudiante) {
			if (a.getUser().equals(usuario)) {
				existe = true;

				if (a.getPassword().equals(password)) {
					estu = (Persona) a;
					secre = (Persona) a;
					profe= (Persona) a;
					existe = true;
					break;
				} else {
					throw new UsuariosNoExiste("Contraseña incorrecta");

				}
			}
		}
		
		
		for (Trabajador a : diccionarioTrabajadores) {
			if (a.getUser().equals(usuario)) {
				existe = true;

				if (a.getPassword().equals(password)) {
					estu = (Persona) a;
					secre = (Persona) a;
					profe= (Persona) a;
					existe = true;
					break;
				} else {
					throw new UsuariosNoExiste("Contraseña incorrecta");

				}
			}
		}
		

		if (!existe) {

			throw new UsuariosNoExiste("Usuario no existente");
		}
		
		return true;

	}
    

}
