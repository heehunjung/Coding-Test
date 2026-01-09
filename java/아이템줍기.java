import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] box;
    int[][] mvs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int maxX = 0;
        int maxY = 0; 

        for(int[] rec: rectangle) {
            maxX = Math.max(maxX, rec[2] * 2);
            maxY = Math.max(maxY, rec[3] * 2);
        }
        
        visited = new boolean[maxX + 2][maxY + 2];
        box = new int[maxX + 2][maxY + 2];
        
        for(int[] rec: rectangle) {
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int fx = rec[2] * 2;
            int fy = rec[3] * 2;

            for(int x = sx; x <= fx; x++) {
                for(int y = sy; y <= fy; y++) {
                    box[x][y] = 1;
                }
            }
        }

        for(int[] rec: rectangle) {
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int fx = rec[2] * 2;
            int fy = rec[3] * 2;

            for(int x = sx + 1; x < fx; x++) {
                for(int y = sy + 1; y < fy; y++) {
                    box[x][y] = 0;
                }
            }
        }
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        
        dq.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        while(!dq.isEmpty()) {
            int[] cnt = dq.poll();
            int x = cnt[0];
            int y = cnt[1];
            int count = cnt[2];
            
            if(x == itemX * 2 && y == itemY * 2) {
                return count / 2;
            }
            
            for(int[] mv: mvs) {
                int nx = x + mv[0];
                int ny = y + mv[1];
                
                if(nx >= 0 && nx <= maxX && ny >= 0 && ny <= maxY) {
                    if(box[nx][ny] == 1) { 
                        if(!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            dq.offer(new int[]{nx, ny, count + 1});
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
