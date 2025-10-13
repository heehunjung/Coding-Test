import java.util.*;

class Solution {
    int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    String[] board;

    public int solution(String[] board) {
        this.board = board;
        int rows = board.length, cols = board[0].length();
        int sx = -1, sy = -1, gx = -1, gy = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'R') { sx = i; sy = j; }
                if (ch == 'G') { gx = i; gy = j; }
            }
        }

        int[][] dist = new int[rows][cols];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

        Deque<int[]> q = new ArrayDeque<>();
        dist[sx][sy] = 0;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int base = dist[x][y];

            if (x == gx && y == gy) return base;

            for (int[] mv : moves) {
                int nx = x, ny = y;
                while (true) {
                    int tx = nx + mv[0], ty = ny + mv[1];
                    if (0 <= tx && tx < rows && 0 <= ty && ty < cols) {
                        if (board[tx].charAt(ty) == 'D') break;
                        nx = tx; ny = ty;
                    } else {
                        break;
                    }
                }
                if (nx == x && ny == y) continue; // 안 움직였으면 스킵
                if (dist[nx][ny] > base + 1) {
                    dist[nx][ny] = base + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}

