import java.util.*;

class Solution {
    private char[][] myMaps;
    private boolean[][] visited;
    private int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int[] solution(String[] maps) {
        List<Integer> ans = new ArrayList<>();
        
        myMaps = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0;i<maps.length;i++) {
            myMaps[i] = maps[i].toCharArray();
        }
        boolean isHaveSum = false;
        for(int i=0;i<myMaps.length;i++) {
            for(int j=0;j<myMaps[0].length;j++) {
                if(!(myMaps[i][j]=='X') && !visited[i][j]) {
                    visited[i][j] = true;
                    ans.add(bfs(i,j));
                    isHaveSum = true;
                }
            }
        }
        
        if (!isHaveSum) {
            return new int[]{-1};
        }
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
    
    private int bfs(int x,int y) {
        int result = 0;
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{x,y});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            result +=  Character.getNumericValue(myMaps[current[0]][current[1]]);
            
            for(int[]move: moves) {
                int nx = current[0] + move[0];
                int ny = current[1] + move[1];
                if (isValidXY(nx,ny)) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }   
        }
        return result;
    }
    
    private boolean isValidXY(int x,int y) {
        if (0<= x && x < myMaps.length && 0 <= y && y < myMaps[0].length) {
            if(!visited[x][y] && !(myMaps[x][y]=='X')){
                return true;
            }
        }
        return false;
    }
}
