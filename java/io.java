import java.io.*;
import java.util.*;

class Main {
	static boolean [][] visited;
	static int[][] map;
	static int[][] move = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}

		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}
	
	private static void bfs(int x, int y) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x, y});
		visited[x][y] = true;
		int count = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			count += 1;
			
			for(int[]mv: move) {
				int nx = now[0] + mv[0];
				int ny = now[1] + mv[1];

				if(0 <= nx && nx < visited.length && 0 <= ny && ny < visited[0].length) {
					if(!visited[nx][ny] && map[nx][ny]==1) {
						q.offer(new int[]{nx,ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
		pq.add(count);
	}
}
