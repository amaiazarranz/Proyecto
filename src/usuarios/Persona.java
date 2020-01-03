package usuarios;

import javax.swing.*;
/**
 * En esta clase se desarrollan los atributos de las personas
 * @author Alumno Amaia y Olatz
 *
 */

public abstract class Persona
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
    private Icon fotoperfil;

    /**
     * Constructor con parámetros
     * @param nombre nombre de la persona
     * @param apellido1 primer apellido de la persona
     * @param apellido2 segundo apellido de la persona
     * @param dni dni de la persona
     * @param user user de la persona
     * @param password password de la persona
     * @param email correo gmail de la persona
     * @param iban iban de la persona
     * @param tipopersona el tipo de persona que es dentro de la universidad
     */

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

    /**
     * Constructor con parámetros
     * @param nombre nombre de la persona
     * @param apellido1 primer apellido de la persona
     * @param apellido2 segundo apellido de la persona
     * @param dni dni de la persona
     * @param user user de la persona
     * @param password password de la persona
     * @param email correo gmail de la persona
     * @param iban iban de la persona
     * @param tipopersona el tipo de persona que es dentro de la universidad
     * @param fotoperfil es la foto de perfil de la persona
     */

    public Persona(String nombre, String apellido1, String apellido2, String dni,
                   String user, String password, String email, String iban, String tipopersona,Icon fotoperfil) {
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
    } //no poner Icon para leer de ficheros

    /**
     * Constructor sin parámetros de la persona
     */

    public Persona() {
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
     * Este método devuelve el atributo primer apellido a otra clase
     * @return apellido1
     */

    public String getApellido1() {
        return apellido1;
    }

    /**
     * Este método da el valor al atributo primer apellido
     * @param apellido1 primer apellido
     */


    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Este método devuelve el atributo segundo apellido a otra clase
     * @return apellido2
     */

    public String getApellido2() {
        return apellido2;
    }

    /**
     * Este método da el valor al atributo segundo apellido
     * @param apellido2 segundo apellido
     */


    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Este método devuelve el atributo dni a otra clase
     * @return dni
     */

    public String getDni() {
        return dni;
    }

    /**
     * Este método da el valor al atributo dni
     * @param dni dni
     */


    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Este método devuelve el atributo user a otra clase
     * @return user
     */

    public String getUser() {
        return user;
    }

    /**
     * Este método da el valor al atributo user
     * @param user usuario
     */


    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Este método devuelve el atributo contraseña a otra clase
     * @return password
     */

    public String getPassword() {
        return password;
    }

    /**
     * Este método da el valor al atributo contraseña
     * @param password contraseña
     */


    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Este método devuelve el atributo email a otra clase
     * @return correo
     */

    public String getEmail() {
        return email;
    }

    /**
     * Este método da el valor al atributo email
     * @param email email
     */


    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Este método devuelve el atributo iban a otra clase
     * @return iban
     */

    public String getIban() {
        return iban;
    }

    /**
     * Este método da el valor al atributo iban
     * @param iban iban
     */


    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * Este método devuelve el atributo tipopersona a otra clase
     * @return tipopersona
     */

    public String getTipopersona() {
        return tipopersona;
    }

    /**
     * Este método da el valor al atributo tipopersona
     * @param tipopersona el tipo de persona dentro de la universidad
     */


    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    /**
     * Este método devuelve el atributo foto de perfil a otra clase
     * @return fotoperfil
     */

    public Icon getFotoperfil() {
        return fotoperfil;
    }

    /**
     * Este método da el valor al atributo fotoperfil
     * @param fotoperfil foto de perfil
     */


    public void setFotoperfil(Icon fotoperfil) {
        this.fotoperfil = fotoperfil;
    }


}
