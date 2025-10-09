import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        List<int[]> keys = new ArrayList<>(); 
        List<int[]> locks = new ArrayList<>();
        int totalLock = 0;
        int x = key.length;
        int xx = lock.length;
        for(int i=0;i<x;i++) {
            for(int j=0;j<x;j++) {
                if(key[i][j] == 1) keys.add(new int[]{i,j});
            }
        }
        
        for(int i=0;i<xx;i++) {
            for(int j=0;j<xx;j++) {
                if(lock[i][j] == 0) totalLock++;
            }
        }
        int start = -1 * xx + 1;
        for (int r = 0; r < 4; r++) {
            for (int i = start; i < xx; i++) {
                for (int j = start; j < xx; j++) {
                    boolean isTrue = true;
                    int count = 0;
                    for (int[] cnt : keys) {
                        int[] cntt = move(cnt, x, r);
                        int cx = cntt[0] + i;
                        int cy = cntt[1] + j;

                        if (0 <= cx && cx < xx && 0 <= cy && cy < xx) {
                            if (lock[cx][cy] == 0) {
                                count++;
                            } else {
                                isTrue = false;
                                break;
                            }
                        }
                    }
                    if (isTrue && count == totalLock) return true;
                }
            }
        }

        return false;
    }

    int[] move(int[] pos, int n, int r) {
        int x = pos[0];
        int y = pos[1];
        int newX = x;
        int newY = y;

        if (r == 1) { // 90도 시계방향
            newX = y;
            newY = n - 1 - x;
        } else if (r == 2) { // 180도
            newX = n - 1 - x;
            newY = n - 1 - y;
        } else if (r == 3) { // 270도 
            newX = n - 1 - y;
            newY = x;
        }

        return new int[] { newX, newY };
    }

}


