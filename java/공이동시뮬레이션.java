class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {

        long xMin = x, xMax = x;
        long yMin = y, yMax = y;
        
        for (int i = queries.length - 1; i >= 0; i--) {
            int dir = queries[i][0];
            int dist = queries[i][1];
            
            if (dir == 0) { 
                if (yMin != 0) yMin += dist;
                yMax += dist;
                
                if (yMax > m - 1) yMax = m - 1;
                
            } else if (dir == 1) {
                if (yMax != m - 1) yMax -= dist;
                yMin -= dist;
                
                if (yMin < 0) yMin = 0;
                
            } else if (dir == 2) { 
                if (xMin != 0) xMin += dist;
                xMax += dist;
                if (xMax > n - 1) xMax = n - 1;
                
            } else { 
                if (xMax != n - 1) xMax -= dist;
                xMin -= dist;
                if (xMin < 0) xMin = 0;
            }
            
            if (yMin > m - 1 || yMax < 0 || xMin > n - 1 || xMax < 0) return 0;
        }
        
        return (xMax - xMin + 1) * (yMax - yMin + 1);
    }
}
