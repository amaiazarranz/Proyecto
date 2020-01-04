package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import usuarios.Estudiante;
import usuarios.Persona;
import utilidades.MergeSortGenerico;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Tablon extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JTextField textField;

	public Tablon(Persona estu, VentanaEstudiantes atras) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				atras.setVisible(true);
				Tablon.this.setVisible(false);
			}
		});
		btnAtrs.setBounds(284, 199, 115, 29);
		contentPane.add(btnAtrs);
		
		JLabel lblRanking = new JLabel("Tus esquemas de hoy en sucio:");
		lblRanking.setBounds(39, 16, 230, 20);
		contentPane.add(lblRanking);
		
		list = new JList();
		list.setBounds(39, 39, 350, 152);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(15, 44, 398, 115);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(25, 183, 244, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEscribeTuDuda = new JLabel("Escribe aqu� tu esquema");
		lblEscribeTuDuda.setBounds(56, 160, 152, 20);
		contentPane.add(lblEscribeTuDuda);
		
		JButton btnEscribir = new JButton("Escribir");
		btnEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cargarLista();
			}
		});
		btnEscribir.setBounds(284, 166, 115, 29);
		contentPane.add(btnEscribir);
		
		
		
	}

	private void cargarLista() {
		
		DefaultListModel lista = new DefaultListModel();
		
		String escrito = textField.getText();
		
		HashMap <Integer, String> map = new HashMap <Integer, String>();
		map.put(1, escrito);
		
		Collection<String> values = map.values(); 
        ArrayList<String> listOfValues = new ArrayList<String>(values); 
         
        System.out.println("ArrayList Of Values :"); 
         
        for (String value : listOfValues) 
        { 
            System.out.println(value);
            lista.addElement(value);
        } 

		list.setModel(lista);
		
	}
}
