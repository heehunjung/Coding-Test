import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<enemy.length; i++) {
            int v = enemy[i];
            if(n >= v) {
                n -= v;
                pq.offer(v);
                answer++;
                continue;
            }    
            
            if(k > 0) {
                k--;
                answer++;
                if(!pq.isEmpty() && v < pq.peek()) {
                    n += pq.poll();
                    n -= v;
                    pq.offer(v);
                } 
                continue;
            }
            
            break;
        }
        
        return answer;
    }
}
