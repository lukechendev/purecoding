public class Test1 {
    public static void main(String[] args) {
        Integer max = Integer.MAX_VALUE;
        System.out.println(max.toString());
    }
}
public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
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