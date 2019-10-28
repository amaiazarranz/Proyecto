package utilidades;

import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Secretario;
import usuarios.Trabajador;

import java.io.*;
import java.util.ArrayList;

/**
 * En esta clase haremos las lecturas y escrituras de los ficheros
 * @author Alumno Amaia y Olatz
 *
 */

public class LecturaEscrituraFichero {
	
	/**
	 * En este método se leen los estudiantes
	 * @param path path del fichero
	 * @return la lista de los estudiantes
	 */

    public static ArrayList<Estudiante> leerEstudiantes (String path) {

        File aFile = new File(path);

        ArrayList<Estudiante> listaDevolucion = new ArrayList<Estudiante>();

        try {

            FileReader fr = new FileReader(aFile);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {

                String[] estudiantesLeidos = linea.split(";");

                Double notamedia=Double.parseDouble(estudiantesLeidos [9]); //en el fichero están en string
                Integer faltaleve=Integer.valueOf(estudiantesLeidos [10]);
                Integer faltagrave=Integer.valueOf(estudiantesLeidos[11]);


                Estudiante estudiante = new Estudiante (estudiantesLeidos[0], estudiantesLeidos[1], estudiantesLeidos[2],
                        estudiantesLeidos [3], estudiantesLeidos [4], estudiantesLeidos [5], estudiantesLeidos [6], estudiantesLeidos [7], estudiantesLeidos [8],
                        notamedia, faltaleve, faltagrave); // porque es fecha es date //tiene que ser igual que el constructor de estudiante

                listaDevolucion.add(estudiante);


                linea = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDevolucion;
    }
    
    /**
     * En este método se almacenan en el fichero los estudiantes
     * @param todosEstudiantes la lista de los estudiantes
     * @param path path del fichero
     */

    public static void almacenarEstudiantes(ArrayList<Estudiante> todosEstudiantes, String path) {

        File aFile = new File(path);

        try {
            FileWriter fw = new FileWriter(aFile);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Estudiante a : todosEstudiantes) {

                String escribir = a.getNombre() + ";" + a.getApellido1() + ";" + a.getApellido2()+ ";" + a.getDni() + ";" +
                          a.getUser()+ ";"+ a.getPassword()+ ";"+ a.getEmail()+ ";" + a.getTipopersona() + ";"
                        + a.getIban() + ";" +a.getNotamedia() + ";"+ a.getFaltaleve() + ";" +a.getFaltagrave() +"\n";

                        bw.write(escribir);

            }

            bw.flush();
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * En este método se leen los trabajadores
	 * @param path path del fichero
	 * @return la lista de los trabajadores
	 */


    public static ArrayList<Trabajador> leerTrabajadores (String path) {

        File aFile = new File(path);

        ArrayList<Trabajador> listaDevolucion = new ArrayList<Trabajador>();

        try {

            FileReader fr = new FileReader(aFile);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {

                String[] trabajadoresLeidos = linea.split(";");

                Double salario=Double.valueOf(trabajadoresLeidos[9]);

                if (trabajadoresLeidos [8].equals("secretario")) {

                    Secretario secretario = new Secretario (trabajadoresLeidos[0], trabajadoresLeidos[1], trabajadoresLeidos[2],
                            trabajadoresLeidos [3], trabajadoresLeidos [4], trabajadoresLeidos [5], trabajadoresLeidos [6], trabajadoresLeidos [7], trabajadoresLeidos [8],
                           salario);

                    listaDevolucion.add(secretario);
                }
                else if (trabajadoresLeidos [8].equals("profesor")){

                    Profesor profesor = new Profesor (trabajadoresLeidos[0], trabajadoresLeidos[1], trabajadoresLeidos[2],
                            trabajadoresLeidos [3], trabajadoresLeidos [4], trabajadoresLeidos [5], trabajadoresLeidos [6], trabajadoresLeidos [7], trabajadoresLeidos [8],
                            salario);

                    listaDevolucion.add(profesor);
                }
                linea = br.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDevolucion;
    }


}

