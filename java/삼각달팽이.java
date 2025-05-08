import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] temp = new int[n][];
        int count = 0;
        for (int i=0;i<n;i++) {
            temp[i] = new int[i+1];
            count += i+1;
        }
        answer = new int[count];
        
        int target = n/2;
        int row_s = 0;
        int row_f = n;
        int col_s = 0;
        int col_f = n;
        int v = 1;
        while(col_s < col_f) {
            for(int i=col_s;i<col_f;i++) {
                if(i == col_f-1 && i != col_s) {
                    for(int j=row_s; j<row_f;j++) { 
                        if(j==row_f-1) {
                            int idx = 0; 
                            for(int k=i;k>col_s;k--) {
                                // System.out.print(k +","+(j-idx) + "," +v +" ");
                                temp[k][(j-idx)] = v;
                                v += 1;
                                idx += 1;
                            }   
                            // System.out.println();
                            break;
                        }
                        temp[i][j] = v;
                        v += 1;
                    }
                    col_s += 2;
                    col_f -= 1;
                    row_s += 1;
                    row_f -= 2;
                    break;
                }
                temp[i][row_s] = v;
                v+=1;
                if(col_s == col_f-1) {
                    col_s += 100;
                }
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
