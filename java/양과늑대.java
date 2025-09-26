import java.util.*;

class Solution {
    int[] myinfo;
    int[][] myedges;
    boolean[] visited;
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        myinfo = info;
        myedges = edges;
        visited = new boolean[info.length];
        
        visited[0] = true;
        dfs(1,0);
        return answer;
    }
    
    void dfs(int s, int w) {
        if(s > w) answer = Math.max(answer, s);
        else return;
        for(int[]edge: myedges) {
            int ff = edge[0];
            int ss = edge[1];
            
            if(visited[ff] && !visited[ss]) {
                visited[ss] = true;
                if(myinfo[ss]==1) dfs(s,w+1);
                else dfs(s+1, w);
                visited[ss] = false;
            }
        }
        
    }
}
