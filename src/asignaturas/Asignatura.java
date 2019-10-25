package asignaturas;

public class Asignatura
{
    private String nombre;
    private String idioma;
    private int codigo;
    private String docente;

    public Asignatura(String nombre, String idioma, int codigo, String docente) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.codigo = codigo;
        this.docente = docente;
    }

    public Asignatura() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

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
