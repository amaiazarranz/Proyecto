package frontend;

import javax.swing.JOptionPane;

/**
 * La clase del hilo para el profesor
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloProfesor extends Thread{
	
	/**
	 * El método en el que el hilo pausa la clase calificar durante 2000 milisegundos y después de eso aparece un mensaje para esperar 2000 milisegundos más antes de ejecutar nada
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
				
				
				JOptionPane.showMessageDialog(null, "Espere unos segundos más por favor");
				
				Thread.sleep(2000);
				
				
			} catch (InterruptedException e) {
				
				throw new IllegalStateException (e);
			}
			
			System.out.println("Exiting thread 2");
		});
		
		thread2.start();

		
		
	}

}
