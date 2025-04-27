import java.util.*;

class Solution {
    private String[][] STORAGE = {{}};
    private boolean[][] visited = {{}};
    private int[][] next = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean isBlocked = false;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        STORAGE = new String[storage.length][]; 
        visited = new boolean[storage.length][];
        
        for (int i = 0; i < storage.length; i++) {
            STORAGE[i] = storage[i].split(""); 
            visited[i] = new boolean[STORAGE[i].length];
        }
        
        for(String request: requests) {
            if(request.length() == 2) {
                크레인(request.split("")[0]);
                continue;
            } 
            
            List<int[]> visit = new ArrayList<>();
            for(int i=0;i<STORAGE.length;i++) {
                for(int j=0;j<STORAGE[0].length;j++) {
                    if(!visited[i][j] && STORAGE[i][j].equals(request)) {
                        boolean [][]temp = new boolean[visited.length][visited[1].length];
                        dfs(i,j,temp);
                        if(isBlocked) {
                            visit.add(new int[]{i,j});
                            isBlocked = false;
                        }
                    }
            
                }
            }
            
            for(int[]v: visit) {
                visited[v[0]][v[1]] = true;
            }
        }
        
        for(boolean[]vv: visited) {
            for(boolean v: vv) {
                System.out.print(v +" ");
                if (!v) {
                    answer += 1;
                }
            }
            System.out.println("");
        }
        return answer;
    }
    
    private void 크레인(String container) {
        for(int i=0;i<STORAGE.length;i++) {
            for(int j=0;j<STORAGE[i].length;j++) {
                if(!visited[i][j] && STORAGE[i][j].equals(container)) {
                    visited[i][j] = true;
                }
            }
        }
    }
    
    private void dfs(int x,int y, boolean[][] temp) {
        temp[x][y] = true;
        for (int[]nn: next) {
            int nx = x + nn[0];
            int ny = y + nn[1];
            
            if (0<=nx && nx<STORAGE.length && 0 <= ny && ny < STORAGE[0].length) {
                if(visited[nx][ny] && !temp[nx][ny]) {
                    dfs(nx,ny,temp);
                }
            } else {
                isBlocked = true;
                return;
            }
        }
    }
    
    private boolean bfs(int x, int y) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{x,y});
        
        while(!q.isEmpty()) {
            int[] current = q.pollFirst();
            
            for(int[]nn: next) {
                int nx = current[0]+nn[0];
                int ny = current[1]+nn[1];
                            
                if (0<=nx && nx<STORAGE.length && 0 <= ny && ny < STORAGE[0].length) {
                    if(visited[nx][ny]) {
                        q.addLast(new int[]{nx,ny});   
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

