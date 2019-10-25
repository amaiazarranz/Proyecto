package utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

    public class Utilidades {

        public static int leerEntero() {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            Integer entero = null;
            boolean error = true;
            do {
                try {
                    String cadena = br.readLine();
                    entero = new Integer(cadena);
                    error = false;
                } catch (NumberFormatException nfe) {
                    System.out.println("No tecleó un número entero-Repetir");
                } catch (Exception e) {
                    System.out.println("Error de entrada-Repetir ");
                }
            } while (error);
            return entero.intValue();
        }


        public static double leerReal() {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            Double real = null;
            boolean error = true;
            do {
                try {
                    String cadena = br.readLine();
                    real = new Double(cadena);
                    error = false;
                } catch (NumberFormatException nfe) {
                    System.out.println("No tecleó un número real-Repetir ");
                } catch (Exception e) {
                    System.out.println("Error de entrada-Repetir ");
                }
            } while (error);
            return real.doubleValue();
        }


        public static char leerCaracter() {
            char caracter = 0;
            boolean error = true;
            do {
                try {
                    caracter = (char) System.in.read();
                    System.in.skip(System.in.available());
                    error = false;
                } catch (Exception e) {
                    System.out.println("Error de entrada-Repetir ");
                }
            } while (error);
            return caracter;
        }


        public static String leerCadena() {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String cadena = null;
            boolean error = true;
            do {
                try {
                    cadena = br.readLine();
                    error = false;
                } catch (Exception e) {
                    System.out.println("Error de entrada-Repetir ");
                }
            } while (error);
            return cadena;
        }
}

