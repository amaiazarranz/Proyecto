package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Estudiante;
import usuarios.Persona;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEstudiantes extends JFrame {

	private JPanel contentPane;

	public VentanaEstudiantes(ArrayList <Estudiante> diccionarioEstudiantes, Persona estu, LoginVisual atras ) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstudiante = new JLabel("Estudiante: "+estu.getNombre());
		lblEstudiante.setBounds(31, 31, 238, 20);
		contentPane.add(lblEstudiante);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaEstudiantes.this.setVisible(false);
				atras.setVisible(true);
			}
		});
		btnCerrarSesin.setBounds(277, 199, 136, 29);
		contentPane.add(btnCerrarSesin);
	}

}
