import java.util.*;

class Solution {
    Map<Integer,List<int[]>> fareMap = new HashMap<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[] fees = new int[n+1];
        int[] feea = new int[n+1];
        int[] feeb = new int[n+1];
        
        for(int[] fare: fares) {
            fareMap.computeIfAbsent(fare[0], k->new ArrayList<>()).add(new int[]{fare[1],fare[2]});
            fareMap.computeIfAbsent(fare[1], k->new ArrayList<>()).add(new int[]{fare[0],fare[2]});
        }
        dj(s, fees);
        dj(a, feea);
        dj(b, feeb);
        
        for(int i=1;i<=n;i++) {
            if(fees[i]==Integer.MAX_VALUE) 
                continue;
            answer = Math.min(answer, fees[i]+feea[i]+feeb[i]);
        }
        
        
        return answer;
    }
    
    void dj(int start ,int[] fee) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{start, 0});
        Arrays.fill(fee, Integer.MAX_VALUE);
        fee[start] = 0;
        
        while(!pq.isEmpty()) {
            int[] cnt = pq.poll();
            int idx = cnt[0], fare = cnt[1];    
            
            if(fare > fee[idx]) continue;
            
            fee[idx] = fare;
            
            for(int[] near: fareMap.getOrDefault(idx, new ArrayList<>())) {
                int nextFee = near[1]+fare;
                if(nextFee < fee[near[0]]) {
                    fee[near[0]] = nextFee; // queue에 넣을 때 업데이트 
                    pq.offer(new int[]{near[0], nextFee});
                }
            }
        }
    } 
}
