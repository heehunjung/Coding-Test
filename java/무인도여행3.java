import java.util.*;

class Solution {
    int[][] hmap;
    boolean[][] visited;
    int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        hmap = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> li = new ArrayList<>();
        
        int k=0;
        for(String mp: maps) {
            int j=0;
            for(String m: mp.split("")) {
                if(m.equals("X")) hmap[k][j] = -1;
                else hmap[k][j] = Integer.parseInt(m);
                j++;
            }    
            k++;
        }
        
        for(int i=0;i<hmap.length;i++){
            for(int j=0;j<hmap[0].length;j++){
                if(visited[i][j] || hmap[i][j] == -1) continue;
                visited[i][j] = true;
                li.add(bfs(i,j));
            }
        }
        if(li.isEmpty()) return new int[]{-1};
        Collections.sort(li);
        answer = new int[li.size()];
        int idx = 0;
        for(int n: li) {
            answer[idx++] = n;
        }
        return answer;
    }
    
    int bfs(int i, int j) {
        int result = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] cnt = q.poll();
            result += hmap[cnt[0]][cnt[1]];
            
            for(int[]mv: moves) {
                int ni = cnt[0] + mv[0];
                int nj = cnt[1] + mv[1];
                
                if(0 <= ni && ni < hmap.length && 0 <= nj && nj < hmap[0].length) {
                    if(hmap[ni][nj] > 0 && !visited[ni][nj]) {
                        q.offer(new int[]{ni,nj});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        return result;
    }
}

