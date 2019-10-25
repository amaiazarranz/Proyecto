package excepciones;

public class NombreUsuarioRepetido extends Exception {
	
	public NombreUsuarioRepetido(String mensaje) {
		
		super(mensaje);
	}

}
