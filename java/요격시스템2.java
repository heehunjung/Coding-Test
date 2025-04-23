import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 마지막 기준으로 정렬
        Arrays.sort(targets, (a, b) -> a[1]-b[1]);
        int idx = targets[0][1];
        
        for(int i=0; i<targets.length; i++) {
            int[] currnet = targets[i];
            // 마지막 경우
            if (i == targets.length-1) {
                answer += 1;
                break;
            }
            int[] next = targets[i+1];
            
            if (idx > next[0]) {
                continue;
            } 
            
            answer += 1;
            idx = next[1];
        }
        
        return answer;
    }
}
