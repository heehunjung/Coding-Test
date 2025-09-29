import java.util.*;

class Solution {
    int[][] moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    int[][] myboard;
    int[][][] dp;
    boolean[][] visited;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        myboard = board;
        visited = new boolean[board.length][board[0].length];
        dp = new int[board.length][board[0].length][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        visited[0][0] = true;
        dfs(0,0,0,0);
        
        return answer;
    }
    
    void dfs(int x, int y, int count, int dirt) {
        if(count >= answer) return;
        dp[x][y][dirt] = count;
        if(x == myboard.length-1 && y == myboard[0].length-1) {
            answer = count;
            return;
        }
        
        for(int[] mv: moves) {
            int nx = x+mv[0];
            int ny = y+mv[1];
            
            if(0<= nx && nx < myboard.length && 0 <= ny && ny < myboard[0].length) {
                if(myboard[nx][ny]==0 && !visited[nx][ny]) {
                    int[] cnt = calFee(x,y,nx,ny,dirt);
                    if(dp[nx][ny][cnt[1]] < count+cnt[0]) continue;
                    visited[nx][ny] = true;
                    dfs(nx,ny,count+cnt[0],cnt[1]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    // 1 -> , 2 <- , 3 u, 4 d
    int[] calFee(int x, int y, int nx, int ny, int dirt) {
        int cntdirt = 0;
        if(x == nx) {
            if(ny > y) cntdirt = 1;
            else cntdirt = 2;
        }
        if(y == ny) {
            if(nx > x) cntdirt = 4;
            else cntdirt = 3;
        }
        if(dirt == 0) return new int[]{100, cntdirt};
        if(dirt == cntdirt) return new int[]{100, cntdirt};
        else return new int[]{600, cntdirt};
    }
}
