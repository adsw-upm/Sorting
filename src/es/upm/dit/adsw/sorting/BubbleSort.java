package es.upm.dit.adsw.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Insertion sort for String
 *
 * Created by jpuente on 13/1/17.
 */
public class BubbleSort extends StringSorter {

    @Override
    public void sort(String[] datos) {
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < datos.length - 1; i++) {
                if (OpMeter.compareTo(datos[i],datos[i + 1]) > 0) {
                    swap(datos, i, i + 1);
                    changed = true;
                }
            }
        } while (changed);

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

        StringSorter sorter = new BubbleSort();
        sorter.sort(datos);
        System.out.println(Arrays.toString(datos));
        assert sorter.sorted(datos, 0, datos.length);
    }
}
