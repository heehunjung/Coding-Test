import java.util.*;

class Solution {
    int[][][] dp;
    int[][] val;

    public int solution(String numbers) {
        val = new int[10][2];
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                val[i][0] = 3;
                val[i][1] = 1;
                continue;
            }
            val[i][0] = (i - 1) / 3;
            val[i][1] = (i - 1) % 3;
        }

        int len = numbers.length();
        dp = new int[len + 1][10][10];

        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<int[]> queue = new LinkedList<>();


        dp[0][4][6] = 0;
        queue.add(new int[]{0, 4, 6});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int idx = current[0];
            int left = current[1];
            int right = current[2];
            int cost = dp[idx][left][right];

            if (idx == len) {
                continue;
            }

            int nextNum = numbers.charAt(idx) - '0';

            // (오른손과 다른 위치로만 이동 가능)
            if (nextNum != right) {
                int nextCost = cost + cal(left, nextNum);
                if (nextCost < dp[idx + 1][nextNum][right]) {
                    dp[idx + 1][nextNum][right] = nextCost;
                    queue.add(new int[]{idx + 1, nextNum, right});
                }
            }

            // (왼손과 다른 위치로만 이동 가능)
            if (nextNum != left) {
                int nextCost = cost + cal(right, nextNum);
                if (nextCost < dp[idx + 1][left][nextNum]) {
                    dp[idx + 1][left][nextNum] = nextCost;
                    queue.add(new int[]{idx + 1, left, nextNum});
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                answer = Math.min(answer, dp[len][i][j]);
            }
        }
        return answer;
    }


    int cal(int f, int s) {
        if (f == s) return 1; // 같은 위치를 다시 누를 때 비용 1

        int fx = val[f][0], fy = val[f][1];
        int sx = val[s][0], sy = val[s][1];

        int diffX = Math.abs(fx - sx);
        int diffY = Math.abs(fy - sy);

        if (diffX == 0 || diffY == 0) {
            return (diffX + diffY) * 2;
        }
        else {
            int diagonal = Math.min(diffX, diffY);
            int straight = Math.max(diffX, diffY) - diagonal;
            return diagonal * 3 + straight * 2;
        }
    }
}
