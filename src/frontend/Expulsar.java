package frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Esta clase sirve para que los secretarios expulsen a los alumnos por mala conducta
 * @author Alumno Amaia y Olatz
 *
 */

public class Expulsar extends JFrame {

	private JPanel contentPane;
	private JList list;
	
	/**
	 * Se proceder� a la expulsi�n
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 * @param user la persona
	 * @param atras la ventana VentanaSecretario
	 */

	public Expulsar(ArrayList <Estudiante> diccionarioEstudiantes, Persona user, VentanaSecretario atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLosAlumnosCon = new JLabel("Los alumnos con 3 faltas leves o 1 grave: ");
		lblLosAlumnosCon.setBounds(58, 16, 319, 20);
		contentPane.add(lblLosAlumnosCon);
		
		JButton btnOk = new JButton("Expulsar");
		btnOk.setForeground(Color.BLUE);
		btnOk.setBounds(308, 63, 105, 29);
		btnOk.setEnabled(false);
		contentPane.add(btnOk);

		JButton btnCancel = new JButton("Atr�s");
		btnCancel.setForeground(Color.BLUE);
		btnCancel.setBounds(308, 108, 105, 29);
		contentPane.add(btnCancel);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnOk.setEnabled(true);
				
				HiloSecretario hilo= new HiloSecretario();
				hilo.start();
				
			}
		});
		list.setBounds(14, 40, 284, 204);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list); 
		scrollPane.setBounds(14, 40, 284, 204);
		contentPane.add(scrollPane);
		
		cargarLista (diccionarioEstudiantes);
		
		btnCancel.addActionListener(new ActionListener() {
			
			/**
			 * Acci�n para volver a la pantalla anterior
			 */
			
			public void actionPerformed(ActionEvent e) {

				atras.setVisible(true);
				Expulsar.this.setVisible(false);

			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			/**
			 * Acci�n de expulsar a un estudiante
			 */
			public void actionPerformed(ActionEvent e) {

//				List <Estudiante> hola=diccionarioEstudiantes.stream().sorted(Comparator.comparingDouble(Estudiante::getNotamedia).reversed()).collect(Collectors.toList());
//				System.out.println(hola);
//con el reserved de mas a menos te ordena y sino de menos a mas
				
				String user = (String) list.getSelectedValue();
				
				

				if (user != null) // para que no de el nullpointer
				{
					
					diccionarioEstudiantes.stream().filter(a -> a.getUser().toUpperCase().compareTo(user.toUpperCase()) != 0); //no lo ha borrado de la arraylist, solo de la bd
					
//			 	ArrayList <Estudiante> estudianteJon= (ArrayList<Estudiante>) diccionarioEstudiantes.stream().filter(a -> a.getUser().toUpperCase().compareTo(user.toUpperCase()) != 0).collect(Collectors.toList());					
					
//					for (Estudiante a : diccionarioEstudiantes) {
//						
//						if (a.getUser().toUpperCase().compareTo(user.toUpperCase()) == 0) {
//							diccionarioEstudiantes.remove(a);
//							break;
//						}
//					}
					
				 	
					DBManager.delete(user);
					
					JOptionPane.showMessageDialog(Expulsar.this, "Ya se ha expulsado el alumno");
				}
				
				Expulsar.this.setVisible(false);
				atras.setVisible(true);
			}
		});
	}
	
	/**
	 * Este m�todo sirve para cargar la lista de los alumnas que corren el peligro de ser expulsados
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 */

	private void cargarLista(ArrayList<Estudiante> diccionarioEstudiantes) {
		// TODO Auto-generated method stub
		DefaultListModel lista = new DefaultListModel();
		
		String user3= (String) list.getSelectedValue();

		for (Estudiante a : diccionarioEstudiantes) {
			
			if (a.getFaltagrave()>=1 || a.getFaltaleve()>=3) {
				
				lista.addElement(a.getUser());
			}
		}

		list.setModel(lista);
		
	}

}
