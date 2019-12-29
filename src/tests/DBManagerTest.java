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
	
		DBManager.insertEstudiante("String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 20.0, 10, 0);
		
		fail("Tabla no creada");
	}
	
	/**
	 * test de los insert
	 * @throws SQLException excepcion de los sql
	 */
		
	@Test
	public void testInsert() throws SQLException {
		
		DBManager.createNewTableEstudiante();
		DBManager.createNewTableTrabajador();
		
//		Estudiante e1 = new Estudiante(
//				"String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
//	    		"String email", "String iban", "String tipopersona", 20.0, 10, 0
//	    		);
//		
//		Profesor p1 = new Profesor(
//				"String nom", "String apellido1", "String apellido2", "String dni",
//               "String user", "String password", "String email", "String iban", "String tipopersona",
//                3000.0
//	    		);
		
		DBManager.insertTrabajador("String nom", "String apellido1", "String apellido2", "String dni",
					"String user", "String password", "String email", "String iban", "profesor",
			            3000.0);

	
		DBManager.insertEstudiante("String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
					"String email", "String iban", "String tipopersona", 20.0, 10, 0);
	
	
		
		String nombre= null;
		String dni= null;
		Estudiante b = null;
		ArrayList <Estudiante> diccionarioEstudiantes=DBManager.selectAllEstudiantes();
		for (Estudiante e: diccionarioEstudiantes) {
			if (e.getDni().equals("String dni")){
				nombre=e.getNombre();
				dni=e.getDni();
				b=e;
				break;
			}
		}
		for (Estudiante a: diccionarioEstudiantes) {
			
			if (a.getDni().equals("String dni")) {
				nombre=a.getNombre();
				dni=a.getDni();
				b=a;
				break;
			}
		
		}
			
		assertEquals("String nombre", nombre);	
		//assertNotEquals("", nombre);
		assertEquals("String dni", dni);	
		//assertNotEquals("", dni);
		
		
		String nombr= null;
		String ap2=null;
		Trabajador c = null;
		ArrayList<Trabajador> diccionarioProfesores=DBManager.selectAllTrabajadores();
		for (Trabajador p: diccionarioProfesores) {
			if (p.getDni().equals("String dni")){
				nombr=p.getNombre();
				ap2=p.getApellido2();
				assertNull(p.getApellido2());
				c=p;
				break;
				
			}
			
		}
		
		assertNull(ap2);
		assertEquals("String nom", nombr);
		//assertNotEquals("", nombr);
		
		
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
		
		
		ArrayList <Trabajador> d=DBManager.selectAllTrabajadores();
		
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
