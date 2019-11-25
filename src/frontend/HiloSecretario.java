package frontend;

public class HiloSecretario extends Thread{
	
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
