import java.util.*;

class Solution {
    int[][] dval;
    int[] dp;
    List<List<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // init
        dval = new int[N+1][N+1];
        dp = new int[N+1];
        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        visited = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // make graph
        for(int[] rd: road) {
            int x = rd[0], y = rd[1], v = rd[2];
            graph.get(x).add(y);
            graph.get(y).add(x);
            if (dval[x][y] == 0 || dval[x][y] > v) {
                dval[x][y] = v;
                dval[y][x] = v;
            }
        }
        
        // do 다익
        dijkstra(1);
        
        // <= K
        for(int v: dp) {
            if (v <= K) answer +=1;
        }
        
        return answer;
    }
    
    void dijkstra(int current) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{current, 0});
        
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            visited[now[0]] = true;
            for(int x: graph.get(now[0])) {
                if(!visited[x] && dp[now[0]]+dval[now[0]][x] < dp[x]) {
                    dp[x] = dp[now[0]]+dval[now[0]][x];
                    pq.add(new int[]{x, dp[x]});
                }
            }
        }
    }
}
