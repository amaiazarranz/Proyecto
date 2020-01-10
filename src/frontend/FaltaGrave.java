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
import usuarios.Estudiante;
import usuarios.Persona;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 * Esta clase sirve para poner una falta grave a un alumno
 * @author Alumno Amaia y Olatz
 *
 */

public class FaltaGrave extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;

	/**
	 * Aquí se procederá a poner una falta grave a un alumno
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 * @param profe la persona
	 * @param atras la ventana VentanaProfesor
	 */
	
	public FaltaGrave(ArrayList <Estudiante> diccionarioEstudiantes, Persona profe, VentanaProfesor atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPonerUnaFalta = new JLabel("Poner una falta grave a:");
		lblPonerUnaFalta.setBounds(133, 16, 170, 20);
		contentPane.add(lblPonerUnaFalta);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(298, 186, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.setBounds(157, 186, 115, 29);
		contentPane.add(btnAtrs);
		
		
		list = new JList();
		list.setBounds(15, 44, 398, 115);
		//contentPane.add(list); quitar esto para añadir el scroll
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(15, 44, 398, 115);
		contentPane.add(scrollPane);
		
		cargarLista(diccionarioEstudiantes);
		
//		Clase abstracta
		
		class ClickListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				atras.setVisible(true);
				FaltaGrave.this.setVisible(false);
			}
		}
		ClickListener a1 = new ClickListener();
		btnAtrs.addActionListener(a1);

//		IMPLEMENTACION ANTERIOR SIN CLASE ABSTRACTA
		
//		btnAtrs.addActionListener(new ActionListener() {
//			
//			/**
//			 * Acción para volver a la pantalla anterior
//			 */
//			public void actionPerformed(ActionEvent e) {
//
//				atras.setVisible(true);
//				FaltaGrave.this.setVisible(false);
//			}
//		});
		
		btnOk.addActionListener(new ActionListener() {
			
			/**
			 * Acción para poner una falta grave
			 */
			public void actionPerformed(ActionEvent e) {

				String user = (String) list.getSelectedValue();

				if (user != null) {
					

//					Estudiante modificar = null;

					Estudiante efalta= diccionarioEstudiantes.stream().filter(s -> s.getUser().equals(user)).findFirst().get();
//					for (Estudiante b : diccionarioEstudiantes) {
//						
//						if (b.getUser().equals(user)) {
//							modificar = b;
//							break;
//						}
//					}
				
					efalta.setFaltagrave(efalta.getFaltagrave()+1);
					
					try {
						DBManager.actualizarFaltaGrave(user, efalta.getFaltagrave()+1);
			            
			        } catch (SQLException e1) {
			            e1.printStackTrace();
			        }
					
					JOptionPane.showMessageDialog(FaltaGrave.this, "Ya se ha registrado la nueva falta ");
					
				
				}
				
				FaltaGrave.this.setVisible(false);
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
