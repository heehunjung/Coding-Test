import java.util.*;

class Solution {
    int answer = 0;
    List<List<Integer>> graph;
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] lh : lighthouse) {
            graph.get(lh[0]).add(lh[1]);
            graph.get(lh[1]).add(lh[0]);
        }


        dfs(1, 0);

        return answer;
    }

    int dfs(int current, int parent) {
        int result = 0; 
        
        for (int child : graph.get(current)) {
            if (child == parent) continue; 

            int childStatus = dfs(child, current);
            if (childStatus == 0) {
                result = 1; 
            }
        }

        if (result == 1) {
            answer++;
        }
        
        return result;
    }
}
