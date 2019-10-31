package tests;
import static org.junit.Assert.assertEquals;


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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Estudiante e1 = new Estudiante(
				"String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
	    		"String email", "String iban", "String tipopersona", 20.0, 10, 0
	    		);
		
		Profesor p1 = new Profesor(
				"String nom", "String apellido1", "String apellido2", "String dni",
               "String user", "String password", "String email", "String iban", "String tipopersona",
                3000.0
	    		);
		
		try {
			DBManager.insertTrabajador("String nom", "String apellido1", "String apellido2", "String dni",
			           "String user", "String password", "String email", "String iban", "String tipopersona",
			            3000.0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DBManager.insertEstudiante("String nombre", "String apellido1", "String apellido2", "String dni", "String user", "String password", 
					"String email", "String iban", "String tipopersona", 20.0, 10, 0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nombre= null;
		String dni= null;
		Estudiante b = null;
		ArrayList <Estudiante> diccionarioEstudiantes=SelectData.selectAllEstudiantes();
		for (Estudiante a: diccionarioEstudiantes) {
			if (e1.getDni().equals("String dni")){
				nombre=e1.getNombre();
				dni=e1.getDni();
				b=a;
				break;
			}
		
			
		}
		String nombr= null;
		Trabajador c = null;
		ArrayList<Trabajador> diccionarioProfesores=SelectData.selectAllTrabajadores();
		for (Trabajador p: diccionarioProfesores) {
			if (p1.getDni().equals("String dni")){
				nombr=e1.getNombre();
				c=p;
				break;
			}
			
		}
		

		assertEquals("String nombre", nombre);	
	
		assertEquals("String nom", nombr);
		
		assertEquals("String dni", dni);
		
	}

}
