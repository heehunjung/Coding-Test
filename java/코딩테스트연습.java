import java.util.*;

class Solution {

    public int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        int max_al = -1;
        int max_cop = -1;

        for(int[] prob: problems) {
            max_al = Math.max(max_al, prob[0]);
            max_cop = Math.max(max_cop, prob[1]);
        }
        alp = Math.min(alp, max_al);
        cop = Math.min(cop, max_cop);
        int[][] dp = new int[max_al+1][max_cop+1]; //alp, cop
        for(int[] d: dp) Arrays.fill(d, Integer.MAX_VALUE);
        dp[alp][cop] = 0;

        for(int i=alp;i<=max_al;i++) {
            for(int j=cop;j<=max_cop;j++) {
                if(i==max_al && j==max_cop) break;
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                int current = dp[i][j];
                // al+1
                if (i+1<=max_al) dp[i+1][j] = Math.min(dp[i+1][j], current+1); 
                // co+1
                if (j+1<=max_cop) dp[i][j+1] = Math.min(dp[i][j+1], current+1);
                
                for(int[] prob: problems) {
                    int al = prob[0];
                    int co = prob[1];

                    if(al<=i && co<=j) {
                        int ni = Math.min(max_al, i+prob[2]);
                        int nj = Math.min(max_cop, j+prob[3]);
                        dp[ni][nj] = Math.min(dp[ni][nj], current+prob[4]);
                    }
                }
            }
        }
        
        return dp[max_al][max_cop];
    }
}
