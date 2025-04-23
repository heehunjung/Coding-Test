import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        for(int[] target: targets){
            q.offer(target);
        }
        
        int lastIdx = q.peek()[1];
        while(!q.isEmpty()) {
            int[] current = q.poll();
            if (q.isEmpty()) {
                answer += 1;
                break;
            }
            int[] next = q.peek();
            
            if (lastIdx > next[0]) {
                continue;
            }
            answer += 1;
            lastIdx = next[1];
        }
        return answer;
    }
}
