import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int len = targets.length;
        int last = targets[0][1];
        for(int i=0; i<len;i++) {
            for(int j=i+1;j<len;j++) {
                int next_front = targets[j][0];
                if(last > next_front) {
                    last = Math.min(last, targets[j][1]);
                } else {
                    last = targets[j][1];
                    i = j-1;
                    break;
                }
                if(j==len-1) i=j;
            }
            answer++;
        }
        return answer;
    }
}
