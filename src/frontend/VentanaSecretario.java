package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Estudiante;
import usuarios.Persona;
import usuarios.Trabajador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta es la ventana que se les muestra a los secretarios
 * @author Alumno Amaia y Olatz
 *
 */


public class VentanaSecretario extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Aquí se muestra la ventana visual de los secretarios
	 * @param diccionarioTrabajador la lista de los trabajadores
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 * @param estu la persona que accede
	 * @param atras la ventana LoginVisual
	 */

	public VentanaSecretario(ArrayList <Trabajador> diccionarioTrabajador, ArrayList <Estudiante> diccionarioEstudiante, Persona secre, LoginVisual atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Secretario: "+secre.getNombre());
		lblBienvenido.setBounds(41, 28, 266, 20);
		contentPane.add(lblBienvenido);
		
		JButton btnExpulsar = new JButton("Expulsar");
		btnExpulsar.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para entrar en la ventana de expulsar
			 */
			public void actionPerformed(ActionEvent e) {
				
				Expulsar ventana= new Expulsar(diccionarioEstudiante, secre, VentanaSecretario.this);
				ventana.setVisible(true);
				VentanaSecretario.this.dispose();
				
			}
		});
		btnExpulsar.setBounds(153, 100, 115, 29);
		contentPane.add(btnExpulsar);
		
		JLabel lblquDeseaHacer = new JLabel("\u00BFQu\u00E9 desea hacer?");
		lblquDeseaHacer.setBounds(143, 64, 164, 20);
		contentPane.add(lblquDeseaHacer);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para volver a la ventana anterior
			 */
			public void actionPerformed(ActionEvent e) {
				
				VentanaSecretario.this.setVisible(false);
				atras.setVisible(true);
				CerrarSesion1();
			}
		});
		btnCerrarSesin.setBounds(246, 199, 155, 29);
		contentPane.add(btnCerrarSesin);
		
		
	}
	
	/**
	 * Método en el que se enseña el mensaje de que se ha cerrado sesión
	 */
	
	public static void CerrarSesion1() {
		
		JOptionPane.showMessageDialog(null, "Has cerrado sesión");
		
	}

}
