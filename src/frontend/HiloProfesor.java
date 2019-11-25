package frontend;


public class HiloProfesor extends Thread{
	
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
