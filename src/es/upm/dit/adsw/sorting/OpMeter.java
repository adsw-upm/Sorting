package es.upm.dit.adsw.sorting;

/**
 * Clase auxiliar para contar cuántas veces se llama a un método.
 * Útil para medir complejidad de algoritmos.
 *
 * @author jose a. manas
 * @version 09-Dec-15.
 */
public class OpMeter {

    private static long ops;

    /**
     * pone a cero el contador.
     *
     * @return numero de operaciones, igual a 0.
     */
    public static long reset() {
        ops = 0;
        return ops;
    }

    /**
     * Getter.
     *
     * @return numero de operaciones desde el ultimo reset.
     */
    public static long getOps() {
        return ops;
    }

    /**
     * Wrapper del metodo de comparacion de String.
     *
     * @param s1 una cadena.
     * @param s2 otra cadena.
     * @return 0 si son iguales;
     * un valor negativo si s1 va antes que s2;
     * un valor positivo si s1 va despues que s2.
     * @see String#compareTo(String)
     */
    public static int compareTo(String s1, String s2) {
        ops++;
        return s1.compareTo(s2);
    }
}
