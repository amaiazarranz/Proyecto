package frontend;

public class HiloEstudiante extends Thread{
	
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
