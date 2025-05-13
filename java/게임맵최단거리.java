import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    int[] target = new int[2];
    int[][] moves = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visited;
    int[][] myMaps;
    public int solution(int[][] maps) {
        int answer = 0;
        target[0] = maps.length;
        target[1] = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
        myMaps = maps;
        bfs();
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    } 
    
//     private void dfs(int x, int y, int count) {
//         if (min <= count) {
//             return;
//         }
//         visited[x][y] = true;
        
//         if (x == target[0]-1 && y == target[1]-1) {
//             min = Math.min(min, count);
//             return;
//         }
        
//         for(int[]mv: moves) {
//             int nx = x + mv[0];
//             int ny = y + mv[1];
            
//             if (valid(nx,ny)) {
//                 dfs(nx,ny,count+1);
//                 visited[nx][ny] = false;
//             }
//         }
//     }    
    private void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
        
            if (x==target[0]-1&&y==target[1]-1) {
                min = count;
                break;
            }
            
            for(int[]mv: moves) {
                int nx = x + mv[0];
                int ny = y + mv[1];

                if (valid(nx,ny)) {
                    q.offer(new int[]{nx,ny,count+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }  
    
    private boolean valid(int x,int y) {
        if (0<= x && x < visited.length && 0 <= y && y < visited[0].length) {
            if(!visited[x][y] && myMaps[x][y] == 1) return true;
        }
        return false;
    }
}
