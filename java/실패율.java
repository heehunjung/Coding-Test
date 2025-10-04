import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] stay = new int[N + 2];
        for (int st : stages) {
            if (1 <= st && st <= N + 1) stay[st]++;
        }

        double[] failure = new double[N + 2];
        int players = stages.length;
        for (int i = 1; i <= N; i++) {
            if (players == 0) failure[i] = 0.0;
            else failure[i] = (double) stay[i] / players;
            players -= stay[i];
        }

        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) order[i] = i + 1;

        Arrays.sort(order, (a, b) -> {
            int cmp = Double.compare(failure[b], failure[a]);
            if (cmp != 0) return cmp;
            return Integer.compare(a, b);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = order[i];
        return answer;
    }
}

