package frontend;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import usuarios.Persona;
import usuarios.Trabajador;
import utilidades.MergeSort;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 * Esta clase nos permitirá ver la variedad de salarios de la empresa
 * @author Alumno Amaia y Olatz
 *
 */

public class Salarios extends JFrame {

	private JPanel contentPane;
	private JList list;

	/**
	 * Create the frame.
	 */
	
	public Salarios(ArrayList <Integer> salarios, Persona trabajador, VentanaProfesor atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(e-> 
		{				
				atras.setVisible(true);
				Salarios.this.setVisible(false);
				
		});
		btnAtrs.setBounds(298, 199, 115, 29);
		contentPane.add(btnAtrs);
		
		list = new JList();
		list.setBounds(39, 39, 350, 152);
		
		JLabel lblRanking = new JLabel("Salarios ordenados de menor a mayor");
		lblRanking.setBounds(15, 16, 398, 20);
		contentPane.add(lblRanking);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(15, 44, 398, 115);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("El nombre del trabajador es anónimo");
		lblNewLabel.setBounds(25, 175, 284, 20);
		contentPane.add(lblNewLabel);
		
		cargarListaQuickSort(salarios);
	}
	
	/**
	 * Método para cargar los salarios en la defaultlistmodel
	 * @param salarios el arraylist con los salarios
	 */

	private void cargarListaQuickSort(ArrayList <Integer> salarios) {
		
		DefaultListModel lista = new DefaultListModel();
			
		for (Integer a: salarios) {
			
			lista.addElement(a);
			
		}

		list.setModel(lista);
		
	}
}
