import java.util.*;

class Solution {
    int len;
    public int solution(int n, int[][] results) {
        int answer = 0;
        Map<Integer, List<Integer>> wingrp = new HashMap<>();
        Map<Integer, List<Integer>> losegrp = new HashMap<>();
        len = n;
        // make graph
        for(int[] result: results) {
            int w = result[0], l = result[1];
            if(wingrp.containsKey(w)) wingrp.get(w).add(l);
            else {
                List<Integer> li = new ArrayList<>();
                li.add(l);
                wingrp.put(w,li);
            }
            if(losegrp.containsKey(l)) losegrp.get(l).add(w);
            else {
                List<Integer> li = new ArrayList<>();
                li.add(w);
                losegrp.put(l,li);
            }
        }
        
        for(int i=1;i<=n;i++) {
            int w = bfs(wingrp, i);
            int l = bfs(losegrp, i);
            // System.out.println("w: " + w + " l: " + l);
            if (w+l == n-1) answer++;
        }
        
        return answer;
    }
    
    int bfs(Map<Integer, List<Integer>> map, int current) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(current);
        int result = 0;
        boolean[] visited = new boolean[len+1];
        visited[current] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            result++;
            // System.out.println(now);
            if(!map.containsKey(now)) continue; 
            for(int next: map.get(now)) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }    
        }
        // System.out.println("-");
        return result-1;
    }
}
