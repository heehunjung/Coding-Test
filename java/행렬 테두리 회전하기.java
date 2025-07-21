import java.util.*;

class Solution {
    int[][] boards;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        boards = new int[rows][columns];
        
        int count = 1;
        for(int i=0;i<rows;i++) {
            for(int j =0;j<columns;j++) {
                boards[i][j] = count;
                count ++;
            }
        }
        
        answer = new int[queries.length];
        int i =0;
        for(int [] q: queries) {
            answer[i] = move(new int[]{q[0]-1,q[1]-1}, new int[]{q[2]-1,q[3]-1});
            i++;
        }
        
        return answer;
    }
    
    int move(int[] start, int[] end) {
        int x = start[0], y = start[1];

        int x1 = end[0], y1 = end[1];
        
        int min = Integer.MAX_VALUE;
        
        // ->
        int temp = boards[x][y];
        for(int i=y+1; i<=y1; i++) {
            min = Math.min(temp, min);
           int tmp = boards[x][i];
            boards[x][i] = temp;
            temp = tmp;
        }
        
        // rd
        for(int i=x+1;i<=x1;i++) {
             min = Math.min(temp, min);
            int tmp = boards[i][y1];
            boards[i][y1] = temp;
            temp = tmp;
        }
        
        // <-
        for(int i= y1-1;i>=y;i--) {
            min = Math.min(temp, min); 
            int tmp = boards[x1][i];
            boards[x1][i] = temp;
            temp = tmp;
        }
        
        // lu
        for(int i=x1-1;i>=x;i--){
            min = Math.min(temp, min);
            int tmp = boards[i][y];
            boards[i][y] =temp;
            temp = tmp;
        }
        
        return min;
    }
}
