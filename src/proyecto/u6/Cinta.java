package proyecto.u6;

import java.util.*;

// Clase Cinta
public class Cinta {
    // La lista celdas que simulara la Cinta infinita
    private ArrayList<Character> celdas;
    // La posicion o el indice de donde vamos en la Cinta
    private int idx;
    
    // Constructor para crear la Cinta a raiz de la cadena que resivimos
    public Cinta (String cadena) {
        // Lo inicializamos en 1 porque en 0 estara un '_' (Espacio en blanco)
        this.idx = 1;
        this.celdas = new ArrayList<>();
        for (int i = -1; i <= cadena.length(); i++) {
            if (i == -1 || i == cadena.length()) {
                celdas.add('_');
                continue;
            }
            celdas.add(cadena.charAt(i));
        }
    }
    
    // Regresamos el carcater en la posicion idx
    public char leer () {
        return celdas.get(idx);
    }
    
    // cambimos de caracter en la cinta
    public void escibir (char newSimbolo) {
        celdas.set(idx, newSimbolo);
    }
    
    //Dependiendo de la direccion nos movemos a un lado u a otro lado
    public void mover (char direccion) {
        if (direccion == 'I') {
            if (idx <= 0) {
                celdas.add(0,'_');
            } else {
                idx--;
            }
        } else if (direccion == 'D') {
            idx++;
            if (idx >= celdas.size()) {
                celdas.add('_');
            }
        }
    }
    
    // Recibimos el estado actual
    public String estructura (String estado) {
        String struct = "";
        String pf = "[";
        String sf = "[";
        for (int i = 0; i < idx; i++) {
            pf += celdas.get(i);
        }
        pf += "]";
        struct += pf;
        struct += " (";
        struct += estado;
        struct += ") ";
        sf += celdas.get(idx);
        for (int i = idx + 1; i < celdas.size(); i++) {
            sf += celdas.get(i);
        }
        sf += "]";
        struct += sf;
        return struct;
    }
    
    // Regresamos como es que quedo la cinta al final de todo
    public String cintaFinal () {
        String ans = "";
        for (int i = 0; i < celdas.size(); i++) {
            ans += celdas.get(i);
        }
        return ans;
    }
}
