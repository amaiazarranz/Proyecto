package interfaces;

import usuarios.Persona;

/**
 * La interfaz icomparable para el empleo de los genericos
 * @author Alumno Amaia y Olatz
 *
 * @param <T> el parámetro generico T
 */

public interface IComparable <T extends Persona>
{
    public abstract boolean ordenar(T t);
}