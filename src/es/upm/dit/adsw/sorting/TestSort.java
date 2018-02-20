package es.upm.dit.adsw.sorting;

import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by jpuente on 23/1/17.
 */
public class TestSort {

    private StringSorter sorter;

    @Before
    public void setUp() {
//        sorter = new es.upm.dit.adsw.sorting.InsertionSort();
//        sorter = new es.upm.dit.adsw.sorting.SelectionSort();
//        sorter = new es.upm.dit.adsw.sorting.BubbleSort();
        sorter = new es.upm.dit.adsw.sorting.QuickSort1();
//        sorter = new es.upm.dit.adsw.sorting.QuickSort2();
//        sorter = new QuickSortH();
//        sorter = new MergeSort();
    }

    @org.junit.Test
    public void sort00() throws Exception {
        String[] data = {"d", "b", "c"};
        sorter.sort(data);
        assertTrue(sorter.sorted(data));
    }

    @org.junit.Test
    public void sort01() throws Exception {
        String[] data = {"a", "b", "c"};
        sorter.sort(data);
        assertTrue(sorter.sorted(data));
    }

    @org.junit.Test
    public void sort02() throws Exception {
        String[] data = {"c", "b", "d"};
        sorter.sort(data);
        assertTrue(sorter.sorted(data));
    }

    @org.junit.Test
    public void sort03() throws Exception {
        String[] data = {};
        sorter.sort(data);
        assertTrue(sorter.sorted(data));
    }

    @org.junit.Test
    public void sorted00() throws Exception {
        String[] data = {"a", "b", "c"};
        assertTrue(sorter.sorted(data));
    }

    @org.junit.Test
    public void sorted01() throws Exception {
        String[] data = {"d", "b", "c"};
        assertFalse(sorter.sorted(data));
    }

    @org.junit.Test
    public void sorted02() throws Exception {
        String[] data = {};
        assertTrue(sorter.sorted(data));
    }

}