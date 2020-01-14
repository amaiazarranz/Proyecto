package utilidades;
	
import java.util.*;

import javax.swing.JOptionPane;

import usuarios.Estudiante;

/**
 * La clase del mergesort generico
 * @author Alumno Amaia y Olatz
 *
 * @param <T> parametro generico t
 */
public class MergeSortGenerico <T extends Estudiante>
{
	
	 static List<Estudiante> estudianteList = new ArrayList<Estudiante>();
	 
    private boolean debug; //turn on/off debug messages
    
    /**
     * El constructor
     * @param i_debug debug
     */

    public MergeSortGenerico(boolean i_debug) {
        debug = i_debug;
    }

    /**
     * Nos permite acceder al mergesort
     * @param diccionarioEstudiantes diccionarioEstudiantes
     * @return devuelve la lista ordenada
     */
    
    public static List <Estudiante> introducir(ArrayList <Estudiante> diccionarioEstudiantes) {
    	
    	 MergeSortGenerico<Estudiante> ml = new MergeSortGenerico<Estudiante>(false);
    	 estudianteList=diccionarioEstudiantes;
    	
    	 List <Estudiante> ordenado=ml.mergesort(estudianteList);
    	 
    	 return ordenado;
    }

    
    /**
     * El mergesort
     * @param ilist la lista de estudiantes
     * @return lista ordenada
     */
    //call mergesort on param list
    public List<T> mergesort(List<T> ilist)
    {
        if(debug)
            System.out.println("do merge sort called on arg (" + ilist.toString() + ")");

        if(ilist.size() <= 1)
        {
            if(debug)
                System.out.println("Returning single length list: " + ilist.toString());

            return ilist;

        }
        else
        {
            List<T> left = new ArrayList<T>();
            List<T> right = new ArrayList<T>();

            int middle = ilist.size() / 2; //int division
            for(int i=0;i<middle;i++)
            {
                left.add(ilist.get(i));
            }

            for(int i=middle;i<ilist.size();i++)
            {
                right.add(ilist.get(i));
            }

            if(debug)
                System.out.println("Calling merge on left: " + left.toString() + " and right: " + right.toString());

            return merge(mergesort(left), mergesort(right));
        }
    }
    
    /**
     * Hace la mezca
     * @param a la lista de la izquierda
     * @param b la lista de la derecha
     * @return lo mezclado
     */
    //used by mergesort to do merging
    private List<T> merge(List<T> a, List<T> b)
    {
        List<T> ret = new ArrayList<T>(); //return list
        int a_idx = 0, b_idx = 0; //counters of items left in respective lists

        while(a_idx+1 <= a.size() || b_idx+1 <= b.size())
        {
            if(a_idx+1 <= a.size() && b_idx+1 <= b.size())
            {
                if (a.get(a_idx).ordenar(b.get(b_idx)) )
                {
                    ret.add(a.get(a_idx));
                    a_idx++;
                }
                else
                {
                    ret.add(b.get(b_idx));
                    b_idx++;
                }
            }
            else if(a_idx+1 <= a.size())
            {
                ret.add(a.get(a_idx));
                a_idx++;
            }
            else if(b_idx+1 <= b.size())
            {
                ret.add(b.get(b_idx));
                b_idx++;
            }
        }

        if(debug)
            System.out.println("Returning merged array: " + ret.toString());

        return ret;
    }
}
