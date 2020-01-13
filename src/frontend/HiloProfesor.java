package frontend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	 * El m�todo en el que el hilo pausa la clase calificar durante 2000 milisegundos y despu�s de eso aparece un mensaje para esperar 2000 milisegundos m�s antes de ejecutar nada
	 */
	
	

	@Override
	public void run() 
	{
		
		try {
			
			 JOptionPane.showMessageDialog(null, "A continuaci�n se est� calculando la nota media de cada estudiante por ahora");
			 Thread.sleep(2000);
			 
			 for (Estudiante a: diccionario) {
				 
				 System.out.println(a.getNombre()+ " Nota: "+ a.getNotamedia());
				 
				 
			 }
			  
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
		
	}

}
