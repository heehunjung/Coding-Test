import java.util.*;

class Solution {
    List<List<Integer>> graph;
    int[][] dp;

    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList<>();
        dp = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] lh : lighthouse) {
            graph.get(lh[0]).add(lh[1]);
            graph.get(lh[1]).add(lh[0]);
        }

        dfs(1, 0);

        return Math.min(dp[1][0], dp[1][1]);
    }

    void dfs(int cur, int parent) {
        dp[cur][0] = 0; 
        dp[cur][1] = 1;

        for (int child : graph.get(cur)) {
            if (child == parent) continue;

            dfs(child, cur); 

            dp[cur][0] += dp[child][1];
            dp[cur][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
