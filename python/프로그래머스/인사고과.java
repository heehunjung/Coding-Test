import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int a = scores[0][0];
        int b = scores[0][1];
        int total_wanho = a + b;
        
        Arrays.sort(scores,(x,y) -> x[0]==y[0] ? x[1]-y[1]: y[0]-x[0]);
        
        
        int temp = 0;
        for(int[] score : scores) {
            if ( a < score[0] && b < score[1]) {
                return -1;
            }
            
            if (temp <= score[1]) {
                temp = score[1];
                if (score[0]+score[1] > total_wanho){
                    answer++;
                }
            }
            
            // if (score[0]+score[1] == total_wanho) {
            //     return answer;
            // }
        }

        return answer;
    }
}