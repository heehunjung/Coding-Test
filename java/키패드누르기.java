import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] l = new int[]{0, 3}; 
        int[] r = new int[]{2, 3};  
        
        for (int n : numbers) {
            char next;
            if (n == 1 || n == 4 || n == 7) { 
                next = 'L';
                l[0] = 0;
                l[1] = (n - 1) / 3;
            } else if (n == 3 || n == 6 || n == 9) { 
                next = 'R';
                r[0] = 2;
                r[1] = (n - 1) / 3;
            } else { 
                int y = (n == 0) ? 3 : (n - 2) / 3;
                int ll = cal(l, new int[]{1, y});
                int rr = cal(r, new int[]{1, y});
                
                if (ll == rr) {
                    if (hand.equals("right")) {
                        next = 'R';
                        r[0] = 1;
                        r[1] = y;
                    } else {
                        next = 'L';
                        l[0] = 1;
                        l[1] = y;
                    }
                } else if (ll < rr) {
                    next = 'L';
                    l[0] = 1;
                    l[1] = y;
                } else {
                    next = 'R';
                    r[0] = 1;
                    r[1] = y;
                }
            }
            answer.append(next);
        }
        return answer.toString();
    }

    int cal(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

