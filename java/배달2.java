import java.util.*;

class Solution {
    int[] dp; 
    Map<Integer, List<int[]>> map = new HashMap<>();
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int[]rd: road) {
            List<int[]> li = map.computeIfAbsent(rd[0], k->new ArrayList<>());
            List<int[]> li2 = map.computeIfAbsent(rd[1], k->new ArrayList<>());
            
            li.add(new int[]{rd[1], rd[2]});
            li2.add(new int[]{rd[0], rd[2]});
        }    
        dj();
        for(int i=1;i<dp.length;i++) {
            if(dp[i] <= K) {
                // System.out.println(i + ", " + dp[i]);
                answer++;
            }
        }
        return answer; 
    }
    
    void dj() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{1,0});
        boolean[] visited = new boolean[dp.length];
        
        while(!pq.isEmpty()) {
            int cnt = pq.poll()[0];
            visited[cnt] = true;
            
            for(int[] nexts: map.get(cnt)) {
                int n = nexts[0];
                int v = nexts[1];
                    
                if(dp[n] > dp[cnt] + v && !visited[n]) {
                    dp[n] = dp[cnt] + v;
                    
                    pq.add(new int[]{n,dp[n]});  
                }
            }
        }
    }
}
