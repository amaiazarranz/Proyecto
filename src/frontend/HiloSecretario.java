package frontend;

import javax.swing.JOptionPane;

/**
 * La clase del hilo del secretario
 * @author Alumno Amaia y Olatz
 *
 */

public class HiloSecretario extends Thread{
	
	/**
	 * El m�todo en el que el hilo pausa expulsar durante 1000 milisegundos
	 */

	@Override
	public void run() 
	{
		
		try {
			
			JOptionPane.showMessageDialog(null, "A continuaci�n te aparecer�n la resoluci�n de los profesores");
			 Thread.sleep(1000);
			 
			 int numero = (int)(Math.random()*2);
			 
			 if (numero==0) {
				 
				 JOptionPane.showMessageDialog(null, "Debes expulsar al alumno");
			 }
			 else if (numero==1) {
				 
				 JOptionPane.showMessageDialog(null, "No debes expulsar al alumno");
			 }
			 
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}

}
