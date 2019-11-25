package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CerrarSesionProfe implements ActionListener {
	
	Automatriculacion auto=null;
	Principio atras=null;
	

	public CerrarSesionProfe (Automatriculacion automatriculacion, Principio atras) {
		
		this.auto=automatriculacion;
		this.atras=atras;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.auto.setVisible(false);
		this.atras.setVisible(true);
		
	}

}
