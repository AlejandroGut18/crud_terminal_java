public class ValidadorEntrada {
    //Validar sólo letras
    public static String validarLetras(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Debe contener sólo letras 😘👌");

        }

        return str;
    }

    /*public static int validarEdad(int edad) throws EdadInvalidaException {
        if (edad <= 0) {
            throw new EdadInvalidaException("La edad debe ser mayor que cero. 😁😁😁😁");
        }
        return edad;
    }*/

    public static float validarNota(float nota) throws IllegalArgumentException{
        if (nota <= 0 || nota > 20) {
            throw new IllegalArgumentException("Nota invalida. Rango: 1 - 20. 😉😉😉");
        }
        return nota;
    }

    public static int validarOption(int option) throws IllegalArgumentException{
        if (option < 1 || option > 6) {
            throw new IllegalArgumentException("La opcion debe estar dentro del rango: 1 - 6.");
        }
        return option;
    }

    public static String validarLetrasYNumeros(String str) throws IllegalArgumentException {
        if (!str.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Debe contener sólo letras y números 😘👌");
        }
        return str;
    }

    /*public static float validarFloat(float n) throws IllegalArgumentException{


        throw new IllegalArgumentException("Nota invalida. Rango: 1 - 20. 😉😉😉");

        return nota;
    }*/
}
