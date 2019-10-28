package excepciones;

public class UsuarioRepetido extends Exception {
	
	public UsuarioRepetido(String mensaje) {
		
		super(mensaje);
	}

}
