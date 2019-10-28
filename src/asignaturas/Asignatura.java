package asignaturas;


/**
 * En esta clase se desarrollan los atributos de las asignaturas
 * @author Alumno Amaia y Olatz
 *
 */

public class Asignatura
{
    private String nombre;
    private String idioma;
    private int codigo;
    private String docente;
    
    /**
     * Este método es el constructor con parámetros de las asignaturas
     * @param nombre nombre de la asignatura
     * @param idioma idioma en el que se imparte la asignatura
     * @param codigo codigo de la asignatura
     * @param docente docente que la imparte
     */

    public Asignatura(String nombre, String idioma, int codigo, String docente) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.codigo = codigo;
        this.docente = docente;
    }
    
    /**
     * Este método es el constructor sin parámetros
     */

    public Asignatura() {
    }
    
    /**
     * Este método devuelve el atributo nombre a otra clase
     * @return nombre 
     */

    public String getNombre() {
        return nombre;
    }
    
    /**
     * Este método da el valor al atributo nombre
     * @param nombre nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Este método devuelve el atributo idioma a otra clase
     * @return idioma 
     */

    public String getIdioma() {
        return idioma;
    }
    
    /**
     * Este método da el valor al atributo idioma
     * @param idioma idioma
     */

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    /**
     * Este método devuelve el atributo código a otra clase
     * @return codigo 
     */

    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Este método da el valor al atributo código
     * @param código código
     */

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Este método devuelve el atributo docente a otra clase
     * @return docente 
     */

    public String getDocente() {
        return docente;
    }
    
    /**
     * Este método da el valor al atributo docente
     * @param docente docente
     */

    public void setDocente(String docente) {
        this.docente = docente;
    }
    
    /**
	 * Este método sirve para pasar a string
	 */

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", idioma='" + idioma + '\'' +
                ", codigo=" + codigo +
                ", docente='" + docente + '\'' +
                '}';
    }
}
