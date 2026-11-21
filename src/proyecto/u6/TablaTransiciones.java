    package proyecto.u6;
    import java.util.*;

    public class TablaTransiciones {
        
        private HashMap<String, Transicion> tablaDeTransicionesCifrado = new HashMap<>();
        private HashMap<String, Transicion> tablaDeTransicionesDescifrado = new HashMap<>();

        // COnstructuor para llenar la tabla de transiciones
        public TablaTransiciones() {
            
            // Desde q0, mueve una letra a la derecha
            tablaDeTransicionesCifrado.put("q0A", new Transicion("q1", 'B', 'R'));
            tablaDeTransicionesCifrado.put("q0B", new Transicion("q1", 'C', 'R'));
            tablaDeTransicionesCifrado.put("q0C", new Transicion("q1", 'D', 'R'));
            tablaDeTransicionesCifrado.put("q0D", new Transicion("q1", 'E', 'R'));
            tablaDeTransicionesCifrado.put("q0E", new Transicion("q1", 'F', 'R'));
            tablaDeTransicionesCifrado.put("q0F", new Transicion("q1", 'A', 'R'));

            // desde q1, mueve dos letras a la derecha
            tablaDeTransicionesCifrado.put("q1A", new Transicion("q2", 'C', 'R'));
            tablaDeTransicionesCifrado.put("q1B", new Transicion("q2", 'D', 'R'));
            tablaDeTransicionesCifrado.put("q1C", new Transicion("q2", 'E', 'R'));
            tablaDeTransicionesCifrado.put("q1D", new Transicion("q2", 'F', 'R'));
            tablaDeTransicionesCifrado.put("q1E", new Transicion("q2", 'A', 'R'));
            tablaDeTransicionesCifrado.put("q1F", new Transicion("q2", 'B', 'R'));

            // desde q2, mueve tres letras a la derecha
            tablaDeTransicionesCifrado.put("q2A", new Transicion("q0", 'D', 'R'));
            tablaDeTransicionesCifrado.put("q2B", new Transicion("q0", 'E', 'R'));
            tablaDeTransicionesCifrado.put("q2C", new Transicion("q0", 'F', 'R'));
            tablaDeTransicionesCifrado.put("q2D", new Transicion("q0", 'A', 'R'));
            tablaDeTransicionesCifrado.put("q2E", new Transicion("q0", 'B', 'R'));
            tablaDeTransicionesCifrado.put("q2F", new Transicion("q0", 'C', 'R'));

            //cuando lee un blanco de cualquier estado se va a qf
            tablaDeTransicionesCifrado.put("q1_", new Transicion("qf", '_', ' '));
            tablaDeTransicionesCifrado.put("q2_", new Transicion("qf", '_', ' '));
            
            tablaDeTransicionesCifrado.put("q0", new Transicion("qf", '_', ' '));

            //tabla de descifrado, hace lo mismo pero al reves
            // Desde q0
            tablaDeTransicionesDescifrado.put("q0A", new Transicion("q1", 'F', 'R'));
            tablaDeTransicionesDescifrado.put("q0B", new Transicion("q1", 'A', 'R'));
            tablaDeTransicionesDescifrado.put("q0C", new Transicion("q1", 'B', 'R'));
            tablaDeTransicionesDescifrado.put("q0D", new Transicion("q1", 'C', 'R'));
            tablaDeTransicionesDescifrado.put("q0E", new Transicion("q1", 'D', 'R'));
            tablaDeTransicionesDescifrado.put("q0F", new Transicion("q1", 'E', 'R'));

            // desde q1
            tablaDeTransicionesDescifrado.put("q1A", new Transicion("q2", 'E', 'R'));
            tablaDeTransicionesDescifrado.put("q1B", new Transicion("q2", 'F', 'R'));
            tablaDeTransicionesDescifrado.put("q1C", new Transicion("q2", 'A', 'R'));
            tablaDeTransicionesDescifrado.put("q1D", new Transicion("q2", 'B', 'R'));
            tablaDeTransicionesDescifrado.put("q1E", new Transicion("q2", 'C', 'R'));
            tablaDeTransicionesDescifrado.put("q1F", new Transicion("q2", 'D', 'R'));

            // desde q2 es igual a la otra
            tablaDeTransicionesDescifrado.put("q2A", new Transicion("q0", 'D', 'R'));
            tablaDeTransicionesDescifrado.put("q2B", new Transicion("q0", 'E', 'R'));
            tablaDeTransicionesDescifrado.put("q2C", new Transicion("q0", 'F', 'R'));
            tablaDeTransicionesDescifrado.put("q2D", new Transicion("q0", 'A', 'R'));
            tablaDeTransicionesDescifrado.put("q2E", new Transicion("q0", 'B', 'R'));
            tablaDeTransicionesDescifrado.put("q2F", new Transicion("q0", 'C', 'R'));

            //cuando lee un blanco de cualquier estado se va a qf
            tablaDeTransicionesDescifrado.put("q0", new Transicion("qf", '_', ' '));
            tablaDeTransicionesDescifrado.put("q1_", new Transicion("qf", '_', ' '));
            tablaDeTransicionesDescifrado.put("q2_", new Transicion("qf", '_', ' '));
            
        }
        // dado el estado y el simbolo, devuelve la trasicion correcta
        public Transicion getTransicionCifrado(String estado, char simbolo) {
            // usa de clave el estado concatenado con el simbolo
            return tablaDeTransicionesCifrado.get(estado + simbolo);
        }

        public Transicion getTransicionDescifrado(String estado, char simbolo) {
            // usa de clave el estado concatenado con el simbolo
            return tablaDeTransicionesDescifrado.get(estado + simbolo);
        }
    }
