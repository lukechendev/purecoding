/*
1311. Get Watched Videos by Your Friends

User Accepted:1579
User Tried:2204
Total Accepted:1611
Total Submissions:4585
Difficulty:Medium
There are n people, each person has a unique id between 0 and n-1. Given the arrays watchedVideos and friends, where watchedVideos[i] and friends[i] contain the list of watched videos and the list of friends respectively for the person with id = i.

Level 1 of videos are all watched videos by your friends, level 2 of videos are all watched videos by the friends of your friends and so on. In general, the level k of videos are all watched videos by people with the shortest path equal to k with you. Given your id and the level of videos, return the list of videos ordered by their frequencies (increasing). For videos with the same frequency order them alphabetically from least to greatest. 

 

Example 1:



Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
Output: ["B","C"] 
Explanation: 
You have id = 0 (green color in the figure) and your friends are (yellow color in the figure):
Person with id = 1 -> watchedVideos = ["C"] 
Person with id = 2 -> watchedVideos = ["B","C"] 
The frequencies of watchedVideos by your friends are: 
B -> 1 
C -> 2
Example 2:



Input: watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
Output: ["D"]
Explanation: 
You have id = 0 (green color in the figure) and the only friend of your friends is the person with id = 3 (yellow color in the figure).
 

Constraints:

n == watchedVideos.length == friends.length
2 <= n <= 100
1 <= watchedVideos[i].length <= 100
1 <= watchedVideos[i][j].length <= 8
0 <= friends[i].length < n
0 <= friends[i][j] < n
0 <= id < n
1 <= level < n
if friends[i] contains j, then friends[j] contains i
*/

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.Collections;
import javafx.util.Pair;

public class Solution {

