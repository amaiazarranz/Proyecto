package tests;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import sqlite.DBManager;
import sqlite.SelectData;
import usuarios.Trabajador;

public class Insert {
	
	@Before
	public void setUp() throws Exception {
		
			
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	
	public void test() {
		
		try {
			DBManager.insertTrabajador("Amaia", "Zarranz", "Mendizabal", "73608820M", "amaiazar",
					"amaia", "amaia@gmail.com", "", "profesor", 1000);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList <Trabajador> d=SelectData.selectAllTrabajadores();
		
		String email=null;
		Trabajador b=null;
		
		for (Trabajador a: d) {
			System.out.println(a.getEmail());
			email=a.getEmail();
			b=a;
		}
		
		
		assertEquals("amaia@gmail.com", email);
		assertEquals("amaia@gmail.com", b.getEmail());
		
	}

}
