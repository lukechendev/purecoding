package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Solution1_2 {

	// The map of key, frequency
	private Map<Integer, Integer> keyMap = new HashMap<Integer, Integer>();

	// The map of frequency, set of keys
	private Map<Integer, Set<Integer>> freqMap = new HashMap<>();

	// The list of existing frequencies in order
	private LinkedList<Integer> freq = new LinkedList<Integer>();

	// The map of frequency, and its pointer in the list
	private Map<Integer, ListIterator<Integer>> freqIterMap = new HashMap<>();

	/**
	 * Time: O(1)
	 */
	public void increase(int k) {
		int v = keyMap.getOrDefault(k, 0);

		if (v == 0) {
			// A new key
			keyMap.put(k, 1);

			// Find the pointer for freq 1
			if (freq.isEmpty()) {
				// Empty freq list
				freq.add(1);

				ListIterator<Integer> cur = freq.listIterator();
				freqIterMap.put(1, cur);

				Set<Integer> keys = freqMap.getOrDefault(1, new HashSet<>());
				keys.add(k);
				freqMap.put(1, keys);
			} else if (freq.getFirst() == 1) {
				// Existing pointer for freq 1
				freqMap.get(1).add(k);
			} else {
				// No pointer for freq 1
				freq.addFirst(1);

				ListIterator<Integer> cur = freq.listIterator();
				freqIterMap.put(1, cur);

				Set<Integer> keys = freqMap.getOrDefault(1, new HashSet<>());
				keys.add(k);
				freqMap.put(1, keys);
			}

			return;
		}

		// An existing key
		keyMap.put(k, v + 1);

		ListIterator<Integer> cur = freqIterMap.get(v);
		int curIndex = cur.nextIndex();
		int nextVIndex = curIndex + 1;

		Set<Integer> keys = freqMap.get(v);
		keys.remove(k);
		if (keys.isEmpty()) {
			freqMap.remove(v);

			// fix the prev
			freqIterMap.remove(v);
			freq.remove(curIndex);
			nextVIndex = curIndex;
		}

		// fix the new current freq
		if (nextVIndex < freq.size()) {
			int nextV = freq.get(nextVIndex);

			if (nextV == v + 1) {
				// an existing next freq
				Set<Integer> nextKeys = freqMap.get(nextV);
				nextKeys.add(k);
			} else {
				// a new next freq
				Set<Integer> nextKeys = new HashSet<>();
				nextKeys.add(k);
				freqMap.put(v + 1, nextKeys);

				// Problem in the below two lines, if adding a new item in the middle of freq,
				// the original last iterator in the map still has the old nextIndex
				// failed case:
				// s.increase(1);

				// s.increase(2);
				// s.increase(2);
				// s.increase(2);

				// s.increase(3);
				// s.increase(3); // causing wrong nextIndex

				freq.add(nextVIndex, v + 1);
				freqIterMap.put(v + 1, freq.listIterator(nextVIndex));
			}
		} else {
			// a new last freq
			Set<Integer> lastKeys = new HashSet<>();
			lastKeys.add(k);
			freqMap.put(v + 1, lastKeys);

			freq.add(v + 1);
			freqIterMap.put(v + 1, freq.listIterator(freq.size() - 1));
		}
	}

	/**
	 * Time: O(1)
	 */
	public void decrease(int k) {
	}

	/**
	 * Time: O(1)
	 */
	public int getKeyWithMaxValue() {
		if (freq.isEmpty()) {
			return -1;
		}

		return freqMap.get(freq.getLast()).iterator().next();
	}

	/**
	 * Time: O(1)
	 */
	public int getKeyWithMinValue() {
		if (freq.isEmpty()) {
			return -1;
		}

		return freqMap.get(freq.getFirst()).iterator().next();
	}
}
