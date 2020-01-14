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
	 * Se calcula la nota media de cada estudiante
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
