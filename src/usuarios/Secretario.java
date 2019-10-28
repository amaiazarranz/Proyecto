package usuarios;

import utilidades.LecturaEscrituraFichero;
import utilidades.Utilidades;
import java.util.ArrayList;

/**
 * En esta clase se desarrollan los atributos de los secretarios
 * @author Alumno Amaia y Olatz
 *
 */

public final class Secretario extends Trabajador
{
    ArrayList<String> diccionarioSecretarios= new ArrayList <String>();

    public Secretario(String nombre, String apellido1, String apellido2, String dni,
                      String user, String password, String email, String iban, String tipopersona,
                      double salario) {
        super(nombre, apellido1, apellido2, dni,  user, password, email, iban, tipopersona, salario);
    }

    public Secretario(){
        super();
    }

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

}
