package es.upm.dit.adsw.sorting;

import java.util.Random;

/**
 * @author jmanas
 * @author jpuente
 *         \version 2017.01.31
 * @version 07-Dec-15.
 */
//@SuppressWarnings("Duplicates")
public class OpBench {
    private static final Random random = new Random();

    public static void main(String[] args) {
//       Diccionario diccionario = new DiccionarioBinario(100000);
        StringSorter sorter = new InsertionSort();

        int[] nn = {
                1000,    // precalentamiento
                100, 200, 500,
                1000, 2000, 5000,
                10000
        };

        for (int n : nn) {
            for (int i = 0; i < 3; i++) {
                long t = meter(sorter, n);
                System.out.printf("%s %d%n", n, t);
            }
        }
    }

    private static long meter(StringSorter sorter, int n) {
        String[] data = new String[n];
        long t = 0;
        for (int j = 0; j < 100; j++) {
            load(data);
            long t0 = OpMeter.reset();
            for (int i = 0; i < 100; i++) {
                sorter.sort(data);
            }
            long t2 = OpMeter.getOps();
            t += t2 - t0;
        }
        return t;
    }

    private static void load(String[] data) {
        for (int i = 0; i < data.length; i++) {
            char ch = (char) ('a' + random.nextInt(25));
            data[i] = String.valueOf(ch);
        }
    }
}
