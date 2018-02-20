package es.upm.dit.adsw.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Selection sort for String
 *
 * Created by jpuente on 23/1/17.
 */
public class SelectionSort extends StringSorter {

    @Override
    public void sort(String[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int j = min (data, i, data.length);
            swap(data, i, j);
            assert sorted(data, 0, i + 1);
        }
    }

    /**
     *  Minumum element element in an array slice
     *
     * @param data array
     * @param a    first index of the slice
     * @param z    last ondex of the slice
     * @return the index of the minimum element in data[a,z)
     */
    private int min(String[] data, int a, int z) {
        int m = a;
        for (int i = a; i < z; i++) {
            if (OpMeter.compareTo(data[i], data[m]) < 0)
                m = i;
        }
        return m;
    }

    /**
     * Smoke test
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        Random random = new Random();
        String[] data = new String[10];
        for (int i = 0; i < data.length; i++) {
            char ch = (char) ('a' + random.nextInt(25));
            data[i] = String.valueOf(ch);
        }
        System.out.println(Arrays.toString(data));

        StringSorter sorter = new SelectionSort();
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
        assert sorter.sorted(data, 0, data.length);
    }
}
