import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int v: tangerine) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        
        while(k > 0) {
            k -= pq.poll();
            answer++;
        }
        
        return answer;
    }
}
