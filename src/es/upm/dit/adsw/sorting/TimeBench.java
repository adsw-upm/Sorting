package es.upm.dit.adsw.sorting;

import java.util.Random;

/**
 * Time meter for sorting algorithms
 * <p>
 * Created by jpuente on 23/1/17.
 */
public class TimeBench {
    private static final Random random = new Random();

    public static void main(String[] args) {
       /*
         * Change for different algorithms
         */
       StringSorter sorter = new MergeSortIterative();
//    	StringSorter sorter = new QuickSortH();
//        StringSorter sorter = new QuickSort2();
//        StringSorter sorter = new SelectionSort();
//        StringSorter sorter = new InsertionSort();
//    	StringSorter sorter = new BubbleSort();
        /*
         * Test size
         */
        int[] N = {1000,                //preheating
                100, 200, 300, 400, 500,
                1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000
        };

        for (int n : N) {
            for (int i = 0; i < 3; i++) {
                long t = time(sorter, n);
                System.out.printf("%s %d%n", n, t);
            }
        }
    }

    private static long time(StringSorter sorter, int n) {
        long t = 0;

        for (int j = 0; j < 1000; j++) {
            // generate array of size n
            String[] data = new String[n];
            for (int i = 0; i < data.length; i++) {
                char ch = (char) ('a' + random.nextInt(25));
                data[i] = String.valueOf(ch);
            }
            long t0 = System.nanoTime();
            sorter.sort(data);
            long t1 = System.nanoTime();
            t += t1 - t0;
        }

        return t;
    }

}
