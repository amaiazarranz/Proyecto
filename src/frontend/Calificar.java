package frontend;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Esta clase sirve para calificar a los alumnos
 * @author Alumno Amaia y Olatz
 *
 */


public class Calificar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList list;

	/**
	 * Aquí los profesores califican a los estudiantes
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 * @param profe el profesor que califica
	 * @param atras la ventanaprofesor
	 */
	
	public Calificar(ArrayList <Estudiante> diccionarioEstudiantes, Persona profe, VentanaProfesor atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalificar = new JLabel("Calificar:");
		lblCalificar.setBounds(180, 16, 69, 20);
		contentPane.add(lblCalificar);
		
		JLabel lblNuevaCalificacin = new JLabel("Nueva calificaci\u00F3n:");
		lblNuevaCalificacin.setBounds(15, 172, 156, 20);
		contentPane.add(lblNuevaCalificacin);
		
		textField = new JTextField();
		textField.setBounds(180, 169, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			atras.setVisible(true);
			Calificar.this.setVisible(false);
			}
		});
		btnAtrs.setBounds(180, 211, 115, 29);
		contentPane.add(btnAtrs);
		
		JButton btnOk = new JButton("OK");

		btnOk.setBounds(298, 211, 115, 29);
		btnOk.setEnabled(false);
		contentPane.add(btnOk);
		
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				btnOk.setEnabled(true);
			}
		});

		list.setBounds(15, 44, 398, 115);
		//contentPane.add(list); quitar esto para añadir el scroll
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(15, 44, 398, 115);
		contentPane.add(scrollPane);
		
		cargarLista(diccionarioEstudiantes);
		

//		if(list.getSelectedValue()!= null){
//			btnOk.setEnabled(true);
//		}
			
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nota;
				String user;
				nota=Integer.parseInt(textField.getText());
				if (!comprobar(nota))
				{
					JOptionPane.showMessageDialog(Calificar.this, "Nota no válida");
				}else {
				
				user=(String) list.getSelectedValue(); 
				//consigues un arraylist de tipo string con los users q coincidan con el seleccionado en jlist.
			    //diccionarioEstudiantes.stream().filter(z -> z.getUser().equals(user)).map(Estudiante::getUser);
				
				Estudiante student = diccionarioEstudiantes.stream().filter(z -> z.getUser().equals(user)).findFirst().get(); //para pasar de optional a estudiante
				//siempre que no sea array haces el get
				
//				for (Estudiante b : diccionarioEstudiantes) {
//					
//					if (b.getUser().equals(user)) {
//						a=b;
//						break;
//					}
//						
//				}
//				a.getNotasmedias().add(nota);
				student.getNotasmedias().add(nota); 
				
				//int sumnotas=0;
				int numnotas=student.getNotasmedias().size();
				
				int sumnotas = student.getNotasmedias().stream().reduce(0, (subtotal, element) -> subtotal + element);
				 //empieza a contar desde 0. 
				
//				for (int i=0; i<student.getNotasmedias().size();i++ ) {
//					sumnotas+=student.getNotasmedias().get(i);
//					
//				}
				int media=sumnotas/(numnotas+1);
				student.setNotamedia(media);
				
				System.out.println(sumnotas);
				System.out.println(numnotas+1);
				System.out.println(media);
				
				
				
				try {
					DBManager.actualizarNotaMedia(student.getUser(), media);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(Calificar.this, "El alumno ha sido calificado correctamente ");
				
				atras.setVisible(true);
				Calificar.this.setVisible(false);
				
				}
			}
			
			
			
			public boolean comprobar (int variable) {
				boolean compr= false;
				if (variable>=0&& variable<=10)
				{
					compr=true;
				}
				return compr;
				
			}
			
			
		});
		
	}
	 
	/**
	 * Este método sirve para cargar en la Jlist los estudiantes que podemos calificar
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
