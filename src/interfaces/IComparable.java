package interfaces;

import usuarios.Persona;

public interface IComparable <T extends Persona>
{
    public abstract boolean ordenar(T t);
}