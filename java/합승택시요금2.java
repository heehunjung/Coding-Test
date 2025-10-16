import java.util.*;

class Solution {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    int nn;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        nn = n;
        for(int[] fare: fares) {
            graph.computeIfAbsent(fare[0], k -> new ArrayList<>()).add(new int[]{fare[1],fare[2]});
            graph.computeIfAbsent(fare[1], k -> new ArrayList<>()).add(new int[]{fare[0],fare[2]});
        }     
        
        int[] total = dj(s);
        for(int i=1;i<=n;i++) {
            int[] cntg = dj(i);
            int toA = cntg[a];
            int toB = cntg[b];

            answer = Math.min(toA + toB + total[i], answer);
        }
        return answer;
    }
    
    int[] dj(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));        
        pq.offer(new int[]{s, 0});
        boolean[] visited = new boolean[nn+1];
        int[] val = new int[nn+1];
        Arrays.fill(val, Integer.MAX_VALUE);
        val[s] = 0;
        
        while(!pq.isEmpty()) {
            int[] cnt = pq.poll();
            if(visited[cnt[0]]) continue;
            visited[cnt[0]] = true;
            
            for(int[] nx: graph.getOrDefault(cnt[0], Collections.emptyList())) {
                if(val[nx[0]] > val[cnt[0]] + nx[1]) {
                    val[nx[0]] = val[cnt[0]] + nx[1];
                    pq.offer(new int[]{nx[0], val[nx[0]]});
                }
            }
        }
        
        return val;
    }
}
