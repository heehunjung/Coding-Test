import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> li = new ArrayList<>();

        long[] start = new long[2];
        long[] fin = new long[2];
        start[0] = left / n;
        start[1] = left % n;
        fin[0] = right / n;
        fin[1] = right % n;
        
        for(long i=start[0];i<=fin[0];i++) {
            long min = 0;
            long max = n-1;
            if (i==start[0]) {
                min = start[1];
            } 
            if (i==fin[0]) {
                max = fin[1];
            }

            for(long j=min;j<=max;j++) {
                li.add((int)Math.max(i,j) + 1);
            }
        }
        int[] answer = li.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
