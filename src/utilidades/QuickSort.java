package utilidades;

public class QuickSort {
	
	/**
	 * escoge el pivote y hace el quicksort en la parte izquierda y derecha
	 * @param array el array con los salarios
	 * @param low 0
	 * @param high el largo del array
	 */
	
	public static void quicksort (int [] array, int low, int high)
	{
		if (low < high) //tenemos elementos en el array
		{
		int pivot_location = Partition(array, low, high);
		quicksort(array, low, pivot_location);
		quicksort(array, pivot_location + 1, high);
		
		}
	}
	
	/**
	 * Nos sirve para encontrar el indice de pivote
	 * @param array el array con los salarios
	 * @param low la parte baja de array
	 * @param high la parte alta
	 * @return el indice del pivote
	 */
	
	private static int Partition(int[] array, int low, int high)
	{
	
	int pivot = array[low];
	int leftwall = low;
	
	for (int i=low + 1; i<high; i++)
	{
		if (array[i] < pivot)  //swap array[i] con A[leftwall] y leftwall++
		{
		int aux;
		aux = array[i];
		array[i] = array[leftwall];
		array[leftwall] = aux;
		
		leftwall = leftwall + 1;
		}
	
	}
	
	int aux1;//swap pivot con array`leftwall]
	aux1 = pivot;
	pivot = array[leftwall];
	array[leftwall] = aux1;
	
	return leftwall;
	}

}
