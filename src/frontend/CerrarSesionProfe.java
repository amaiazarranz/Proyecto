package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase sirve para cerrar sesión en el caso de los profesores
 * @author Alumno Amaia y Olatz
 *
 */

public class CerrarSesionProfe implements ActionListener {
	
	Automatriculacion auto=null;
	Principio atras=null;
	
	/**
	 * Es el constructor de la cerrarSesionProfe
	 * @param automatriculacion la clase en la que se encuentra el profesor
	 * @param atras la clase a la que queremos retroceder
	 */
	

	public CerrarSesionProfe (Automatriculacion automatriculacion, Principio atras) {
		
		this.auto=automatriculacion;
		this.atras=atras;
		
	}
	
	/**
	 * La acción que nos sirve volver a la clase anterior
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.auto.setVisible(false);
		this.atras.setVisible(true);
		
	}

}
