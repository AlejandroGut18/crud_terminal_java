import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("1-Agregar\n2-Leer\n3-Actualizar\n4-Eliminar\n5-Buscar\n6-Salir\nElija una opción: ");

            int option = 0;
            while (option == 0){
                try {
                    option = ValidadorEntrada.validarOption(Integer.parseInt(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese solo números.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (option == 6){
                break;
            }
            switch (option){
                case 1:
                    agregar();
                    clear();
                    break;
                case 2:
                    leer();
                    clear();
                    break;
                case 3:
                    actualizar();
                    clear();
                    break;
                case 4:
                    eliminar();
                    clear();
                    break;
                case 5:
                    String cedula = leerNumStrings("Ingrese la cédula del estudiante: ");
                    buscar(cedula);
                    clear();
                    break;
            }
        }
        scanner.close();
    }

    public static boolean buscar(String cedula) {
        if (listaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en la lista.");
            pausar();
            return false;
        }
        boolean encontrado = false;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                System.out.println("Estudiante encontrado:");
                System.out.println(estudiante.toString());
                encontrado = true;
                pausar();
                return encontrado;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún estudiante con esa cédula.");
            pausar();
        }
        return false;
    }

    public static void actualizar() {
        Scanner scanner = new Scanner(System.in);
        String cedula = leerCadena("Ingrese cedula del estudiante: ");
        leer();
        Estudiante estudiante = null;
        for (Estudiante est : listaEstudiantes) {
            if (est.getCedula().equals(cedula)) {
                estudiante = est;
                break;
            }
        }

        String nuevoNombre = leerCadena("Ingrese el nuevo nombre (actual: " + estudiante.getNombre() + "):");
        String nuevoApellido = leerCadena("Ingrese la nuevo apellido (actual: " + estudiante.getApellido() + "):");
        float nuevoPeso = leerFloat("Ingrese la nuevo peso (actual: " + estudiante.getPeso() + "):");
        float nuevaNota = leerFloat("Ingrese la nueva nota (actual: " + estudiante.getNota() + "):");
        float nuevaEstatura = leerFloat("Ingrese la nueva estatura (actual: " + estudiante.getEstatura() + "):");

        estudiante.setNombre(nuevoNombre);
        estudiante.setApellido(nuevoApellido);
        estudiante.setPeso(nuevoPeso);
        estudiante.setEstatura(nuevaEstatura);
        estudiante.setNota(nuevaNota);

        System.out.println("Estudiante actualizado con éxito.");
        pausar();

    }

    public static void eliminar() {
        if (listaEstudiantes.isEmpty()){
            System.out.println("No hay Estudiantes");
            pausar();
            return;
        }
        System.out.println("Lista de estudiantes: ");
        leer();
        String cedula = leerNumStrings("Ingrese la cédula del estudiante a eliminar: ");
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getCedula().equals(cedula)) {
                listaEstudiantes.remove(i);
                System.out.println("Estudiante eliminado con éxito.\n");
                pausar();
                return;
            }
        }
        System.out.println("Estudiante no encontrado.\n");
        pausar();
    }

    public  static void leer(){
        clear();
        if (listaEstudiantes.isEmpty()){
            System.out.println("No hay Estudiantes");
            pausar();
        }else{
            for (Estudiante estudiante : listaEstudiantes){
                System.out.println(estudiante.toString());
            }
            pausar();
        }
    }

    public static void agregar(){
        System.out.println("Ingresa los datos del estudiante: ");
        String nombre = leerCadena("Nombre: ");
        String apellido = leerCadena("Apellido: ");
        String cedula = leerNumStrings("Cedula: ");
        String sexo = leerCadena("Sexo: ");
        float peso = leerFloat("Peso: ");
        float estatura = leerFloat("Estatura: ");
        float nota;
        while (true) {
            nota = leerFloat("Nota: ");
            if (nota >=0 & nota <=20){
                break;
            }
            System.out.print("La nota no puede ser menor a 0 o mayor 20: ");
        }
        Estudiante estudiante = new Estudiante(nombre,apellido,cedula,sexo,peso,estatura,nota);
        listaEstudiantes.add(estudiante);
        System.out.println("Estudiante agregado con éxito.");
        pausar();
    }

    public static float leerFloat(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        float numero;
        while (true){
            try {
                numero = ValidadorEntrada.validarFloat(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        return numero;
    }

    public static String leerCadena(String message) {
        Scanner scanner = new Scanner(System.in);
        String cadena = null;
        while (cadena == null){
            System.out.print(message);
            try {
                cadena = ValidadorEntrada.validarLetras(scanner.nextLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        return cadena;
    }
    public static String leerNumStrings(String message) {
        Scanner scanner = new Scanner(System.in);
        String cadena = null;
        while (cadena == null){
            System.out.print(message);
            try {
                cadena = ValidadorEntrada.validarLetrasYCedula(scanner.nextLine());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Error no controlado");
                System.out.println(e.getMessage());
            }
        }
        return cadena;
    }

    public static void clear() {
        for (int i = 0; i < 10; ++i) System.out.println();

    }

    public static void pausar() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Presione Enter para continuar...");
            input = scanner.nextLine();
        } while (!input.isEmpty());
    }

}