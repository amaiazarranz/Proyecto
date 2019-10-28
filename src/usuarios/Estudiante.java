package usuarios;

import java.util.ArrayList;

/**
 * En esta clase se desarrollan los atributos de los estudiantes
 * @author Alumno Amaia y Olatz
 *
 */


public class Estudiante extends Persona
{

    ArrayList<String> diccionarioEstudiantes= new ArrayList <String>();

    private double notamedia;
    private int faltaleve;
    private int faltagrave;
    
    /**
     * Se trata de un constructor con parámetors
     * @param nombre nombre del estudiante
     * @param apellido1 primer apellido del estudiante
     * @param apellido2 segundo apellido del estudiante
     * @param dni dni del estudiante
     * @param user usuario del estudiante
     * @param password contraseña del estudiante
     * @param email el correo del estudiante
     * @param iban el iban del estudiante
     * @param tipopersona estudiane
     * @param notamedia la nota media del estudiante
     * @param faltaleve el número de faltas leves
     * @param faltagrave el número de faltas graves
     */

    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password, String email, String iban, String tipopersona, double notamedia, int faltaleve, int faltagrave) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.notamedia = notamedia;
        this.faltaleve = faltaleve;
        this.faltagrave = faltagrave;
    }
    
    /**
     * Se trata de un constructor sin parámetros de los estudiantes
     */

    public Estudiante() {
        super();
    }

    public ArrayList<String> getDiccionarioEstudiantes() {
        return diccionarioEstudiantes;
    }

    public void setDiccionarioEstudiantes(ArrayList<String> diccionarioEstudiantes) {
        this.diccionarioEstudiantes = diccionarioEstudiantes;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    public int getFaltaleve() {
        return faltaleve;
    }

    public void setFaltaleve(int faltaleve) {
        this.faltaleve = faltaleve;
    }

    public int getFaltagrave() {
        return faltagrave;
    }

    public void setFaltagrave(int faltagrave) {
        this.faltagrave = faltagrave;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "notamedia=" + notamedia +
                ", faltaleve=" + faltaleve +
                ", faltagrave=" + faltagrave +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido1='" + this.getApellido1() + '\'' +
                ", apellido2='" + this.getApellido2() + '\'' +
                ", dni='" + this.getDni() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                '}';
    }
}

