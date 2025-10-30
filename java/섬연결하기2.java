import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer=0;
        int[] parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        Arrays.sort(costs, (a,b)->Integer.compare(a[2], b[2]));
        
        for(int[] cost: costs) {
            int f =cost[0], s=cost[1], v=cost[2];
            int ff = Math.min(f,s);
            int ss = Math.max(f,s);
            if(parent[ff] == parent[ss]) continue;
            int cnt =parent[ss];
            for(int i=0;i<n;i++) if(parent[i]==cnt) parent[i] = parent[ff];
            answer += v;
            
            // for(int i=0;i<n;i++) System.out.print(parent[i] + " ");
            // System.out.println();
            boolean isFin = true;
            int pp = parent[0];
            for(int p: parent) {
                if(pp != p) {
                    isFin = false;
                    break;
                }
            } 
            if(isFin) break;
        }
        return answer;
    }
}
