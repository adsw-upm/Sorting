package es.upm.dit.adsw.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Quicksort for String -- Tony Hoare version
 *
 * Created by jpuente on 23/1/17.
 */
public class QuickSort1 extends StringSorter {

    @Override
    public void sort(String[] data) {
        sort(data, 0, data.length);
    }

    /**
     * Sort data [a,z)
     */
    private void sort(String[] data, int a, int z) {
        if (z <= a)
            return;

        String pivot = data[(a + z) / 2]; // use middle element as pivot

        int i = a;
        int j = z - 1;
        while (i <= j) {
            while (OpMeter.compareTo(data[i], pivot) < 0)
                i++;
            while (OpMeter.compareTo(data[j], pivot) > 0)
                j--;
            if (i <= j)
                swap(data, i++, j--);
        }
//        for (int i = a; i < j + 1; i++)
//            assert data[i].compareTo(pivot) <= 0;
//        for (int i = i; i < z; i++)
//            assert data[i].compareTo(pivot) >= 0;
        sort(data, a, j + 1);
        sort(data, i, z);
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

        StringSorter sorter = new QuickSort1();
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
        assert sorter.sorted(data, 0, data.length);
    }
}
