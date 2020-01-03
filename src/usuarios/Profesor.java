package usuarios;

import javax.swing.*;
import java.util.ArrayList;

/**
 * En esta clase se desarrollan los atributos de los profesores
 * @author Alumno Olatz y Amaia
 *
 */

public final class Profesor extends Trabajador
{
    ArrayList <String> asignaturas= new ArrayList<String>();
    
    /**
     * constructor con parámetros de profesor
     * @param nombre nombre del profesor
     * @param apellido1 primer apellido del profesor
     * @param apellido2 segundo apellido del profesor
     * @param dni dni del profesor
     * @param user user del profesor
     * @param password pass del profesor
     * @param email correo del profesor
     * @param iban iban del profesor
     * @param tipopersona profesor
     * @param salario el salario del profesor
     */

    public Profesor(String nombre, String apellido1, String apellido2, String dni,
                    String user, String password, String email, String iban, String tipopersona,
                    double salario) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona, salario);
    }
    
    /**
     * Constructor sin parámetros de profesor
     */

    public Profesor (){
        super();
    }
    
    /**
     * Pasar a string todos los atributos de los profesores
     */

    @Override
    public String toString() {
        return "Profesor{" +
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
