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
//    ArrayList<Integer> notasmedias =new ArrayList <>();
    private double notamedia;
    private int numNotas;
    private int faltaleve;
    private int faltagrave;
    private String historia;
    private Icon icono;

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

    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
    		String email, String iban, String tipopersona, double notamedia, int faltaleve, int faltagrave) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.notamedia = notamedia;
        this.faltaleve = faltaleve;
        this.faltagrave = faltagrave;
     
    }

    /**
     * Estudiante con todos los parámetros
     * @param nombre nombre
     * @param apellido1 primer apellido
     * @param apellido2 segundo apellido
     * @param dni dni
     * @param user usuario
     * @param password contraseña
     * @param email correo
     * @param iban iban
     * @param tipopersona estudiante
     * @param notamedia nota media
     * @param faltaleve número de faltas leves
     * @param faltagrave número de faltas graves
     * @@param historia lo que va a escribir en el tablón
     */



    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
                      String email, String iban, String tipopersona, double notamedia, int numnotas, int faltaleve,
                      int faltagrave) {
        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
        this.notamedia = notamedia;
        this.numNotas = numnotas;
        this.faltaleve = faltaleve;
        this.faltagrave= faltagrave;
    }
    
    
    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
            String email, String iban, String tipopersona, double notamedia, int faltaleve, int faltagrave,
            Icon icon) {
    	super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
    	this.notamedia = notamedia;
    	this.faltaleve = faltaleve;
    	this.faltagrave = faltagrave;
    	this.icono=icon;
    	}




public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
			String email, String iban, String tipopersona, ArrayList<String> diccionarioEstudiantes, double notamedia,
			int numNotas, int faltaleve, int faltagrave, String historia, Icon icono) {
		super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
		this.diccionarioEstudiantes = diccionarioEstudiantes;
		this.notamedia = notamedia;
		this.numNotas = numNotas;
		this.faltaleve = faltaleve;
		this.faltagrave = faltagrave;
		this.historia = historia;
		this.icono = icono;
	}

//    public Estudiante(String nombre, String apellido1, String apellido2, String dni, String user, String password,
//                      String email, String iban, String tipopersona, ArrayList<String> diccionarioEstudiantes,
//                      ArrayList<Integer> notasmedias, double notamedia, int faltaleve, int faltagrave) {
//        super(nombre, apellido1, apellido2, dni, user, password, email, iban, tipopersona);
//        this.diccionarioEstudiantes = diccionarioEstudiantes;
//        this.notasmedias = notasmedias;
//        this.notamedia = notamedia;
//        this.faltaleve = faltaleve;
//        this.faltagrave = faltagrave;
//    }

    /**
     * Se trata de un constructor sin parámetros de los estudiantes
     */

    public Estudiante() {
        super();
    }

    /**
     * Este método devuelve el diccionario de estudiantes a otra clase
     * @return diccionario de estudiantes
     */

    public ArrayList<String> getDiccionarioEstudiantes() {
        return diccionarioEstudiantes;
    }

    /**
     * Este método da valores a los elementos del diccionario de estudiantes
     * @param diccionarioEstudiantes diccionarioEstudiantes
     */

    public void setDiccionarioEstudiantes(ArrayList<String> diccionarioEstudiantes) {
        this.diccionarioEstudiantes = diccionarioEstudiantes;
    }

    /**
     * Este método devuelve el atributo nota media a otra clase
     * @return nota media
     */

    public double getNotamedia() {
        return notamedia;
    }

    /**
     * Este método da el valor al atributo nota media
     * @param notamedia notamedia
     */

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    /**
     * Este método devuelve el atributo falta leve a otra clase
     * @return falta leve
     */

    public int getFaltaleve() {
        return faltaleve;
    }

    /**
     * Este método da el valor al atributo faltaleve
     * @param faltaleve faltaleve
     */

    public void setFaltaleve(int faltaleve) {
        this.faltaleve = faltaleve;
    }

    /**
     * Este método devuelve el atributo falta grave a otra clase
     * @return nombre
     */


    public int getFaltagrave() {
        return faltagrave;
    }

    /**
     * Este método da el valor al atributo faltagrave
     * @param faltagrave faltagrave
     */

    public void setFaltagrave(int faltagrave) {
        this.faltagrave = faltagrave;
    }

    /**
     * Este método devuelve las notas del estudiante
     * @return nombre
     */

//    public ArrayList<Integer> getNotasmedias() {
//        return notasmedias;
//    }
//
//
//    /**
//     * Este método da el todas las calificaciones
//     * @param notasmedias
//     */
//
//    public void setNotasmedias(ArrayList<Integer> notasmedias) {
//        this.notasmedias = notasmedias;
//    }
    
    /**
     * Este metodo devuelve las historias
     * @return historia
     */

    public String getHistoria() {
		return historia;
	}
    
    /**
     * Este metodo da las historias
     * @param historia historias
     */

	public void setHistoria(String historia) {
		this.historia = historia;
	}
	
    /**
     * Este metodo devuelve el numero de notas que tiene el estudiante
     * @return numero de notas
     */

    public int getNumNotas() {
		return numNotas;
	}
    
    /**
     * Este metodo da el numero de notas que tiene el estudiante
     * @param numero de notas
     */


	public void setNumNotas(int numNotas) {
		this.numNotas = numNotas;
	}

	/**
     * Este método sirve para pasar a string el contenido de los estudiantes
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
     * Este método sirve para enviar mensajes
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

}