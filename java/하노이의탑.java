import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result); // 1번 기둥에서 3번 기둥으로, 2번 기둥을 보조로 사용
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private void hanoi(int n, int from, int to, int aux, List<int[]> result) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, aux, to, result); 
        result.add(new int[]{from, to}); 
        hanoi(n - 1, aux, to, from, result); 
    }
}
