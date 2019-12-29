package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usuarios.Profesor;

/**
 * En esta clase se hacen las comprobaciones del Profesor
 * @author Alumno Amaia y Olatz
 *
 */

public class ProfesorTest {
	
	/**
	 * Se lanza antes de los test
	 * @throws Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Se lanza despues de los test
	 * @throws Exception excepcion
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * test de los profesores
	 */

	@Test
	public void test() {
		
		Profesor p1 = new Profesor(
			   "String nombre", "String apellido1", "String apellido2", "String dni",
               "String user", "String password", "String email", "String iban", "String tipopersona",
                3000.0
	    		);
		
		Profesor p2 = new Profesor();
	
		assertEquals(p2.getIban(), null);
		
		p2.setIban("String iban");
		
		assertEquals(p1.getIban(), p2.getIban());
		
		assertEquals(p1.getIban(), "String iban");
		
	}

}
