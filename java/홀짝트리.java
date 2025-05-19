import java.util.*;

class Solution {
    Map<Integer, List<Integer>> all = new HashMap<>();
    int hz = 0;
    int hz_rev = 0;
    int max = 0;
    boolean[] visited;
    
    public int[] solution(int[] nodes, int[][] edges) {
        
        for(int node: nodes) {
            List<Integer> connect = new ArrayList<>();   
            all.put(node, connect);  
            max = Math.max(max, node);
        }
        visited = new boolean[max+1];
        for(int i=0;i<edges.length;i++) {
            all.get(edges[i][0]).add(edges[i][1]);
            all.get(edges[i][1]).add(edges[i][0]);
        }        
        for(int key: all.keySet()) {
            if(!visited[key]) {
                // 단일 트리
                if(all.get(key).isEmpty()){
                    if (key%2 == 0) hz += 1;
                    else hz_rev += 1;
                    continue;
                }
                bfs(key);
            }
        }
        
        
        return new int[]{hz,hz_rev};
    }
    
    private void bfs(int key) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[key] = true;
        int normal = 0;
        int reverse = 0;
        
        if (key%2 ==0) {
            if (all.get(key).size() % 2 == 0) normal += 1;
            else reverse += 1; 
        } else {
            if (all.get(key).size() % 2 != 0) normal += 1;
            else reverse += 1;
        }
        
        for(int next: all.get(key)) {
            q.offer(next);
        }
        while(!q.isEmpty()) {
            int cnt = q.poll();
            visited[cnt] = true;
            if (cnt % 2 ==0 && (all.get(cnt).size())%2 == 0) normal += 1;
            else if (cnt % 2 !=0 && (all.get(cnt).size())%2 != 0) normal += 1;
            else reverse += 1;
            
            for(int next: all.get(cnt)) {
                if (!visited[next]){ 
                    q.offer(next);
                }
            }
        }

        if(normal == 1) hz += 1;
        if(reverse == 1) hz_rev += 1;
    }
}
