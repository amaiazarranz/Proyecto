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

    public void calificar(){

    }

    public Profesor(String nombre, String apellido1, String apellido2, String dni,
                    String user, String password, String email, String iban, String tipopersona,
                    double salario) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona, salario);
    }

    public Profesor (){
        super();
    }

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
}
