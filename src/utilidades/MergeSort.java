package utilidades;

import java.util.ArrayList;


import usuarios.Estudiante;

/**
 * Esta clase es la del algoritmo MergeSort y se ordenarán las notas medias de todos los estudiantes
 * @author Alumno Amaia y Olatz
 *
 */

public class MergeSort {
	
	/**
	 * La ordenación mergesort
	 * @param arrayNotasMedias el array con todas las notas medias
	 * @param izq la posición del elemento de la izquierda del array
	 * @param der la posición del elemento de la derecha del array
	 */
	
	public static void mergesort(ArrayList <Estudiante> diccionarioEstudiantes,int izq, int der){
	    if (izq<der){
	            int m=(izq+der)/2;
	            mergesort(diccionarioEstudiantes,izq, m);
	            mergesort(diccionarioEstudiantes,m+1, der);
	            merge(diccionarioEstudiantes,izq, m, der);
	    }
	}
	
	/**
	 * La operación principal de mezcla
	 * @param A el array 
	 * @param izq el elemento de la izquierda
	 * @param m el elemento central
	 * @param der el elemento de la derecha
	 */
	
	public static void merge(ArrayList<Estudiante> diccionarioEstudiantes ,int izq, int m, int der){

		 int i, j, k;
		 
		 Estudiante [] B = new Estudiante[diccionarioEstudiantes.size()]; //array auxiliar
		 
		 for (i=izq; i<=der; i++) //copia ambas mitades en el array auxiliar
		           
			 	   B[i]=diccionarioEstudiantes.get(i);

		           i=izq; j=m+1; k=0;
		           
		           while (i<=m && j<=der) //si hay elementos en los dos arrays
		          
		           if (B[i].getNotamedia()>B[j].getNotamedia())
		                 
		           diccionarioEstudiantes.set(k++, B[i++]); //k se va sumando
		           else
		             
		           diccionarioEstudiantes.set(k++, B[j++]);
		          
		           while (i<=m) //copia los elementos que quedan de la 
		            diccionarioEstudiantes.set(k++, B[i++]);
		 
		}


}
