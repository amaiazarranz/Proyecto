package usuarios;

import java.util.ArrayList;



import javax.swing.Icon;
import javax.swing.ImageIcon;

import interfaces.IComparable;
import utilidades.MergeSortGenerico;

/**
 * En esta clase se desarrollan los atributos de los estudiantes
 * @author Alumno Amaia y Olatz
 *
 */


public class Estudiante extends Persona implements IComparable<Estudiante>
{

    ArrayList<String> diccionarioEstudiantes= new ArrayList <String>();
    ArrayList<Integer> notasmedias =new ArrayList <>();
    private double notamedia;
    private int faltaleve;
    private int faltagrave;

    /**
     * Se trata de un constructor con par�metors
     * @param nombre nombre del estudiante
     * @param apellido1 primer apellido del estudiante
     * @param apellido2 segundo apellido del estudiante
     * @param dni dni del estudiante
     * @param user usuario del estudiante
     * @param password contrase�a del estudiante
     * @param email el correo del estudiante
     * @param iban el iban del estudiante
     * @param tipopersona estudiane
     * @param notamedia la nota media del estudiante
     * @param faltaleve el n�mero de faltas leves
     * @param faltagrave el n�mero de faltas graves
     */

    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password, String email, String iban, String tipopersona, double notamedia, int faltaleve, int faltagrave) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.notamedia = notamedia;
        this.faltaleve = faltaleve;
        this.faltagrave = faltagrave;
    }

    /**
     * Estudiante con todos los par�metros
     * @param nombre nombre
     * @param apellido1 primer apellido
     * @param apellido2 segundo apellido
     * @param dni dni
     * @param user usuario
     * @param password contrase�a
     * @param email correo
     * @param iban iban
     * @param tipopersona estudiante
     * @param notamedia nota media
     * @param faltaleve n�mero de faltas leves
     * @param faltagrave n�mero de faltas graves
     * @param fotoperfil foto de perfil
     */



    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
                      String email, String iban, String tipopersona, double notamedia, int faltaleve, int faltagrave,
                      Icon fotoperfil) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona, fotoperfil);
        this.notamedia = notamedia;
        this.faltaleve = faltaleve;
        this.faltagrave = faltagrave;
    }





    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
                      String email, String iban, String tipopersona, ArrayList<String> diccionarioEstudiantes,
                      ArrayList<Integer> notasmedias, double notamedia, int faltaleve, int faltagrave) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.diccionarioEstudiantes = diccionarioEstudiantes;
        this.notasmedias = notasmedias;
        this.notamedia = notamedia;
        this.faltaleve = faltaleve;
        this.faltagrave = faltagrave;
    }

    /**
     * Se trata de un constructor sin par�metros de los estudiantes
     */

    public Estudiante() {
        super();
    }

    /**
     * Este m�todo devuelve el diccionario de estudiantes a otra clase
     * @return diccionario de estudiantes
     */

    public ArrayList<String> getDiccionarioEstudiantes() {
        return diccionarioEstudiantes;
    }

    /**
     * Este m�todo da valores a los elementos del diccionario de estudiantes
     * @param diccionarioEstudiantes diccionarioEstudiantes
     */

    public void setDiccionarioEstudiantes(ArrayList<String> diccionarioEstudiantes) {
        this.diccionarioEstudiantes = diccionarioEstudiantes;
    }

    /**
     * Este m�todo devuelve el atributo nota media a otra clase
     * @return nota media
     */

    public double getNotamedia() {
        return notamedia;
    }

    /**
     * Este m�todo da el valor al atributo nota media
     * @param notamedia notamedia
     */

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    /**
     * Este m�todo devuelve el atributo falta leve a otra clase
     * @return falta leve
     */

    public int getFaltaleve() {
        return faltaleve;
    }

    /**
     * Este m�todo da el valor al atributo faltaleve
     * @param faltaleve faltaleve
     */

    public void setFaltaleve(int faltaleve) {
        this.faltaleve = faltaleve;
    }

    /**
     * Este m�todo devuelve el atributo falta grave a otra clase
     * @return nombre
     */


    public int getFaltagrave() {
        return faltagrave;
    }

    /**
     * Este m�todo da el valor al atributo faltagrave
     * @param faltagrave faltagrave
     */

    public void setFaltagrave(int faltagrave) {
        this.faltagrave = faltagrave;
    }

    /**
     * Este m�todo devuelve las notas del estudiante
     * @return nombre
     */

    public ArrayList<Integer> getNotasmedias() {
        return notasmedias;
    }


    /**
     * Este m�todo da el todas las calificaciones
     * @param notasmedias
     */

    public void setNotasmedias(ArrayList<Integer> notasmedias) {
        this.notasmedias = notasmedias;
    }



    /**
     * Este m�todo sirve para pasar a string el contenido de los estudiantes
     */


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

    /**
     * Este m�todo sirve para enviar mensajes
     */

    @Override
    /**
     * @return true si e1.notamedia < e2.notamedia
     */
    public boolean ordenar(Estudiante e2)
    {
        return this.notamedia < e2.notamedia;
    }


    public static void main(String[] args)
    {
        Estudiante e1 = new Estudiante();
        Estudiante e2 = new Estudiante();

        e1.setNotamedia(10);
        e2.setNotamedia(5);

        System.out.println(e1.ordenar(e2));


    }
//     public void ordenar(Estudiante e2) {
// // TODO Auto-generated method stub
//
// ArrayList <Estudiante> diccionarioEstudiante=SelectData.selectAllEstudiantes();
//
// new MergeSortGenerico(false).mergesort(diccionarioEstudiante);
//
// for (Estudiante a: diccionarioEstudiante) {
//
// if (a.getNotamedia()>=e2.getNotamedia()) {
//
// System.out.println(this.getNotamedia());
// System.out.println(e2.getNotamedia());
//
// System.out.println("a");
// }
//
//
// }
//
// }
}