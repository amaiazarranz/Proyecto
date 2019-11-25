package frontend;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JComboBox;

/**
 * Esta es la ventana que se les muestra a los profesores
 * @author Alumno Amaia y Olatz
 *
 */


public class VentanaProfesor extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Aquí se muestra la ventana visual de los profesores
	 * @param diccionarioTrabajador la lista de los trabajadores
	 * @param estu la persona que accede
	 * @param atras la ventana LoginVisual
	 */

	public VentanaProfesor(ArrayList <Trabajador> diccionarioTrabajador, ArrayList <Estudiante> diccionarioEstudiante, Persona profe, LoginVisual atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHola = new JLabel("Profesor: "+profe.getNombre());
		lblHola.setBounds(15, 16, 214, 20);
		contentPane.add(lblHola);
		
		JLabel lblquDeseaRealizar = new JLabel("\u00BFQu\u00E9 desea realizar?");
		lblquDeseaRealizar.setBounds(132, 37, 188, 20);
		contentPane.add(lblquDeseaRealizar);
		
		JButton btnCalificarEstudiantes = new JButton("Calificar estudiantes");
		btnCalificarEstudiantes.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para entrar en la ventana de calificación de estudiantes
			 */
			
			public void actionPerformed(ActionEvent arg0) {
				
				Calificar ventana= new Calificar (diccionarioEstudiante, profe, VentanaProfesor.this);
				ventana.setVisible(true);
				VentanaProfesor.this.setVisible(false);
			}
		});
		btnCalificarEstudiantes.setBounds(107, 73, 202, 29);
		contentPane.add(btnCalificarEstudiantes);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(139, 135, 131, 26);
		
		comboBox.addItem("1.Poner falta leve"); 
		comboBox.addItem("2.Poner falta grave");
		
		comboBox.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para poner posteriormente faltas leves o graves
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				String seleccionar = (String) comboBox.getSelectedItem();
				
				if (seleccionar.equals("1.Poner falta leve")) {
					
					FaltaLeve ventana = new FaltaLeve (diccionarioEstudiante, profe, VentanaProfesor.this);
					ventana.setVisible(true);
					VentanaProfesor.this.setVisible(false);
				}
				else if (seleccionar.equals("2.Poner falta grave")) {
					
					FaltaGrave ventana = new FaltaGrave (diccionarioEstudiante, profe, VentanaProfesor.this);
					ventana.setVisible(true);
					VentanaProfesor.this.setVisible(false);
						
				}
				
			}
		});
		
		contentPane.add(comboBox);
		
		JLabel lblPonerFaltas = new JLabel("Poner faltas:");
		lblPonerFaltas.setBounds(139, 110, 138, 20);
		contentPane.add(lblPonerFaltas);
		
		JButton btnCancel = new JButton("Cerrar sesión");
		btnCancel.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para volver atrás
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				VentanaProfesor.this.setVisible(false);
				atras.setVisible(true);
				CerrarSesion1();
				
			}
		});
		btnCancel.setBounds(298, 199, 115, 29);
		contentPane.add(btnCancel);
		
	}
	
	public static void CerrarSesion1() {
		
		JOptionPane.showMessageDialog(null, "Has cerrado sesión");
		
	}
}
