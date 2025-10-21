import java.util.*;

class Solution {
    int[][] mvs = new int[][]{{0,0},{0,1},{1,0},{1,1}};
    String[][] myboard;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int idx = 0;
        myboard = new String[m][n];
        for(String bd: board) myboard[idx++] = bd.split("");
        boolean isContinue = true;
        List<int[]> pangs = new ArrayList<>();
        
        while(isContinue) {
            isContinue = false;
            
            // pang 위치 찾기
            for(int i=m-1;i>=0;i--) {
                for(int j=0;j<n;j++) {
                    if(check(i,j) && !myboard[i][j].equals("0")) {
                        isContinue = true;
                        pangs.add(new int[]{i,j});
                    }
                }
            }
            
            // do pang
            for(int[] pg: pangs) {
                for(int[] mv: mvs) {
                    myboard[pg[0]+mv[0]][pg[1]+mv[1]] = "0";
                }
            }
            
            // down
            for(int i=m-2;i>=0;i--) {
                for(int j=0;j<n;j++) {
                    int nx=i+1;
                    int ny=j;
                    if(nx<m && !myboard[i][j].equals("0") && myboard[nx][ny].equals("0")) {
                        while(true) {
                            if(nx >= m) break;
                            if(myboard[nx][ny].equals("0")) {
                                myboard[nx][ny] = myboard[nx-1][ny];
                                myboard[nx-1][ny] = "0";
                            } else {
                                break;
                            }
                            nx++;
                        }
                    }
                }
            }
            pangs = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(myboard[i][j].equals("0")) answer++;
                // System.out.print(myboard[i][j]);
            }
            // System.out.println();
        }
        return answer;
    }
    
    boolean check(int x,int y) {
        int m = myboard.length;
        int n = myboard[0].length;
        String cnt = myboard[x][y];
        for(int[] mv: mvs) {
            int nx = x+mv[0];
            int ny = y+mv[1];
            if(0<=nx && nx<m && 0<=ny && ny<n) {
                if(!myboard[x][y].equals(myboard[nx][ny])) return false;
            } else {
                return false;
            }
        }
        return true;
    }
    
}
