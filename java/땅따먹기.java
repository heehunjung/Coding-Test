import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = -1;
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
            if(i==0) {
                for(int j=0;j<4;j++) {
                    dp[0][j] = land[0][j];
                }
            }
        }
        
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<4;j++) {
                for(int k=0;k<4;k++) {
                    if(j!=k) {
                        dp[i+1][k] = Math.max(dp[i+1][k], land[i+1][k]+dp[i][j]);
                    }
                }
            }
        }
        

        for(int i=0;i<4;i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}
