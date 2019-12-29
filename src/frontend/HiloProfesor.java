package frontend;

/**
 * La clase del hilo para el profesor
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloProfesor extends Thread{
	
	/**
	 * El método en el que el hilo pausa a ventanaprofesor después de 1000 milisegundos
	 */

	@Override
	public void run() 
	{
		VentanaProfesor.CerrarSesion1();
		
		try {
			 Thread.sleep(1000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}

}
