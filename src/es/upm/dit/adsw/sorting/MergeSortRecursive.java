
package es.upm.dit.adsw.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Mergesort - Recursive version
 *
 * Created by jpuente on 20/03/2020.
 */
public class MergeSortRecursive
        extends StringSorter {

    @Override
	public void sort(String[] data) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, data);
		sort(list);
		list.toArray(data);
	}

	private void sort(List<String> list) {
		// dividir
		if (list.size() < 2)
			return;
		int m = list.size() / 2;
		List<String> left = new ArrayList<>(list.subList(0, m));
		List<String> right = new ArrayList<>(list.subList(m, list.size()));
		// ordenar las dos listas
		sort(left);
		sort(right);
		// mezclar las dos listas
		list.clear();
		while (left.size() > 0 && right.size() > 0) {
			String sl = left.get(0);
			String sr = right.get(0);
			if (sl.compareTo(sr) < 0)
				list.add(left.remove(0));
			else
				list.add(right.remove(0));
		}
		while (left.size() > 0)
			list.add(left.remove(0));
		while (right.size() > 0)
			list.add(right.remove(0));
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

        StringSorter sorter = new MergeSortRecursive();
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
        if (!sorter.sorted(data, 0, data.length))
            System.out.println("ERROR");
    }
}

