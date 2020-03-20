package es.upm.dit.adsw.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Quicksort for String - hybrid method
 *
 * John Bentley.
 * Programming Pearls.
 * 2nd ed. 1999.
 * Hybrid method
 *
 * Created by jpuente on 23/1/17.
 */
public class QuickSortH extends StringSorter {
    private static final int THRESHOLD = 10;

    @Override
    public void sort(String[] data) {
        sort(data, 0, data.length);
        // System.out.println(Arrays.toString(data));
        StringSorter insertion = new InsertionSort();
        insertion.sort(data);
    }

    /**
     * Sort data [a,z)
     */
    private void sort(String[] data, int a, int z) {
        if (z -a < THRESHOLD)
            return;

        String pivot = data[a]; // start by using first element as pivot
        int i = a;
        for (int j = a + 1; j < z; j++) {
            if (OpMeter.compareTo(data[j], pivot) < 0) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, a, i);  // exchange pivot and data[i]

        for (int jj = a; jj < i + 1; jj++)
            assert data[i].compareTo(pivot) <= 0;
        for (int j = i + 1; j < z; j++)
            assert data[i].compareTo(pivot) >= 0;
        // System.out.println(Arrays.toString(data));
        sort(data, a, i);
        sort(data, i+1, z);
    }

    /**
     * Smoke test
     *
     * @param args - not used
     */
    public static void main(String[] args) {
        Random random = new Random();
        String[] data = new String[20];
        for (int i = 0; i < data.length; i++) {
            char ch = (char) ('a' + random.nextInt(25));
            data[i] = String.valueOf(ch);
        }
        System.out.println(Arrays.toString(data));

        StringSorter sorter = new QuickSortH();
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
        assert sorter.sorted(data, 0, data.length);
    }
}
