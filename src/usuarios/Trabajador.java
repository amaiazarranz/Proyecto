package usuarios;

import usuarios.Persona;

import javax.swing.*;
import java.util.ArrayList;

/**
 * En esta clase se desarrollan los atributos de los trabajadores
 * @author Alumno Amaia y Olatz
 *
 */

public class Trabajador extends Persona
{
    private int salario;

    ArrayList<String> diccionarioTrabajdores= new ArrayList <String>();
    
    /**
     * Constructor con par�metros de trabajador
     * @param nombre nombre del trabajador
     * @param apellido1 primer apellido del trabajador
     * @param apellido2 segundo apellido del trabajador
     * @param dni dni del trabajador
     * @param user user del trabajador
     * @param password pass del trabajador
     * @param email correo del trabajador
     * @param iban iban del trabajador
     * @param tipopersona trabajador
     * @param salario salario del trabajador
     */

    public Trabajador(String nombre, String apellido1, String apellido2, String dni, String user, String password, String email, String iban, String tipopersona, int salario) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.salario = salario;
    }
    
    /**
     * Constructor sin par�metros de trabajador
     */

    public Trabajador (){
        super();
    }
    
    /**
     * Este m�todo devuelve el atributo salario a otra clase
     * @return salario 
     */

    public double getSalario() {
        return salario;
    }
    
    /**
     * Este m�todo da el valor al atributo salario
     * @param salario salario
     */

    public void setSalario(int salario) {
        this.salario = salario;
    }
}

