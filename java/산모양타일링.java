import java.util.*;

class Solution {
    boolean[] visited;
    int[] dp;
    int answer = 0;
    public int solution(int n, int[] tops) {
        visited = new boolean[n+1];
        dp = new int[2*n+1];
        dp[0] = 1;
        if(tops[0]==1) dp[1] = 3;
        else dp[1] = 2;
        fillDp(1, tops, dp);
        return dp[dp.length-1];
    }
    
    void fillDp(int idx, int[] tops, int[] dp) {
        if(idx == dp.length-1) return;
        
        // top이 있는 경우 
        if((idx+1)%2!=0 && tops[(idx)/2]==1) {
            dp[idx+1] = (dp[idx]*2 + dp[idx-1]) % 10007;  
        } else {
            dp[idx+1] = (dp[idx] + dp[idx-1]) % 10007;
        }
        
        fillDp(idx+1, tops, dp);
    }
}
