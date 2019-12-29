package frontend;

/**
 * La clase del hilo del secretario
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloSecretario extends Thread{
	
	/**
	 * El método en el que el hilo pausa a ventanasecretario después de 1000 milisegundos
	 */

	@Override
	public void run() 
	{
		VentanaSecretario.CerrarSesion1();
		
		try {
			 Thread.sleep(1000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}

}
