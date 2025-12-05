import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> results  = new HashMap<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        for(int[]rd: roads) {
            int f = rd[0], s = rd[1];
            map.computeIfAbsent(f, k->new ArrayList<>()).add(s);
            map.computeIfAbsent(s, k->new ArrayList<>()).add(f);
        }
        
        boolean[] visited = new boolean[n+1];
        dj(destination, visited);
        
        int idx=0;
        for(int sc: sources) 
            answer[idx++] = results.getOrDefault(sc, -1);
        
        
        return answer;
    }
    
    void dj(int cnt ,boolean[] visited) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{cnt, 0}); //cnt, value
        visited[cnt] = true;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int region = now[0];
            int time = now[1];
            
            results.put(region, time);
            for(int near: map.getOrDefault(region, new ArrayList<>())) 
                if(!visited[near]) {
                    pq.add(new int[]{near, time+1});
                    visited[near] =   true;
                }
        }
    }
}
