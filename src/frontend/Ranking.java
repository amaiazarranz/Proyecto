package frontend;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import usuarios.Estudiante;
import usuarios.Persona;
import utilidades.MergeSort;
import utilidades.MergeSortGenerico;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;

/**
 * En esta clasee aparecerá el ranking de notas de los alumnos según sus notas para así luego poder valorar a los mejores
 * @author Alumno Amaia y Olatz
 *
 */

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JList list;
	

	public Ranking(ArrayList <Estudiante> diccionarioEstudiantes, Persona estu, VentanaEstudiantes atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			
			/**
			 * Acción de volver a la ventana de estudiantes
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				atras.setVisible(true);
				Ranking.this.setVisible(false);
				
			}
		});
		btnAtrs.setBounds(298, 199, 115, 29);
		contentPane.add(btnAtrs);
		
		list = new JList();
		list.setBounds(39, 39, 350, 152);
		//contentPane.add(list);
		
		JLabel lblRanking = new JLabel("Ranking:");
		lblRanking.setBounds(39, 16, 69, 20);
		contentPane.add(lblRanking);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(15, 44, 398, 115);
		contentPane.add(scrollPane);
		
		long count= diccionarioEstudiantes.stream().filter(w->w.getNotamedia()>=5.0).count();
		long total=diccionarioEstudiantes.stream().count();
		long calculo=count/total*100;
		
		JLabel lblNmeroDeAprobados = new JLabel("N\u00FAmero de aprobados: " + count + " de un total de "+ total+ " estudiantes");
		lblNmeroDeAprobados.setBounds(15, 175, 398, 20);
		contentPane.add(lblNmeroDeAprobados);
		
		//cargarLista(diccionarioEstudiantes);
		cargarListaMerge(diccionarioEstudiantes);
		
	}
	
	private void cargarListaMerge(ArrayList<Estudiante> diccionarioEstudiantes) {
		// TODO Auto-generated method stub
		DefaultListModel lista = new DefaultListModel();
		
		//MergeSort.mergesort(diccionarioEstudiantes, 0, diccionarioEstudiantes.size()-1);
		MergeSortGenerico.introducir(diccionarioEstudiantes);
		
		for (Estudiante a: diccionarioEstudiantes) {
			
			lista.addElement(a.getNombre() +" "+ a.getNotamedia());
			
		}

		list.setModel(lista);
		
	}

	/**
	 * Método para cargar la lista
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 */


	private void cargarLista(ArrayList<Estudiante> diccionarioEstudiantes) {
		// TODO Auto-generated method stub
		
		DefaultListModel lista = new DefaultListModel();
		
		MergeSort.mergesort(diccionarioEstudiantes, 0, diccionarioEstudiantes.size()-1);
		
		for (Estudiante a: diccionarioEstudiantes) {
			
			lista.addElement(a.getNombre() +" "+ a.getNotamedia());
			
		}

		list.setModel(lista);
		
		
	}
}
