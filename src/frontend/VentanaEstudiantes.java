package frontend;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Estudiante;
import usuarios.Persona;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Esta es la ventana que se les muestra a los estudiantes
 * @author Alumno Amaia y Olatz
 *
 */


public class VentanaEstudiantes extends JFrame {

	private JPanel contentPane;
	public static String path;
	private Icon icono;
	
	/**
	 * Aquí se muestra la ventana visual de los estudiantes
	 * @param diccionarioEstudiantes la lista de los estudiantes
	 * @param estu la persona que accede
	 * @param atras la ventana LoginVisual
	 */

	public VentanaEstudiantes(ArrayList <Estudiante> diccionarioEstudiantes, Persona estu, LoginVisual atras) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstudiante = new JLabel("Estudiante: "+estu.getNombre());
		lblEstudiante.setBounds(36, 16, 238, 20);
		contentPane.add(lblEstudiante);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para cerrar sesión
			 */
			
			public void actionPerformed(ActionEvent e) {
				
				VentanaEstudiantes.this.setVisible(false);
				atras.setVisible(true);
				CerrarSesion1();
				
			}
		});
		btnCerrarSesin.setBounds(277, 199, 136, 29);
		contentPane.add(btnCerrarSesin);
		
		JButton btnEnviarCorreo = new JButton("Enviar Correo");
		btnEnviarCorreo.addActionListener(new ActionListener() {
			
			/**
			 * Sirve para entrar en la ventana de enviar correo
			 */
			
			public void actionPerformed(ActionEvent arg0) {
				
					EnviarCorreo ventana = new EnviarCorreo (estu);
					ventana.setVisible(true);
				
				VentanaEstudiantes.this.setVisible(false);
			}
		});
		btnEnviarCorreo.setBounds(277, 73, 115, 29);
		contentPane.add(btnEnviarCorreo);
		
		JButton btnVerRanking = new JButton("Ver Ranking");
		btnVerRanking.addActionListener(new ActionListener() {
			
			/**
			 * Acción para ver el ranking
			 */
			public void actionPerformed(ActionEvent arg0) {
				Ranking ventana = new Ranking (diccionarioEstudiantes, estu, VentanaEstudiantes.this);
				ventana.setVisible(true);
				VentanaEstudiantes.this.setVisible(false);
				
			}
		});
		btnVerRanking.setBounds(277, 118, 115, 29);
		contentPane.add(btnVerRanking);
		
		JLabel lblFoto = new JLabel(estu.getFotoperfil());
		lblFoto.setBounds(37, 35, 184, 149);
		contentPane.add(lblFoto);
		
		JButton btnVerTabln = new JButton("Ver tabl\u00F3n");
		btnVerTabln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Tablon ventana = new Tablon (estu, VentanaEstudiantes.this);
				ventana.setVisible(true);
				VentanaEstudiantes.this.setVisible(false);
				
				HiloEstudiante hilo= new HiloEstudiante();
				hilo.run();
				
			}
		});
		btnVerTabln.setBounds(277, 154, 115, 29);
		contentPane.add(btnVerTabln);
	}
	
	/**
	 * Método en el que se enseña el mensaje de que se ha cerrado sesión
	 */
	
	public void CerrarSesion1() {
		
		JOptionPane.showMessageDialog(null, "Has cerrado sesión");
		
	}

}
