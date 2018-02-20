package es.upm.dit.adsw.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Insertion sort for String
 *
 * Created by jpuente on 13/1/17.
 */
public class InsertionSort extends StringSorter {

    @Override
    public void sort(String[] datos) {
        for (int i = 1; i < datos.length; i++) {
            insert(datos, i, datos[i]);
            assert sorted(datos, 0, i + 1);
        }
    }

    /**
     * Insert an element into a slice of an array
     *
     * @param datos array
     * @param z    end of the slice where v is to be inserted
     * @param v    the value to be inserted
     */
    private void insert(String[] datos, int z, String v) {
        int j = z;
        while (0 < j && OpMeter.compareTo(v, datos[j - 1]) < 0)
            j--;
        System.arraycopy(datos, j, datos, j + 1, z - j);
        datos[j] = v;
    }

    /**
     * Smoke test
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        Random random = new Random();
        String[] datos = new String[10];
        for (int i = 0; i < datos.length; i++) {
            char ch = (char) ('a' + random.nextInt(25));
            datos[i] = String.valueOf(ch);
        }
        System.out.println(Arrays.toString(datos));

        StringSorter sorter = new InsertionSort();
        sorter.sort(datos);
        System.out.println(Arrays.toString(datos));
        assert sorter.sorted(datos, 0, datos.length);
    }
}
