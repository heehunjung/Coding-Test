import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int box1 = 0;
        int box2 = 0;
        int result = 0;
        
        for(int i = 0; i < cards.length; i++) {
            boolean[] mark = new boolean[cards.length];
            box1 = Math.max(call(mark,cards,i), box1);

            for(int j = 0; j < cards.length; j++) {
                if (!mark[j]) {
                    box2 = Math.max(call(mark,cards,j), box2);
                }
            }
            result = Math.max(result, box1 * box2);
            box1 = 0;
            box2 = 0;
        }
        
        return result;
    }
    
    private int call(boolean[] mark,int[] cards, int start) {
        Queue<Integer> idx = new ArrayDeque<>();
        int result = 0;
        idx.offer(cards[start]);
        
        while (!idx.isEmpty()) {
            int current = idx.poll();
            mark[current-1] = true;
            result += 1;
            if (mark[cards[current-1]-1]) {
                continue;
            } else {
                idx.offer(cards[current-1]);
            }
        }
        return result;
    }
}
