package tests;
import static org.junit.Assert.assertEquals;


//import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sqlite.DBManager;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Trabajador;

/**
 * En esta clase se hacen las comprobaciones del DBManager
 * @author Alumno Amaia y Olatz
 *
 */

public class DBManagerTest {
	
	private DBManager myDBManager;
	
	/**
	 * Se crea la base de datos y el link
	 * @throws Exception excepcion
	 */
	@Before
	public void setUp() throws Exception {
		myDBManager= new DBManager("UniversidadDeusto6.db");
		DBManager.createLink();
		
		
	}
	
	/**
	 * Se cierra el link
	 * @throws Exception excepcion
	 */
	
	@After
	public void tearDown() throws Exception {
		DBManager.closeLink();
	}
	
	/**
	 * Test que queremos que falle porque no se ha creado la tabla
	 * @throws SQLException excepcion de sql
	 */
	
	@Test
	public void testFailure() throws SQLException {
		
		try {
			
			DBManager.insertEstudiante("String dni", "String nombre", "String apellido1", "String apellido2", "String user", "String password", 
		    		"String email", "String iban", "String tipopersona", 10.0, 1, 2, 0);
			
			fail("Tabla no creada"); 
			
		}catch (SQLException e) {
			
		}
		
	}
	
	/**
	 * segundo test de los insert
	 * @throws SQLException excepcion de los sql
	 */
	
	@Test
	public void testInsert2() throws SQLException {
		
		
		DBManager.createNewTableTrabajador();
		
		DBManager.insertTrabajador("Amaia", "Zarranz", "Mendizabal", "73608820M", "amaiazar",
					"amaia", "amaia@gmail.com", "", "profesor", 1000);
		
		
		ArrayList <Trabajador> d=DBManager.selectAllTrabajadoresJunit();
		
		String email=null;
		Trabajador t=null;
		for (Trabajador a: d) {
			System.out.println(a.getEmail());
			email=a.getEmail();
			t=a;
		}
		
		
		assertEquals("amaia@gmail.com", email);
		assertEquals("amaia@gmail.com", t.getEmail());

		
	}

}
