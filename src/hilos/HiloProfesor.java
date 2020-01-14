package hilos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import sqlite.DBManager;
import usuarios.Estudiante;

/**
 * La clase del hilo para el profesor
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloProfesor extends Thread{
	
	ArrayList <Estudiante> diccionario= new ArrayList <>();
	
	public HiloProfesor(ArrayList<Estudiante> diccionarioTrabajador) {
		
		diccionario=diccionarioTrabajador;
	}

	/**
	 * El método en el que el hilo pausa la clase calificar durante 2000 milisegundos y después de eso aparece un mensaje para esperar 2000 milisegundos más antes de ejecutar nada
	 */
	
	

	@Override
	public void run() 
	{
		
		try {
			
			 JOptionPane.showMessageDialog(null, "A continuación se está calculando la nota media de cada estudiante por ahora");
			 Thread.sleep(2000);
			 
			 ArrayList <Estudiante> diccio= DBManager.selectAllEstudiantes();
			 
			 for (Estudiante a: diccio) {
				 
				 System.out.println(a.getNombre()+ " " +a.getNotamedia());
			 }
			  
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
		
	}

}
