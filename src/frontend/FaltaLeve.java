package frontend;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import sqlite.DBManager;
import sqlite.SelectData;
import usuarios.Estudiante;
import usuarios.Persona;
import usuarios.Profesor;
import usuarios.Trabajador;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 * Esta clase sirve para poner una falta leve a un alumno
 * @author Alumno Amaia y Olatz
 *
 */

public class FaltaLeve extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;


	/**
	 * Aquí se procederá a poner una falta leve a un alumno
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 * @param profe la persona
	 * @param atras la ventana VentanaProfesor
	 */
	
	public FaltaLeve(ArrayList <Estudiante> diccionarioEstudiantes, Persona profe, VentanaProfesor atras)
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPonerUnaFalta = new JLabel("Poner una falta leve:");
		lblPonerUnaFalta.setBounds(138, 16, 176, 20);
		contentPane.add(lblPonerUnaFalta);
		
		JLabel lblNmeroDeFaltas = new JLabel("N\u00FAmero de faltas leves:");
		lblNmeroDeFaltas.setBounds(28, 175, 188, 20);
		contentPane.add(lblNmeroDeFaltas);
		
		textField = new JTextField();
		textField.setBounds(231, 172, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(298, 199, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(169, 199, 115, 29);
		contentPane.add(btnAtrs);
		
		list = new JList();
		list.setBounds(15, 44, 398, 115);
		//contentPane.add(list); quitar esto para añadir el scroll
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(15, 44, 398, 115);
		contentPane.add(scrollPane);
		
		cargarLista(diccionarioEstudiantes);
		
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				atras.setVisible(true);
				FaltaLeve.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String user = (String) list.getSelectedValue();

				if (user != null) {
					
					String numero = textField.getText();
					int numero1 = Integer.parseInt(numero);

					Estudiante modificar = null;

					for (Estudiante b : diccionarioEstudiantes) {
						
						if (b.getUser().equals(user)) {
							modificar = b;
							break;
						}
					}

					modificar.setFaltaleve(numero1);
					
					try {
			            SelectData.actualizarFaltaLeve(user, numero1);
			            
			        } catch (SQLException e1) {
			            e1.printStackTrace();
			        }
					
					JOptionPane.showMessageDialog(FaltaLeve.this, "Ya se ha realizado el cambio ");
					
				
				}
				FaltaLeve.this.setVisible(false);
				atras.setVisible(true);
				
			}

			

			
		});

	}
	
	/**
	 * Este método sirve para cargar la lista de todos los alumnos
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 */


	private void cargarLista(ArrayList<Estudiante> diccionarioEstudiantes) {
		// TODO Auto-generated method stub
		
		DefaultListModel lista = new DefaultListModel();

		for (Estudiante a : diccionarioEstudiantes) {
			
			lista.addElement(a.getUser());
		}
		

		list.setModel(lista);
		
	}
}
