package utilidades;

public class Comprobaciones {

    public static boolean ValidarNom(char[] arrayNom) //los nombre no tienen que ser iguales
    {
        boolean validar = true;
        char ascii=0;

        for (int i = 0; i<arrayNom.length; i++)
        {
            ascii = arrayNom[i];

            if ((ascii>=65 && ascii<=90) || (ascii>=97 && ascii<=122))
            {
                validar = true;
            }

            else
            {
                validar = false;
                break;
            }
        }

        return validar;
    }

    public static boolean comprobardninumeros(char[] arrayDNI)
    {
        boolean comprobacion = false;
        char ascii=0;

        for (byte i=0; i<8; i++)
        {
            ascii = arrayDNI[i];

            if (ascii>=48 && ascii<=57)
            {
                comprobacion = true;
            }

            else
            {
                comprobacion = false;
                break;
            }
        }

        return comprobacion;

    }

    public static boolean comprobardniletra(char[] arrayDNI)
    {

        boolean comprobacion;
        char ultimaletra = arrayDNI[arrayDNI.length-1];

        if (ultimaletra>=65 && ultimaletra<=90)
        {
            comprobacion = true;
        }

        else
        {
            comprobacion = false;
        }

        return comprobacion;
    }

    public static boolean comprobaribannumeros(char[] arrayIban)
    {
        boolean comprobacion = false;
        char ascii=0;

        for (byte i=2; i<23; i++)
        {
            ascii = arrayIban[i];

            if (ascii>=48 && ascii<=57)
            {
                comprobacion = true;
            }

            else
            {
                comprobacion = false;
                break;
            }
        }

        return comprobacion;
    }

    public static boolean comprobaribanletra(char[] arrayIban) {

        boolean comprobacion;
        char primeraLetra = arrayIban[0];
        char segundaLetra=arrayIban [1];


        if ((primeraLetra>=65 && primeraLetra<=90) && (segundaLetra >=65 && segundaLetra<=90))
        {
            comprobacion = true;
        }

        else
        {
            comprobacion = false;
        }

        return comprobacion;
    }


}
