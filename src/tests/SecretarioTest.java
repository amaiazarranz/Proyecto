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
	
	@Before
	public void setUp () throws Exception{
		
		secre= new Secretario ("String nombre", "String apellido1", "String apellido2", "String dni",
	               "String user", "String password", "String email", "String iban", "String tipopersona", 2000);
		
	}
	
	@After
	public void tearDown() throws Exception{
		
		
	}
	
	@Test 
	public void test() {
		
		assertEquals (secre.getApellido1(), "String apellido1");
		assertNotSame(secre.getApellido2(), "String apellido1");
		assertTrue(secre.getSalario()==2000);
		
		
	}
	

}
