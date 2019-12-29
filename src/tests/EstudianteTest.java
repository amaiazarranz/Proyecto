package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import usuarios.Estudiante;

/**
 * En esta clase se hacen las comprobaciones del Estudiante
 * @author Alumno Amaia y Olatz
 *
 */

public class EstudianteTest {
	
	/**
	 * Se lanza antes de los test
	 * @throws Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Se lanza después de los test
	 * @throws Exception excepcion
	 */
	
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test de los constructores
	 */
	@Test
	public void testConstructor() 
	{
		Estudiante p1 = new Estudiante(
				"String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 20.0, 10, 0
	    		);
		
		Estudiante p2 = new Estudiante();
		
		p2.setNombre("String nombre");
		assertEquals(p1.getNombre(), p2.getNombre());
		
		assertEquals(p1.getNombre(), "String nombre");
		
		
	}

}
