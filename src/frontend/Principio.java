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
 * Esta es la ventana introductorio para entrar a nuestra gest�n de la universidad de deusto
 * @author Alumno Olatz y Amaia
 *
 */
public class Principio extends JFrame {

	private JPanel contentPane;
	
	ArrayList<Estudiante> diccionarioEstudiantes;
    ArrayList <Trabajador> diccionarioTrabajadores;

	/**
	 * Lanza la aplicaci�n.
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

		JButton btnInicio = new JButton("Iniciar sesi�n");
		btnInicio.addActionListener(new ActionListener() {
			
			/**
			 * Aqu� se clica para iniciar sesi�n
			 */
			public void actionPerformed(ActionEvent arg0) {

				LoginVisual ventana = new LoginVisual(diccionarioEstudiantes, diccionarioTrabajadores, Principio.this);
				ventana.setVisible(true);
				Principio.this.dispose();
			}
		});
		btnInicio.setBounds(129, 199, 135, 29);
		contentPane.add(btnInicio);

		JButton btnSalir = new JButton("Automatriculaci�n");
		btnSalir.addActionListener(new ActionListener() {
			
			/**
			 * Aqu� se pincha para poder automatricularse
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
