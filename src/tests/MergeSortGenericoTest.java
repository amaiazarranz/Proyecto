package tests;

import org.junit.Before;

import org.junit.After;
import org.junit.Test;

import usuarios.Estudiante;
import utilidades.MergeSortGenerico;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase que nos permite comprobar que el metodo mergesortgenerico esta bien
 * @author Alumno Amaia y Olatz
 *
 */

public class MergeSortGenericoTest {
	
	ArrayList <Estudiante> lista= new ArrayList <>();	
	
	/**
	 * Se inician los estudiantes
	 * @throws Exception exception
	 */
	@Before
	public void setUp() throws Exception
	{
		
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
	 * La clase que nos permite cerrar conexiones si los hubiera
	 * @throws Exception excepcion
	 */
	@After
	public void tearDown () throws Exception{
		
	}
	
	/**
	 * El test del mergesort generico que ordena las notas medias de los estudiantes
	 */
	
	@Test
	public void test() {
		
		List <Estudiante> ordenado=MergeSortGenerico.introducir(lista);
		
		int nota= (int) ordenado.get(0).getNotamedia();
		assertEquals(nota, 10);
		assertFalse(nota==7);
		
		int nota2= (int) ordenado.get(1).getNotamedia();
		assertEquals(nota2, 7);
	}
}
