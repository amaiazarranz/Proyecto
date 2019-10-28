package excepciones;

/**
 * Esta clase sirve para gestionar la excepci�n UsuarioNoExiste
 * @author Alumno Amaia y Olatz
 *
 */

public class UsuariosNoExiste extends Exception {
	
	/**
	 * Este m�todo extiende de exception para poder mostrar posteriormente el mensaje de de error
	 * @param mensaje el mensaje que se va a mostrar
	 */
	
	
	public UsuariosNoExiste(String mensaje) {
		super(mensaje);
	}

}
