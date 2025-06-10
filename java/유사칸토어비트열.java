import java.util.*;
class Solution {
    public int solution(int n, long l, long r) {
        int count = 0;
        for (long i = l; i <= r; i++) {
            if (isOne(n, i - 1)) count++;
        }
        return count;
    }

    private boolean isOne(int n, long index) {
        if (n == 0) return true;

        long size = (long)Math.pow(5, n - 1);
        long pos = index / size;

        if (pos == 2) return false; // 3번째 위치는 항상 0 (규칙상)
        return isOne(n - 1, index % size);
    }
}
