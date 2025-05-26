import java.util.*;

class Solution {
    private int[][] move= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[] blue_d = {};
    int[] red_d = {};
    int min = Integer.MAX_VALUE;
    boolean [][] visited;
    boolean [][] visited_r;
    int[][] myMaze;
        
    public int solution(int[][] maze) {
        int answer = 0;
        int m = maze.length;
        int n = maze[0].length;
        myMaze = maze;
        visited = new boolean[m][n];
        visited_r = new boolean[m][n];
        int[] blue = new int[2];
        int[] red = new int[2];
        blue_d = new int[2];
        red_d = new int[2];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (maze[i][j] == 1) {
                    red[0] = i;
                    red[1] = j;
                }
                if (maze[i][j] == 2) {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (maze[i][j] == 3) {
                    red_d[0] = i;
                    red_d[1] = j;
                } 
                if (maze[i][j] == 4) {
                    blue_d[0] = i;
                    blue_d[1] = j;
                }
            }
        }

        dfs(blue,red,0);
        if(min == Integer.MAX_VALUE) min = 0;
        return min;
    }
    
    private void dfs(int[]b, int[]r, int count) {
        if(Arrays.equals(b,(blue_d)) && Arrays.equals(r,(red_d))) {
            min =  Math.min(min, count); 
            // System.out.println(min);
            return;
        } 

        visited[b[0]][b[1]] = true;
        visited_r[r[0]][r[1]] = true;
        for(int[]mv: move) {
            int nb1 = b[0]+mv[0];
            int nb2 = b[1]+mv[1];
            if(!Arrays.equals(b,(blue_d))) {
                if(!isValid(nb1, nb2)) continue;
            } else {
                nb1 = b[0];
                nb2 = b[1];
            }
            
            for(int[]mv2: move) {
                int nr1 = r[0] + mv2[0];
                int nr2 = r[1] + mv2[1];    
                if(!Arrays.equals(r,(red_d))) {
                    if(!(isValid_r(nr1, nr2))) continue;
                    if((nb1 == nr1 && nb2 == nr2)) continue;
                } else {
                    if((nb1 == r[0] && nb2 == r[1])) continue;
                    nr1 = r[0];
                    nr2 = r[1];
                }

                int[] nb = new int[]{nb1, nb2};
                int[] nr = new int[]{nr1, nr2};
                
                if(!(Arrays.equals(nb, r) && Arrays.equals(nr, b))) {
                    visited[nb1][nb2] = true;
                    visited_r[nr1][nr2] = true;
                    dfs(nb,nr, count+1);
                    if(!b.equals(nb)) visited[nb1][nb2] = false;
                    if(!r.equals(nr)) visited_r[nr1][nr2] = false;
                } 
            }
        }
    }
    
    private boolean isValid(int x, int y) {
        if(0<= x && x < myMaze.length && 0<=y && y<myMaze[0].length) {
            if(!visited[x][y] && myMaze[x][y] !=5) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isValid_r(int x, int y) {
        if(0<= x && x < myMaze.length && 0<=y && y<myMaze[0].length) {
            if(!visited_r[x][y] && myMaze[x][y] !=5) {
                return true;
            }
        }
        return false;
    }
}

// 1 0 5 2
// 0 3 0 0
// 0 4 5 0
// 0 0 0 0
