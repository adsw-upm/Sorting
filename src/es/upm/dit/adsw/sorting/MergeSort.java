package es.upm.dit.adsw.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Mergesort - Iterative version
 *
 * Created by jpuente on 23/1/17.
 */
public class MergeSort
        extends StringSorter {

    @Override
    public void sort(String[] data) {
        bottomUpSort(data, new String[data.length]);
    }

    private void bottomUpSort(String[] data, String[] aux) {
        int n = data.length;
        for (int window = 1; window < n; window *= 2) {
            for (int i = 0; i < n; i += 2 * window) {
                int iLeft = i;
                int iRight = Math.min(i + window, n);
                int iEnd = Math.min(i + 2 * window, n);
                bottomUpMerge(data, iLeft, iRight, iEnd, aux);
            }
            System.arraycopy(aux, 0, data, 0, n);
        }
    }

    private void bottomUpMerge(String[] data, int iLeft, int iRight, int iEnd, String[] aux) {

        assert sorted(data, iLeft, iRight);
        assert sorted(data, iRight, iEnd);
        int i0 = iLeft;
        int i1 = iRight;

        int dst= iLeft;
        while (i0 < iRight && i1 < iEnd) {
            if (OpMeter.compareTo(data[i0], data[i1]) <= 0)
                aux[dst++] = data[i0++];
            else
                aux[dst++] = data[i1++];
        }
        while (i0 < iRight)
            aux[dst++] = data[i0++];
        while (i1 < iEnd)
            aux[dst++] = data[i1++];
        assert sorted(aux, iLeft, iEnd);
    }

    // smoke test
    public static void main(String[] args) {
        Random random = new Random();
        String[] data = new String[10];
        for (int i = 0; i < data.length; i++) {
            char ch = (char) ('a' + random.nextInt(25));
            data[i] = String.valueOf(ch);
        }
        System.out.println(Arrays.toString(data));

        StringSorter sorter = new MergeSort();
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
        if (!sorter.sorted(data, 0, data.length))
            System.out.println("ERROR");
    }
}