    public List<String> watchedVideosByFriends_leetcode2(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        int [] levels = new int [n];
        Arrays.fill(levels, -1);
        List<Integer> frontier = new ArrayList<>();
        frontier.add(id);
        levels[id] = 0;
        int nsteps = 0;
        while (!frontier.isEmpty()) {
            if (level-- == 0) break;
            List<Integer> next_level = new ArrayList<>();
            ++nsteps;
            for(int u : frontier) {
                for(int v : friends[u]) {
                    if (levels[v] == -1) {
                        levels[v] = nsteps;
                        next_level.add(v);
                    }
                }
            }
            frontier = next_level;
        }
        Map<String, Integer> counter = new HashMap<>();
        for(int u : frontier) {
            for(String v : watchedVideos.get(u)) {
                counter.put(v, counter.getOrDefault(v, 0) + 1);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String v : counter.keySet()) {
            ans.add(v);
        }
        Comparator<String> comp = (String a, String b) -> (counter.get(a) == counter.get(b) ? a.compareTo(b) : (counter.get(a) - counter.get(b)));
        Collections.sort(ans, comp);
        return ans; 
    }

    // from leedcode but doesn't count for frequency so Test 3 will fail
    public List<String> watchedVideosByFriends_leedcode(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
	boolean[] visited = new boolean[friends.length];
	Arrays.fill(visited, false);
	Queue<Integer> q = new LinkedList<>();
	q.add(id);
	visited[id] = true;
	for (int i = 0; i < level; i++) {
	    if (q.isEmpty()) break;
	    int size = q.size();
	    for (int j = 0; j < size; j++) {
		int cur = q.poll();
		for (int f : friends[cur]) {
		    if (!visited[f]) {
			visited[f] = true;
			q.add(f);
		    }
		}
	    }
	}
	Set<String> hs = new HashSet<>();
	while (!q.isEmpty()) {
	    int cur = q.poll();
	    for (String s : watchedVideos.get(cur)) hs.add(s);
	}
	List<String> res = new ArrayList<>(hs);
	Collections.sort(res);
	return res;
    }

    public List<String> watchedVideosByFriends2(List<List<String>> watchedVideos, int[][] friends, int id, int level) {        
        // Generate friends list in the given level
        boolean[] visited = new boolean[friends.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(id);
        visited[id] = true;
        for (int i = 0; i < level; ++i) {
            // check if this level is empty
            if (queue.isEmpty()) {
                break;
            }
            for (int j = queue.size() - 1; j >= 0; --j) {
                int cur = queue.poll();
                for (int f : friends[cur]) {
                    if (!visited[f]) {
                        queue.add(f);
                        visited[f] = true;
                    }
                }
            }
        }

        // Generate the video frequency table
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<String> watched = watchedVideos.get(cur);
            Iterator<String> itr = watched.iterator();
            while (itr.hasNext()) {
                String video = itr.next();
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }
        
        // Sort and generate the wathced list
        List<String> videos = new ArrayList<String>(freq.keySet());
        videos.sort(new Comparator<String>() {
          public int compare(final String p1, final String p2) {
            int f1 = freq.get(p1);
            int f2 = freq.get(p2);
            if (f1 != f2) {
              return f1 - f2;
            } else {
              return p1.compareTo(p2);
            }
          }
        });

        return videos;
    }

    private void findFriends(int[][] friends, int id, int level, HashSet<Integer> fset, HashSet<Integer> prevfset) {
        if (level <= 0) {
            return;
        }

        if (level == 1) {
            int[] theFriends = friends[id];
            for (int i = theFriends.length - 1; i >= 0; --i) {
                if (prevfset.contains(theFriends[i])) {
                    continue;
                }
                
                fset.add(theFriends[i]);
            }
        } else {
            prevfset.add(id);
            int[] theFriends = friends[id];
            for (int i = theFriends.length - 1; i >= 0; --i) {
                prevfset.add(theFriends[i]);
            }
            
            for (int i = theFriends.length - 1; i >= 0; --i) {
                findFriends(friends, theFriends[i], level - 1, fset, prevfset);
            }
        }
    }
    
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {        
        HashSet<Integer> fset = new HashSet<Integer>();
        HashSet<Integer> prevfset = new HashSet<Integer>();
        findFriends(friends, id, level, fset, prevfset);
        
        // find watched videos
        HashMap<String, Integer> wMap = new HashMap<String, Integer>();
        Iterator<Integer> itrw = fset.iterator();
        while (itrw.hasNext()) {
            int fId = itrw.next();
            List<String> videos = watchedVideos.get(fId);
            for (int i = videos.size() - 1; i >= 0; --i) {
                String video = videos.get(i);
                Integer freq = wMap.get(video);
                if (freq != null) {
                    wMap.put(video, freq+1);
                } else {
                    wMap.put(video, 1);
                }
            }
        }
        
        // Sort and generate the wathced list
        TreeMap<Pair<Integer, String>, String> sortedWMap = new TreeMap<Pair<Integer, String>, String>(new Comparator<Pair<Integer, String>>(){
            public int compare(final Pair<Integer, String> p1, final Pair<Integer, String> p2) {
                if (p1.getKey() > p2.getKey()) {
                    return 1;
                } else if (p1.getKey() < p2.getKey()) {
                    return -1;
                } else {
                    return p1.getValue().compareTo(p2.getValue());
                }
            }
        });
        Iterator<Map.Entry<String, Integer>> itre = wMap.entrySet().iterator();
        while (itre.hasNext()) {
            Map.Entry pair = itre.next();
            sortedWMap.put(new Pair<Integer, String>((Integer) pair.getValue(), (String) pair.getKey()), (String) pair.getKey());
        }
        
        // Generate the list
        return new ArrayList<String>(sortedWMap.values());
    }

    public static void test(List<List<String>> watchedVideos, int[][] friends, int id, int level, List<String> expected) {
        Solution s = new Solution();
        long ts = System.nanoTime();
        List<String> ret = s.watchedVideosByFriends_leetcode2(watchedVideos, friends, id, level);
        System.out.format("%,d" + " ns%n", System.nanoTime() - ts);
        System.out.println("Result: \n" + ret);
        if (ret.equals(expected)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed - Expected: \n" + expected);
        }
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        // Test 1
        List<List<String>> watchedVideos = new ArrayList<List<String>>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("C"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("D"));
        
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        List<String> expected = Arrays.asList("B", "C");
        test(watchedVideos, friends, 0, 1, expected);

        // Test 2
        expected = Arrays.asList("D");
        test(watchedVideos, friends, 0, 2, expected);

        // Test 3
        watchedVideos = new ArrayList<List<String>>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("B"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("D"));
        
        int[][] friends3 = {{1,2},{0,3},{0,3},{1,2}};
        expected = Arrays.asList("C", "B");
        test(watchedVideos, friends3, 0, 1, expected);

        // Test 4
        watchedVideos = new ArrayList<List<String>>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("C", "B"));
        watchedVideos.add(Arrays.asList("C", "B"));
        watchedVideos.add(Arrays.asList("D"));
        
        int[][] friends4 = {{1,2},{0,3},{0,3},{1,2}};
        expected = Arrays.asList("B", "C");
        test(watchedVideos, friends4, 0, 1, expected);

        // Test 5
        watchedVideos = new ArrayList<List<String>>();
        watchedVideos.add(Arrays.asList("A", "B"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("B", "C"));
        watchedVideos.add(Arrays.asList("D"));
        
        int[][] friends5 = {{1,2},{0,3},{0,3},{1,2}};
        expected = Arrays.asList("B", "C");
        test(watchedVideos, friends5, 0, 1, expected);
    }
}
