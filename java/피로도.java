import java.util.*;

class Solution {
    int maxK = -1; 
    int maxD;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        maxD = dungeons.length;
        visited = new boolean[maxD];
        
        for(int i=0; i<maxD;i++) {
            visited[i] = true;
            dfs(i, 0, k, dungeons);
            visited[i] = false;
            if(maxK == maxD) break;
        } 
        return maxK;
    }
    
    void dfs(int cnt, int count, int k, int[][] dungeons) {
        int minP = dungeons[cnt][0];
        if(minP > k) {
            maxK =Math.max(count, maxK);
            return;
        } 
        if(count+1 == maxD) {
            maxK = maxD;
            return;
        }
        k -= dungeons[cnt][1];
        for(int i=0;i<maxD;i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, count+1, k, dungeons);
                visited[i] = false;
            }
        }
    }
}
