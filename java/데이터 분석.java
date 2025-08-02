import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        
        final int sort_idx;
        int limit;
        if (sort_by.equals("code")) sort_idx = 0;
        else if (sort_by.equals("date")) sort_idx = 1;
        else if (sort_by.equals("maximum")) sort_idx = 2;
        else sort_idx = 3;

        if (ext.equals("code")) limit = 0;
        else if (ext.equals("date")) limit = 1;
        else if (ext.equals("maximum")) limit = 2;
        else limit = 3;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[sort_idx]-b[sort_idx]);
        for(int[]dt: data) {
            System.out.println(dt[limit] + " : " + val_ext);
            if(dt[limit] < val_ext) pq.add(dt);
        }
        answer = new int[pq.size()][];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx] = pq.poll();
            idx++;
        }
        return answer;
    }
}
