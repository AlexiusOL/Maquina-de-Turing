package proyecto.u6;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializa el escáner para leer datos
        MaquinaTuring MT = new MaquinaTuring(); // Instancia el objeto MT con la clase Máquina de Turing
        // Menú interactivo
        do {
            System.out.println("Selecciona la opción que quieres realizar: ");
            System.out.println("1. Cifrar palabra"); // Escribe '1' Para cifrar una palabra
            System.out.println("2. Descifrar palabra"); // Escribe '2' Para descifrar una palabra
            System.out.println("3. Salir"); // Escribe '3' Para salir de la interacción
            String s = sc.next(); // Leemos la cadena dada
            if(s.equals("1")) {
                System.out.println("Ingresa la cadena que quieres cifrar: ");
                String cadena = sc.next();
                MT.cifrar(cadena); // Ciframos la cadena ingresada
            }
            else if(s.equals("2")) {
                System.out.println("Ingresa la cadena que quieres descifrar: ");
                String cadena = sc.next();
                MT.descifrar(cadena); // Desciframos la cadena ingresada
            }
            else if(s.equals("3")) {
                System.out.println("Saliendo del menú interactivo...");
                break; // Saliendo del ciclo
            }
            else {
                System.out.println("Debes ingresar un número entre [1-3]");
            }
            System.out.println("===============================================");
        }while(true);
        sc.close();
    }
}
