package proyecto.u6;


// Clase Transición
public class Transicion {
    // necesitaremos 3 atributos 
    // newEstado nos va a ayudar a saber a cual estado es al siguiente que 
    // nos vamos a mover en la tabla de transiciones
    private String newEstado;
    // simbolo es el caracter nuevo que vamos a poner el lugar del anterior
    private char simbolo;
    // direccion es hacia donde vamos a la derecha o hacia la izquierda
    private char direccion;

    // constructor para poder inicializar los valores
    public Transicion (String newEstado, char simbolo, char direccion) {
        this.newEstado = newEstado;
        this.simbolo = simbolo;
        this.direccion = direccion;
    }

    
    // getters para poder obtener los valores privados de la clase
    public String getNewEstado () {
        return newEstado;
    }

    public char getSimbolo () {
        return simbolo;
    }

    public char getDireccion () {
        return direccion;
    }
}
