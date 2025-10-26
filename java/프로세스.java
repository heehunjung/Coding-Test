import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> uniq = new HashSet<>();

        for (int i = 0; i < priorities.length; i++) {
            int p = priorities[i];
            q.offer(new int[]{p, i});
            count.put(p, count.getOrDefault(p, 0) + 1); 
            uniq.add(p);
        }

        List<Integer> order = new ArrayList<>(uniq);
        order.sort(Collections.reverseOrder());
        int ordIdx = 0;
        int currentMax = order.get(ordIdx);

        while (!q.isEmpty()) {
            int[] cur = q.poll();       
            int p = cur[0], idx = cur[1];

            if (p == currentMax) {
                answer++;
                if (idx == location) return answer;

                int left = count.get(p) - 1;
                count.put(p, left);
                if (left == 0) {
                    ordIdx++;
                    if (ordIdx < order.size()) {
                        currentMax = order.get(ordIdx);
                    }
                }
            } else {
                q.offer(cur);
            }
        }

        return answer; 
    }

  
}
