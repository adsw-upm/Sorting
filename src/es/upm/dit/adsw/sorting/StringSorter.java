package es.upm.dit.adsw.sorting;

/**
 * Abstract definition of sort algorithms
 * Created by jpuente on 13/1/17.
 */
public abstract class StringSorter {

    /**
     * sort an array of strings
     *
     * @param data array to be sorted
     */
    public abstract void sort(String[] data);

    /**
     *  Swap two array elements
     *
     * @param datos array
     * @param i index of the first element
     * @param j index of the second element
     */
    void swap(String[] datos, int i, int j) {
        if (i == j)
            return;
        String si = datos[i];
        String sj = datos[j];
        datos[i] = sj;
        datos[j] = si;
    }

    /**
     * check if a slice of an array is sorted
     *
     * @param datos array to be checked
     * @return true if datos [a..z) is sorted
     */
    boolean sorted(String[] datos) {
        return sorted(datos, 0, datos.length);
    }

    /**
     * check if a slice of an array is sorted
     *
     * @param datos array to be checked
     * @param a first index of the slice to be checked
     * @param z last index of the slice to be checked + 1
     * @return true if datos [a..z) is sorted
     */
    boolean sorted(String[] datos, int a, int z) {
        for (int i = a; i + 1 < z; i++)
            if (datos[i].compareTo(datos[i + 1]) > 0)
                return false;
        return true;
    }
}
