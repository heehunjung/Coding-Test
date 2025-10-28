import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int idx = 0;
        int cnt = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        List<Integer> arrived = new ArrayList<>();
        
        while(true) {
            if(!q.isEmpty()){
                int[] truck = q.peek();
                if(answer-truck[1]==bridge_length) {
                    q.poll();
                    cnt -= truck[0];
                    arrived.add(truck[0]);
                }
            }
            
            if(arrived.size()==truck_weights.length) break;
            
            if(idx < truck_weights.length){
                int next = truck_weights[idx];
                if(next + cnt <= weight) {
                    q.offer(new int[]{next, answer});
                    cnt += next;
                    idx++;
                }
                 else {
                    answer = bridge_length + q.peek()[1];
                    continue;
                }
            } else {
                    answer = bridge_length + q.peek()[1];
                    continue;
            }
            
            answer++;
        }   
        return answer;
    }
}
