package usuarios;

import java.util.ArrayList;

/**
 * En esta clase se desarrollan los atributos de los secretarios
 * @author Alumno Amaia y Olatz
 *
 */

public final class Secretario extends Trabajador
{
    ArrayList<String> diccionarioSecretarios= new ArrayList <String>();
    
    /**
     * Constructor con parámetros de secretario
     * @param nombre nombre del secretario
     * @param apellido1 primer apellido del secretario
     * @param apellido2 segundo apellido del secretario
     * @param dni dni del secretario
     * @param user user del secretario
     * @param password pass del secretario
     * @param email correo del secretario
     * @param iban iban del secretario
     * @param tipopersona secretario
     * @param salario salario del secretario
     */

    public Secretario(String nombre, String apellido1, String apellido2, String dni,
                      String user, String password, String email, String iban, String tipopersona,
                      int salario) {
        super(nombre, apellido1, apellido2, dni,  user, password, email, iban, tipopersona, salario);
    }
    
    /**
     * Constructor sin parámetros de secretario
     */
    
    public Secretario(){
        super();
    }
    
    /**
     * Pasar a string las características del secretario
     */

    @Override
    public String toString() {
        return "Secretario{" +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido1='" + this.getApellido1() + '\'' +
                ", apellido2='" + this.getApellido2() + '\'' +
                ", dni='" + this.getDni() + '\'' +
                ", user='" + this.getUser() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", iban='" + this.getIban() + '\'' +
                ", tipopersona='" + this.getTipopersona() + '\'' +
                "salario=" + this.getSalario() +
                '}';
    }
    
    /**
     * Este método sirve para enviar mensajes
     */

}
