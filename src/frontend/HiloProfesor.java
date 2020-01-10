package frontend;

import javax.swing.JOptionPane;

/**
 * La clase del hilo para el profesor
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloProfesor extends Thread{
	
	/**
	 * El m�todo en el que el hilo pausa la clase calificar durante 2000 milisegundos y despu�s de eso aparece un mensaje para esperar 2000 milisegundos m�s antes de ejecutar nada
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
		
		//Thread thread= new Thread()->
		
		Thread thread2= new Thread(() -> {
			
			System.out.println("Entered thread 2");
			
			try {
				
				
				JOptionPane.showMessageDialog(null, "Espere unos segundos m�s por favor");
				
				Thread.sleep(2000);
				
				
			} catch (InterruptedException e) {
				
				throw new IllegalStateException (e);
			}
			
			System.out.println("Exiting thread 2");
		});
		
		thread2.start();

		
		
	}

}
