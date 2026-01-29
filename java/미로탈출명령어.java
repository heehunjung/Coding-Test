import java.util.*;

class Solution {
    int N, M, R, C, K;
    String answer = null;
    // 사전식 순서: d, l, r, u
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] mvs = {'d', 'l', 'r', 'u'};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m; R = r - 1; C = c - 1; K = k;

        int dist = Math.abs((x - 1) - R) + Math.abs((y - 1) - C);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";

        dfs(x - 1, y - 1, new StringBuilder(), 0);

        return answer == null ? "impossible" : answer;
    }

    void dfs(int cx, int cy, StringBuilder sb, int count) {
        if (answer != null) return;

        int remainingDist = Math.abs(cx - R) + Math.abs(cy - C);
        if (remainingDist > K - count) return;

        if (count == K) {
            if (cx == R && cy == C) {
                answer = sb.toString();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                sb.append(mvs[i]);
                dfs(nx, ny, sb, count + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
