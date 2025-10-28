import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int idx = 0;
        int cnt = truck_weights[idx];
        
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{truck_weights[idx++], answer});
        List<Integer> arrived = new ArrayList<>();
        
        while(true) {
            boolean isPop = false;
            if(!q.isEmpty()){
                int[] truck = q.peek();
                if(answer-truck[1]==bridge_length) {
                    q.poll();
                    cnt -= truck[0];
                    arrived.add(truck[0]);
                    isPop = true;
                }
            }
            
            if(arrived.size()==truck_weights.length) break;
            
            if(idx < truck_weights.length){
                int next = truck_weights[idx];
                if(next + cnt <= weight) {
                    if(!q.isEmpty()) {
                        if(q.peek()[1] == answer) {
                            answer++;
                            continue;
                        }
                    }
                    q.offer(new int[]{next, answer});
                    cnt += next;
                    idx++;
                }
                 else {
                    if(!isPop){
                        answer = bridge_length + q.peek()[1];
                        continue;
                    }
                }
            } else {
                if(!isPop){
                    answer = bridge_length + q.peek()[1];
                    continue;
                }
            }
            
            answer++;
        }   
        return answer;
    }
}
