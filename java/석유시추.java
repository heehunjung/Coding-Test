import java.util.*;

class Solution {
    int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int xx;
    int yy;
    public int solution(int[][] land) {
        int answer = 0;
        xx = land.length;
        yy = land[0].length;
        boolean[][] visited = new boolean[xx][yy];
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 2;
        Set<Integer> set = new HashSet<>();
        Set<Integer> make = new HashSet<>();
        for(int i=0;i<yy;i++) {
            int cnt = 0;
            for(int j=0;j<xx;j++) {
                int key = land[j][i];
                if(key>0) {
                    int v = 0;
                    if(key==1){
                        v = dfs(land,visited,j, i, 1 ,idx);
                        map.put(idx, v);
                        make.add(idx++);
                        cnt += v;
                    } else if(!make.contains(key)) {
                        set.add(key);
                    }
                }
            }
            
            for(int k: set) 
                cnt += map.get(k);    
            set.clear();
            make.clear();
            answer = Math.max(cnt, answer);
        }

        return answer;
    } 
    
    int dfs(int[][] land, boolean[][] visited, int x, int y, int count, int idx) {
        visited[x][y] = true;
        land[x][y] = idx;
        for(int[]mv: moves) {
            int nx = x + mv[0];
            int ny = y + mv[1];
            
            if(0<=nx&&nx<xx&&0<=ny&&ny<yy){
                if(!visited[nx][ny] && land[nx][ny]==1) {
                    count = dfs(land, visited, nx, ny, count+1, idx);
                }
            }
        }
        
        return count;
    }
}
