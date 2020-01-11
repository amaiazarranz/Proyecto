package tests;

import static org.junit.Assert.*;

/**
 * En esta clase se hacen las pruebas unitarias del MergeSort
 * @author Alumno Amaia y Olatz
 *
 */

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilidades.QuickSort;

public class QuickSortTest {
	
	int[] arr= new int [5];
	
	/**
	 * Se lanza antes de los test
	 * @throws Exception excepcion
	 */
	
	@Before
	public void setUp() throws Exception {
		arr [0]=1000;
		arr [1]=1500;
		arr [2]=2000;
		arr [3]=2500;
		arr [4]=3000;
		
	}
	
	/**
	 * Se lanza despues de los test
	 * @throws Exception excepcion
	 */
	
	@After
	public void tearDown() throws Exception {
	}

	
	/**
	 * Test del QuickSort
	 */
	
	@Test
	public void testOrdenar() {
		QuickSort.quicksort(arr, 0, arr.length);
		
		int menor1= arr[0];
		int menor2= arr[1];
		int menor3= arr[2];
		int menor4= arr[3];
		int menor5= arr[4];
		
		assertEquals(menor1, 1000);
		assertEquals(menor2, 1500);
		assertEquals(menor3, 2000);
		assertEquals(menor4, 2500);
		assertEquals(menor5, 3000);
		assertNotEquals(menor1, 3000);
		
		
	}

}
