import java.util.*;

class Solution {
    int[][] mb;
    int answer;
    int pairCount;
    int xx;
    int yy;
    int[][] mvs = {{0,1},{1,0},{0,-1},{0,0-1}};

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    Map<Integer, List<int[]>> targets = new HashMap<>();

    public int solution(int[][] board, int r, int c) {
        answer = Integer.MAX_VALUE;
        mb = new int[board.length][board[0].length];
        xx = mb.length;
        yy = mb[0].length;

        for (int i = 0; i < xx; i++) {
            for (int j = 0; j < yy; j++) {
                mb[i][j] = board[i][j];
                int v = board[i][j];
                if (v != 0) {
                    targets.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        pairCount = targets.size();
        dfs(r, c, 0, 0);
        return answer;
    }

    void dfs(int x, int y, int count, int hit) {
        if (count >= answer) return;

        if (hit == pairCount) {
            answer = Math.min(answer, count);
            return;
        }

        for (int num : targets.keySet()) {
            if (!exists(num)) continue;

            List<int[]> pos = targets.get(num);
            int[] p1 = pos.get(0);
            int[] p2 = pos.get(1);

            int d1 = bfs(x, y, p1[0], p1[1]);
            int d2 = bfs(p1[0], p1[1], p2[0], p2[1]);
            int cost1 = d1 + d2 + 2;

            remove(num);
            dfs(p2[0], p2[1], count + cost1, hit + 1);
            restore(num);

            d1 = bfs(x, y, p2[0], p2[1]);
            d2 = bfs(p2[0], p2[1], p1[0], p1[1]);
            int cost2 = d1 + d2 + 2;

            remove(num);
            dfs(p1[0], p1[1], count + cost2, hit + 1);
            restore(num);
        }
    }

    boolean exists(int num) {
        List<int[]> pos = targets.get(num);
        int[] p1 = pos.get(0);
        int[] p2 = pos.get(1);
        return mb[p1[0]][p1[1]] == num || mb[p2[0]][p2[1]] == num;
    }

    void remove(int num) {
        List<int[]> pos = targets.get(num);
        for (int[] p : pos) {
            if (mb[p[0]][p[1]] == num) {
                mb[p[0]][p[1]] = 0;
            }
        }
    }

    void restore(int num) {
        List<int[]> pos = targets.get(num);
        for (int[] p : pos) {
            if (mb[p[0]][p[1]] == 0) {
                mb[p[0]][p[1]] = num;
            }
        }
    }

    int bfs(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return 0;

        boolean[][] visited = new boolean[xx][yy];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (inRange(nx, ny) && !visited[nx][ny]) {
                    if (nx == tx && ny == ty) return dist + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }

                int[] ctrl = ctrlMove(x, y, d[0], d[1]);
                nx = ctrl[0];
                ny = ctrl[1];
                if (!visited[nx][ny]) {
                    if (nx == tx && ny == ty) return dist + 1;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    boolean inRange(int x, int y) {
        return 0 <= x && x < xx && 0 <= y && y < yy;
    }

    int[] ctrlMove(int x, int y, int dx, int dy) {
        int nx = x;
        int ny = y;
        while (true) {
            int tx = nx + dx;
            int ty = ny + dy;
            if (!inRange(tx, ty)) break;
            nx = tx;
            ny = ty;
            if (mb[nx][ny] != 0) break;
        }
        return new int[]{nx, ny};
    }
}

