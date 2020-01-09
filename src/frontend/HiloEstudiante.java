package frontend;

/**
 * La clase del hilo del estudiante
 * @author Alumno Amaia y Olatz
 *
 */
public class HiloEstudiante extends Thread{
	
	/**
	 * El método en el que el hilo pausa a la clase tablon durante 3000 milisegundos
	 */
	
	@Override
	public void run() 
	{
		
		try {
			 Thread.sleep(3000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}

}
