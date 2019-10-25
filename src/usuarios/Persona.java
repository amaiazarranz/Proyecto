package usuarios;

import javax.swing.*;
import interfaces.IMensajes;

public abstract class Persona implements IMensajes
{
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String user;
    private String password;
    private String email;
    private String iban;
    private String tipopersona;
    private ImageIcon fotoperfil;

    public Persona(String nombre, String apellido1, String apellido2, String dni, String user,
                   String password, String email, String iban, String tipopersona) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.user = user;
        this.password = password;
        this.email = email;
        this.iban = iban;
        this.tipopersona=tipopersona;
    }

    public Persona(String nombre, String apellido1, String apellido2, String dni,
                   String user, String password, String email, String iban, String tipopersona,ImageIcon fotoperfil) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.user = user;
        this.password = password;
        this.email = email;
        this.iban = iban;
        this.tipopersona=tipopersona;
        this.fotoperfil = fotoperfil;
    } //no poner imageicon para leer de ficheros

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    public ImageIcon getFotoperfil() {
        return fotoperfil;
    }

    public void setFotoperfil(ImageIcon fotoperfil) {
        this.fotoperfil = fotoperfil;
    }

    @Override
    public void enviarMensajes()
    {

    }
}

