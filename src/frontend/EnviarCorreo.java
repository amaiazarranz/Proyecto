package frontend;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import usuarios.Persona;

public class EnviarCorreo extends JFrame {

	private JPanel contentPane;
	
	CustomTextField destinatario;
	CustomTextField asunto;
	CustomTextField cuerpo;
	JButton boton1;
	JLabel imagen;
	private File outputfile;

	/**
	 * Create the frame.
	 */
	
	public EnviarCorreo(Persona u) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		destinatario = new CustomTextField (0);
		destinatario.setPlaceholder("DESTINATARIO");
		destinatario.setBounds(58, 43, 300, 30);
		contentPane.add(destinatario);
		
		asunto = new CustomTextField (0);
		asunto.setPlaceholder("ASUNTO");
		asunto.setBounds(58, 78, 300, 30);
		contentPane.add(asunto);
		
		cuerpo = new CustomTextField(5);
		cuerpo.setPlaceholder("CUERPO");
		cuerpo.setBounds(58, 112, 300, 93);
		contentPane.add(cuerpo);
				
		boton1 = new JButton("Enviar");
		boton1.setBounds(123, 209, 300, 30);
		contentPane.add(boton1);
		
	
		EnviarCorreo.this.setVisible(true);
		
		boton1.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				
				if(destinatario.getText().toUpperCase().equals("destinatario") || cuerpo.getText().toUpperCase().equals("cuerpo"))
				{
					JOptionPane.showMessageDialog(null, "Uno de los campos est� vaci�, rell�nalo");
				}
				else
				{
					
					String d = destinatario.getText();
					String a = asunto.getText();
					String c = cuerpo.getText();
					
					String user = null;
					user = u.getEmail();
					System.out.println(user);
					
					String contra = null;
					contra = u.getPassword();
					System.out.println(contra);
					
					if (Enviar.enviarConGmail(user, contra, d, a, c) == true)
					{
						JOptionPane.showMessageDialog(null, "Enviado");
						int opcion = JOptionPane.showConfirmDialog(contentPane, "�Quieres volver al principio?");
						if(opcion == 0)
						{
							Principio f = new Principio();
							EnviarCorreo.this.dispose();
						}
						else
						{
							System.exit(0);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No se ha podido enviar");
					
					}
					
					
					
					
				}
			}	
		});	
	}

}
