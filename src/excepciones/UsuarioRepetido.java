package excepciones;

/**
 * Esta clase sirve para gestionar la excepci�n UsuarioRepetido
 * @author Alumno Amaia y Olatz
 *
 */

public class UsuarioRepetido extends Exception {
	
	/**
	 * Este m�todo extiende de exception para poder mostrar posteriormente el mensaje de de error
	 * @param mensaje el mensaje que se va a mostrar
	 */	
	
	public UsuarioRepetido(String mensaje) {
		
		
		
		super(mensaje);
	}

}
