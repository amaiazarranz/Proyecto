package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import usuarios.Estudiante;

public class EstudianteTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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
