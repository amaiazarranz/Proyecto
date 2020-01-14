package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilidades.QuickSort;

/**
 * En esta clase se hacen las pruebas unitarias del MergeSort
 * @author Alumno Amaia y Olatz
 *
 */

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
		
		assertEquals(arr[0], 1000);
		assertEquals(arr[1], 1500);
		assertEquals(arr[2], 2000);
		assertEquals(arr[3], 2500);
		assertEquals(arr[4], 3000);
		assertNotSame(arr[0], 3000); 
	}

}
