package problems;

/**
 * https://www.lalitkundu.com/#h.8z6kgjsj9y5v
 * https://www.youtube.com/watch?v=VZQg5n2jQAM
 * Design a key-value data structure which can support these operations
 * - Increment key k by 1
 * - Decrement key k by 1
 * - Output the key with maximum value
 * - Output the key with minimum value
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution1_1 {
	private Map<Integer, Integer> map = new HashMap<>();
	private List<Set<Integer>> freq = new ArrayList<>();
	private int min = 0;

	public Solution1_1() {
		freq.add(null);
	}

	/**
	 * Time: O(1)
	 */
	public void increase(int k) {
		if (min == 0) {
			min = 1;
		}

		int v = map.getOrDefault(k, 0);
		if (v > 0) {
			freq.get(v).remove(k);

			if (min == v && freq.get(v).size() == 0) {
				min = v + 1;
			}
		}
		map.put(k, ++v);

		int size = freq.size();
		if (v == size) {
			Set<Integer> keys = new HashSet<>();
			keys.add(k);
			freq.add(keys);
		} else {
			freq.get(v).add(k);
		}
	}

	/**
	 * Time: O(n)
	 */
	public void decrease(int k) {
		int v = map.getOrDefault(k, 0);
		if (v == 0) {
			return;
		}
		Set<Integer> keys = freq.get(v);
		keys.remove(k);
		if (v == freq.size() - 1 && keys.size() == 0) {
			freq.remove(v);
		}
		if (min == v) {
			min = v - 1;
		}

		v--;
		if (v == 0) {
			map.remove(k);

			for (int i = 1; i < freq.size(); ++i) {
				if (freq.get(i).size() > 0) {
					min = i;
					break;
				}
			}
			return;
		}

		map.put(k, v);
		freq.get(v).add(k);
	}

	/**
	 * Time: O(1)
	 */
	public int getKeyWithMaxValue() {
		if (freq.size() == 1) {
			return -1;
		}
		return freq.get(freq.size() - 1).iterator().next();
	}

	/**
	 * Time: O(1)
	 */
	public int getKeyWithMinValue() {
		if (min == 0) {
			return -1;
		}
		return freq.get(min).iterator().next();
	}
}
