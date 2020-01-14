package tests;

import org.junit.Before;

import org.junit.After;
import org.junit.Test;

import usuarios.Secretario;

import static org.junit.Assert.*;

/**
 * Esta clase nos sirve para cerciorarnos de que el constructor del secretario funciona bien
 * @author Alumno Amaia y Olatz
 *
 */

public class SecretarioTest {
	
	Secretario secre;
	
	/**
	 * Se inicia el secretario
	 * @throws Exception excepcion
	 */
	@Before
	public void setUp () throws Exception{
		
		secre= new Secretario ("String nombre", "String apellido1", "String apellido2", "String dni",
	               "String user", "String password", "String email", "String iban", "String tipopersona", 2000);
		
	}
	
	/**
	 * En este caso no necesitamos 
	 * @throws Exception excepcion
	 */
	
	@After
	public void tearDown() throws Exception{
		
		
	}
	
	/**
	 * El test del constructor del secertario
	 */
	@Test 
	public void test() {
		
		assertEquals (secre.getApellido1(), "String apellido1");
		assertNotSame(secre.getApellido2(), "String apellido1");
		assertTrue(secre.getSalario()==2000);
		
		
	}
	

}
