package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import usuarios.Estudiante;
import utilidades.MergeSort;

/**
 * En esta clase se hacen las pruebas unitarias del MergeSort
 * @author Alumno Amaia y Olatz
 *
 */

public class MergeSortGenericoTest {

	ArrayList<Estudiante> lista =new ArrayList<>();
	
	/**
	 * Se lanza antes de los test
	 * @throws Exception excepcion
	 */
	
	@Before
	public void setUp() throws Exception {
		Estudiante e1 = new Estudiante(
				"Leire", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 10.0, 10, 0
	    		);
		
		lista.add(e1);
		
		Estudiante e2 = new Estudiante(
				"Maialen", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 5.0, 10, 0
	    		);
		
		lista.add(e2);
		
		Estudiante e3 = new Estudiante(
				"Aitor", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 7.7, 10, 0
	    		);
		
		lista.add(e3);
	}
	
	/**
	 * Se lanza despues de los test
	 * @throws Exception excepcion
	 */

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test del MerseSort Generico
	 */
	
	@Test
	public void testOrdenar() {
		MergeSort.mergesort(lista, 0, lista.size()-1);
		
		String nombre1=lista.get(0).getNombre();
		String nombre2=lista.get(1).getNombre();
		String nombre3=lista.get(2).getNombre();
		
		assertEquals("Leire", nombre1);
		assertEquals("Aitor", nombre2);
		assertEquals("Maialen", nombre3);
		assertNotSame("Aitor", nombre3);
	}

}
