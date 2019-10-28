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
    private double salario;

    ArrayList<String> diccionarioTrabajdores= new ArrayList <String>();

    public Trabajador(String nombre, String apellido1, String apellido2, String dni, String user, String password, String email, String iban, String tipopersona, double salario) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.salario = salario;
    }

    public Trabajador (){
        super();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

