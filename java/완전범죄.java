import java.util.*;

class Solution {
    private int max;
    private int maxA;
    private int maxB;
    private int min = Integer.MAX_VALUE;
    private Set<String> visited;
    
    public int solution(int[][] info, int n, int m) {
        max = info.length;
        maxA = n;
        maxB = m;
        visited = new HashSet<>();

        dfs(-1, 0, 0, info);        
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    }
    
    private void dfs(int current, int a, int b, int[][] info) {

        String key = current + "," + a + "," + b;
        if (visited.contains(key)) return;
        visited.add(key);
        
        if (a >= min) return;
        
        if (current == max - 1) {
            min = Math.min(a, min);
            return;
        }
        
        if (a + info[current + 1][0] < maxA) {
            dfs(current + 1, a + info[current + 1][0], b, info);
        }
        if (b + info[current + 1][1] < maxB) {
            dfs(current + 1, a, b + info[current + 1][1], info);
        }
    }
}
