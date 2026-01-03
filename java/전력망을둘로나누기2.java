import java.util.*;

class Solution {
    List<List<Integer>> grp = new ArrayList<>();
    int N;
    int result = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        N = n;
        for(int i = 0; i <= n; i++) {
            grp.add(new ArrayList<>());
        }
        
        for(int[] wr : wires) {
            int f = wr[0];
            int s = wr[1];
            grp.get(f).add(s);
            grp.get(s).add(f);
        }
        
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited);
        
        return result;
    }
    
    int dfs(int current, boolean[] visited) {
        visited[current] = true;
        int sum = 1; // 자기 자신 포함
        
        for(int next : grp.get(current)) {
            if(!visited[next]) {
                int childSize = dfs(next, visited);
                result = Math.min(result, Math.abs((N - childSize) - childSize));
                sum += childSize;
            }
        }
        
        return sum;
    }
}
