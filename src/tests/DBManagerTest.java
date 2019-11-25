package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sqlite.DBManager;
import sqlite.SelectData;
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

	@Before
	public void setUp() throws Exception {
		myDBManager= new DBManager("UniversidadDeusto.db");
		myDBManager.createLink();
		
		
	}

	@After
	public void tearDown() throws Exception {
		myDBManager.closeLink();
	}

	@Test
	public void testFailure() throws SQLException {
	
		myDBManager.insertEstudiante("String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 20.0, 10, 0);
		
		fail("Tabla no creada");
	}
		
	@Test
	public void testInsert() throws SQLException {
		
		myDBManager.createNewTableEstudiante();
		myDBManager.createNewTableTrabajador();
		
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
		
		myDBManager.insertTrabajador("String nom", "String apellido1", "String apellido2", "String dni",
					"String user", "String password", "String email", "String iban", "profesor",
			            3000.0);

	
		myDBManager.insertEstudiante("String nombre", "String apellido1", null, "String dni", "String user", "String password", 
					"String email", "String iban", "String tipopersona", 20.0, 10, 0);
	
	
		
		String nombre= null;
		String dni= null;
		Estudiante b = null;
		ArrayList <Estudiante> diccionarioEstudiantes=SelectData.selectAllEstudiantes();
//		for (Estudiante a: diccionarioEstudiantes) {
//			if (e1.getDni().equals("String dni")){
//				nombre=e1.getNombre();
//				dni=e1.getDni();
//				b=a;
//				break;
//			}
		for (Estudiante a: diccionarioEstudiantes) {
			
			if (a.getDni().equals("String dni")) {
				nombre=a.getNombre();
				dni=a.getDni();
				b=a;
				break;
			}
		
		}
			
		assertEquals("String nombre", nombre);	
		
		assertEquals("String dni", dni);	
		
		
		String nombr= null;
		String ap2=null;
		Trabajador c = null;
		ArrayList<Trabajador> diccionarioProfesores=SelectData.selectAllTrabajadores();
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
		
		
	}
	
	@Test
	public void testInsert2() throws SQLException {
		
		
		myDBManager.createNewTableTrabajador();
		
		myDBManager.insertTrabajador("Amaia", "Zarranz", "Mendizabal", "73608820M", "amaiazar",
					"amaia", "amaia@gmail.com", "", "profesor", 1000);
		
		
		ArrayList <Trabajador> d=SelectData.selectAllTrabajadores();
		
		String email=null;
		Trabajador t=null;
		for (Trabajador a: d) {
			//System.out.println(a.getEmail());
			email=a.getEmail();
			t=a;
		}
		
		
		//assertEquals("amaia@gmail.com", email);
		//assertEquals("amaia@gmail.com", t.getEmail());

		
	}

}
