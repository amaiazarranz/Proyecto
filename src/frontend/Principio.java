package frontend;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sqlite.SelectData;
import usuarios.Estudiante;
import usuarios.Trabajador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * Esta es la ventana introductorio para entrar a nuestra gestón de la universidad de deusto
 * @author Alumno Olatz y Amaia
 *
 */

public class Principio extends JFrame {

	private JPanel contentPane;
	
	ArrayList<Estudiante> diccionarioEstudiantes;
    ArrayList <Trabajador> diccionarioTrabajadores;

	/**
	 * Lanza la aplicación.
	 */
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principio frame = new Principio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame. Esto es el principio
	 */
	
	public Principio() {
		
		 diccionarioEstudiantes= SelectData.selectAllEstudiantes();
	     diccionarioTrabajadores= SelectData.selectAllTrabajadores();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel foto = new JLabel("New label");
		foto.setIcon(new ImageIcon("images/Deusto.jpg"));
		foto.setBounds(15, 16, 398, 176);
		contentPane.add(foto);

		JButton btnInicio = new JButton("Iniciar sesión");
		btnInicio.addActionListener(new ActionListener() {
			
			/**
			 * Aquí se clica para iniciar sesión
			 */
			public void actionPerformed(ActionEvent arg0) {

				LoginVisual ventana = new LoginVisual(diccionarioEstudiantes, diccionarioTrabajadores, Principio.this);
				ventana.setVisible(true);
				Principio.this.dispose();
			}
		});
		btnInicio.setBounds(129, 199, 135, 29);
		contentPane.add(btnInicio);

		JButton btnSalir = new JButton("Automatriculación");
		btnSalir.addActionListener(new ActionListener() {
			
			/**
			 * Aquí se pincha para poder automatricularse
			 */
			public void actionPerformed(ActionEvent e) {
				
				Automatriculacion ventana= new Automatriculacion(diccionarioEstudiantes, diccionarioTrabajadores, Principio.this);
				ventana.setVisible(true);
				Principio.this.dispose();

				
			}
		});
		btnSalir.setBounds(275, 199, 149, 29);
		contentPane.add(btnSalir);
	}
}
