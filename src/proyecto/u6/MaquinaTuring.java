package proyecto.u6;
import java.util.*;

public class MaquinaTuring {
    /*
        Notación Formal: M = (Q, Σ, Γ, δ, q0, B, F)

        Q  = {q0, q1, q2, qf}                (Conjunto finito de estados)
        Σ  = {A, B, C, D, E, F}              (Alfabeto de entrada)
        Γ  = {A, B, C, D, E, F, _}           (Alfabeto de cinta)
        δ  : Q × Γ → Q × Γ × {L, R, ' '}     (Función de transición definida en TablaTransiciones)
        q0 = q0                              (Estado inicial)
        B  = _                               (Símbolo en blanco)
        F  = {qf}                            (Conjunto de estados finales o de aceptación)
    */
    private Cinta cinta;
    private TablaTransiciones delta;
    private String estadoIni;
    private String estadoAct;
    private Set<Character> sigma;
    private Set<String> F;

    // Constructor para inicializar valores
    public MaquinaTuring() {
        this.delta = new TablaTransiciones();
        this.estadoIni = "q0";
        this.sigma = Set.of('A', 'B', 'C', 'D', 'E', 'F');
        this.F = Set.of("qf");
    }

    // Valida que la cadena no contenga carecteres distintos a sigma
    public boolean validador(String cadena) {
        for(int i = 0; i < cadena.length(); i++) {
            if(!sigma.contains(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Función para cifrar una cadena dada
    public void cifrar(String entrada) {
        System.out.println("------------------ CIFRANDO LA CADENA ------------------");
        // Si la cadena no pasa la validacion, detenemos el cifrado
        if(!validador(entrada)) {
            System.out.println("La cadena contiene caracteres distintos al lenguaje aceptado: [A, B, C, D, E, F]");
            return; 
        }
        // Inicialización de variables para realizar el proceso de cifrado
        this.cinta = new Cinta(entrada);
        this.estadoAct = estadoIni;
        System.out.println(cinta.estructura(estadoAct)); // Imprime el estado inicial de la cinta
        // Mientras el estado actual no es ninguno de los estados de aceptación
        while(!F.contains(estadoAct)) {
            char simboloAct = cinta.leer(); // Lee el símbolo actual de la cinta
            Transicion T = delta.getTransicionCifrado(estadoAct, simboloAct); // Realiza la transición
            cinta.escribir(T.getSimbolo()); // Modifica el símbolo de la cinta
            cinta.mover(T.getDireccion()); // Mueve el cabezal
            estadoAct = T.getNewEstado(); // Actualiza el estado
            System.out.println(cinta.estructura(estadoAct)); // Imprime las modificaciones de la cinta
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Cadena cifrada: " + cinta.cintaFinal().replace("_", "")); // Imprime la cadena cifrada
    }

    // Función para descifrar una cadena dada
    public void descifrar(String entrada) {
        System.out.println("------------------ DESCIFRANDO LA CADENA ------------------");
        // Si la cadena no pasa la validacion, detenemos el descifrado
        if(!validador(entrada)) {
            System.out.println("La cadena contiene caracteres distintos al lenguaje aceptado: [A, B, C, D, E, F]");
            return; 
        }
        // Inicialización de variables para realizar el proceso de descifrado
        this.cinta = new Cinta(entrada);
        this.estadoAct = estadoIni;
        System.out.println(cinta.estructura(estadoAct)); // Imprime el estado inicial de la cinta
        // Mientras el estado actual no es ninguno de los estados de aceptación
        while(!F.contains(estadoAct)) {
            char simboloAct = cinta.leer(); // Lee el símbolo actual de la cinta
            Transicion T = delta.getTransicionDescifrado(estadoAct, simboloAct); // Realiza la transición
            cinta.escribir(T.getSimbolo()); // Modifica el símbolo de la cinta
            cinta.mover(T.getDireccion()); // Mueve el cabezal
            estadoAct = T.getNewEstado(); // Actualiza el estado
            System.out.println(cinta.estructura(estadoAct)); // Imprime las modificaciones de la cinta
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Cadena descifrada: " + cinta.cintaFinal().replace("_", "")); // Imprime la cadena descifrada
    }
}
