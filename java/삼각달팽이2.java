import java.util.*;

class Solution {
    private int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        int col_s = 0;
        int col_f = n-1;
        int row_s = 0;
        int row_f = n-1;
        
        int[] current= new int[]{0,0};
        int[] answer = {};
        int[][] temp = new int[n][];
        int count = 0;
        for (int i=0;i<n;i++) {
            temp[i] = new int[i+1];
            count += i+1;
        }
        answer = new int[count];
        
        int moveIdx = 0;
        int value = 1;
        while (true) {
            int[] mv = moves[moveIdx];
            // System.out.println(current[0] +","+ current[1] + ": " + value);
            temp[current[0]][current[1]] = value;
            current[0] += mv[0];
            current[1] += mv[1];
            value +=1;
            if (value > count) {
                break;
            }
            if (col_s <= current[0] && current[0] <= col_f && row_s <= current[1] && current[1] <= row_f) {
                if (current[0] == col_s  && current[1] == row_s) {//temp[current[0]][current[1]] = value;
                    col_s += 2;
                    col_f -= 1;
                    row_s += 1;
                    row_f -= 2;
                    current[0] = col_s;
                    current[1] = row_s;
                    moveIdx = (moveIdx + 1) % 3;
                    System.out.println(col_s  + "," + col_f);
                }
            } else {
                current[0] -= mv[0];
                current[1] -= mv[1];
                // System.out.println(current[0] + "," + current[1] + ": " + moveIdx);
                moveIdx = (moveIdx + 1) % 3;
                value -= 1;
            }
        }
        
        int index = 0;
        for(int[]tp: temp) {
            for(int t:tp) {
                answer[index] = t;
                index += 1;
            }
        }
        return answer;
    }
}
