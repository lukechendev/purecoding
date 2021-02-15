package problems;

/**
 * https://www.youtube.com/watch?v=VZQg5n2jQAM
 * Design a key-value data structure which can support these operations
 * - Increment key k by 1
 * - Decrement key k by 1
 * - Output the key with maximum value
 * - Output the key with minimum value
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution1 {
	// <k, v>
	Map<Integer, Integer> m1 = new HashMap<>();

	// <v, k>
	TreeMap<Integer, Set<Integer>> m2 = new TreeMap<>();

	public void increase(int k) {
		int v = m1.getOrDefault(k, 0);

		Set<Integer> keys = m2.get(v);
		if (keys != null) {
			keys.remove(k);
			if (keys.size() == 0) {
				m2.remove(v);
			}
		}

		m1.put(k, ++v);

		Set<Integer> newKeys = m2.getOrDefault(v, new HashSet<>());
		newKeys.add(k);
		m2.put(v, newKeys);
	}

	public void decrease(int k) {
		int v = m1.getOrDefault(k, 0);
		if (v == 0) {
			return;
		}

		Set<Integer> keys = m2.get(v);
		keys.remove(k);
		if (keys.size() == 0) {
			m2.remove(v);
		}

		if (--v == 0) {
			m1.remove(k);
			return;
		}

		m1.put(k, v);

		Set<Integer> newKeys = m2.getOrDefault(v, new HashSet<>());
		newKeys.add(k);
		m2.put(v, newKeys);
	}

	public int getKeyWithMaxValue() {
		Map.Entry<Integer, Set<Integer>> last = m2.lastEntry();
		if (last == null || last.getValue().size() == 0) {
			return -1;
		}

		return last.getValue().iterator().next();
	}

	public int getKeyWithMinValue() {
		Map.Entry<Integer, Set<Integer>> first = m2.firstEntry();
		if (first == null || first.getValue().size() == 0) {
			return -1;
		}

		return first.getValue().iterator().next();
	}
}
