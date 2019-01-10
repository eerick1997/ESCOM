//ServicioComparador.java
package moduloautobd;

import java.util.ArrayList;

public class ServicioComparador {

    private ArrayList palabras;

    //Constructor
    private ServicioComparador(ArrayList p) {
        palabras = p;
    }

    //Obteniendo una instancia
    public static ServicioComparador obtInstancia(ArrayList p) {
        ServicioComparador sc = new ServicioComparador(p);
        return sc;
    }

    //buscar palabras similares
    public ArrayList buscarPalabras(String prefijo) {
        ArrayList similares = new ArrayList();
        String prefijoMayus = prefijo.toUpperCase();

        for (int i = 0; i < palabras.size(); i++) {
            String palabra = (String) palabras.get(i);
            String palabraMayus = palabra.toUpperCase();

            if (palabraMayus.startsWith(prefijoMayus)) {
                similares.add(palabra);
            }
        }
        return similares;
    }
}
