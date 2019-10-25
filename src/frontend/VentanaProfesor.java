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
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VentanaProfesor extends JFrame {

	private JPanel contentPane;

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
		btnCalificarEstudiantes.setBounds(107, 73, 202, 29);
		contentPane.add(btnCalificarEstudiantes);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(139, 135, 131, 26);
		
		comboBox.addItem("1.Poner falta leve"); 
		comboBox.addItem("2.Poner falta grave");
		
		comboBox.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent e) {
				
				VentanaProfesor.this.setVisible(false);
				atras.setVisible(true);
				
			}
		});
		btnCancel.setBounds(298, 199, 115, 29);
		contentPane.add(btnCancel);
		
	}
}
