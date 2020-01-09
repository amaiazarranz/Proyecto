package frontend;

/**
 * La clase del hilo para el profesor
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloProfesor extends Thread{
	
	/**
	 * El método en el que el hilo pausa la clase calificar durante 2000 milisegundos
	 */

	@Override
	public void run() 
	{
		
		try {
			 Thread.sleep(2000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}

}
