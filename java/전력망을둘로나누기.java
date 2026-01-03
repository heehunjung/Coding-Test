import java.util.*;

class Solution {
    List<List<int[]>> grp = new ArrayList<>();
    int finNum = 1;
    int N;
    int result = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        N = n;
        for(int i=0;i<=n;i++) {
            grp.add(new ArrayList<>());
        }
        if(n%2==0) finNum = 0;
        
        for(int[] wr: wires) {
            int f = wr[0];
            int s = wr[1];
            
            grp.get(f).add(new int[]{s,0});
            grp.get(s).add(new int[]{f,0});
        }
        boolean[] visited = new boolean[n+1];
        visited[1]= true;
        fill(1, visited);
        
        return result;
    }
    
    int fill(int start, boolean[] visited) {
        int toParent = 0;
        for(int[] next: grp.get(start)) {
            if(visited[next[0]]) continue;
            visited[next[0]] = true;
            next[1] = fill(next[0], visited);
            // checking
            result=Math.min(Math.abs(N-2*next[1]), result);
            toParent += next[1];
        }
        
        if(toParent==0) return 1;
        else return toParent+1;
    }
}
