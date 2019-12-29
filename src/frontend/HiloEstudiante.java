package frontend;

/**
 * La clase del hilo del estudiante
 * @author Alumno Amaia y Olatz
 *
 */
public class HiloEstudiante extends Thread{
	
	/**
	 * El m�todo en el que el hilo pausa a ventanaestudiantes despu�s de 1000 milisegundos
	 */
	
	@Override
	public void run() 
	{
		
		VentanaEstudiantes.CerrarSesion1();
		
		try {
			 Thread.sleep(1000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}

}
