import java.util.*;
    
class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer += bfs(numbers[0], target, numbers);
        answer += bfs(-1*numbers[0], target, numbers);
        return answer;
    }
    
    public int bfs(int start,int target ,int[] numbers) {
        int result = 0;
        int length = numbers.length;
        Queue<int[] >q = new ArrayDeque();
        q.offer(new int[]{start,0});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            if (current[0] == target && current[1] == length-1) {
                result += 1;
            }
            if (current[1] < length-1) {
                q.offer(new int[]{current[0] + numbers[current[1]+1],current[1]+1});
                q.offer(new int[]{current[0] - numbers[current[1]+1],current[1]+1});
            }
        }
        
        return result;
     }
}
