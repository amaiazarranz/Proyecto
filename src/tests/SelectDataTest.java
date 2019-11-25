package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sqlite.DBManager;

public class SelectDataTest {

	DBManager myDBManager;

	@Before
	public void setUp() throws Exception {
		myDBManager= new DBManager("UniversidadDeusto4.db");
		myDBManager.createLink();	
		
		
	}

	@After
	public void tearDown() throws Exception {
		myDBManager.closeLink();
	}

	@Test
	public void testFail() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		
	}

}
