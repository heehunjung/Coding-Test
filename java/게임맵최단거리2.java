import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    int[][] myMap;
    int[][] mvs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(int[][] maps) {
        myMap = maps;
        boolean[][] visited = new boolean[myMap.length][myMap[0].length];
        
        // visited[0][0] = true;
        // dfs(new int[]{0,0}, visited, 1);
        bfs(visited);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    void bfs(boolean[][] visited) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!dq.isEmpty()) {
            int[] cnt = dq.poll();
            int count = cnt[2]+1;
            for(int[] mv: mvs) {
                int nx = cnt[0] + mv[0];
                int ny = cnt[1] + mv[1];
                
                if(0<=nx&&nx<myMap.length&&0<=ny&&ny<myMap[0].length) {
                    if(myMap[nx][ny]==1) {
                        if(nx == myMap.length-1 && ny == myMap[0].length-1) {
                            answer = Math.min(count, answer);
                        }
                        if(!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            dq.offer(new int[]{nx,ny,count});
                        }
                    }
                }   
            }
        }
    }
    
    void dfs(int[] cnt, boolean[][] visited ,int count) {
        if(answer <= count) return;
        if(cnt[0] == myMap.length-1 && cnt[1] == myMap[0].length-1) {
            answer = count;
            return;
        }
        
        for(int[] mv: mvs) {
            int nx = cnt[0] + mv[0];
            int ny = cnt[1] + mv[1];
            
            if(0<=nx&&nx<myMap.length&&0<=ny&&ny<myMap[0].length) {
                if(myMap[nx][ny]==1) {
                    if(!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dfs(new int[]{nx,ny}, visited, count+1);
                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }
}
