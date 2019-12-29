package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Esta clase nos permite realizar varios test en paralelo
 * @author Alumno Amaia y Olatz
 *
 */
@RunWith(value = Parameterized.class)
public class SecretarioTestParametrizado {
	
	/**
	 * Creamos el parametrizado
	 * @return lista de las pruebas que se han realizado
	 */
	
	@Parameterized.Parameters
	public static List<Object[]> pruebas()
	{
		List<Object[]> o= new ArrayList<>();
		 
	    o.add(new Object[] {"String nombre", "String apellido1", "String apellido2", "String dni",
	            "String user", "String password", "String email", "String iban", "String tipopersona",
	            3000.0});
	    
	    o.add(new Object[] {"String nombre", "String 1apellido1", "String 1apellido2", "String 1dni",
	            "String 1user", "String 1password", "String 1email", "String 1iban", "String 1tipopersona",
	            3500.0});
	    
	    o.add(new Object[] {"String nombre", "String 2apellido1", "String 2apellido2", "String 2dni",
	            "String 2user", "String 2password", "String 2email", "String 2iban", "String 2tipopersona",
	            3600.0});
	    
	    return o;
	}
	
	private String nombre; 
	private String apellido1;
	private String apellido2;
	private String dni;
	private String user;
	private String password;
	private String email;
	private String iban;
	private String tipopersona;
	private double salario;
	
	/**
	 * El constructor de secretariotestparametrizado
	 * @param nombre nombre
	 * @param apellido1 primer apellido
	 * @param apellido2 segundo apellido
	 * @param dni dni
	 * @param user usuario
	 * @param password contrasena
	 * @param email correo
	 * @param iban iban
	 * @param tipopersona en este caso secretario
	 * @param salario salario del secretario
	 */
	
	
	public SecretarioTestParametrizado (String nombre, String apellido1, String apellido2, String dni, String user, String password,
			String email, String iban, String tipopersona, double salario)
	{
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.dni=dni;
		this.user=user;
		this.password=password;
		this.email=email;
		this.iban=iban;
		this.tipopersona=tipopersona;
		this.salario=salario;
	}
	
	/**
	 * El test realizado
	 */
	
	
	@Test
	public void test(){
		
		assertEquals(nombre,"String nombre");
		
	}
	    
	    
}
