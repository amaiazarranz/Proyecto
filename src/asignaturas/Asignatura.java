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
     * Este m�todo es el constructor con par�metros de las asignaturas
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
     * Este m�todo es el constructor sin par�metros
     */

    public Asignatura() {
    }
    
    /**
     * Este m�todo devuelve el atributo nombre a otra clase
     * @return nombre 
     */

    public String getNombre() {
        return nombre;
    }
    
    /**
     * Este m�todo da el valor al atributo nombre
     * @param nombre nombre
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Este m�todo devuelve el atributo idioma a otra clase
     * @return idioma 
     */

    public String getIdioma() {
        return idioma;
    }
    
    /**
     * Este m�todo da el valor al atributo idioma
     * @param idioma idioma
     */

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    /**
     * Este m�todo devuelve el atributo c�digo a otra clase
     * @return codigo 
     */

    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Este m�todo da el valor al atributo c�digo
     * @param c�digo c�digo
     */

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * Este m�todo devuelve el atributo docente a otra clase
     * @return docente 
     */

    public String getDocente() {
        return docente;
    }
    
    /**
     * Este m�todo da el valor al atributo docente
     * @param docente docente
     */

    public void setDocente(String docente) {
        this.docente = docente;
    }
    
    /**
	 * Este m�todo sirve para pasar a string
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
