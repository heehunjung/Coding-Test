import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        char[] names = name.toCharArray();
        
        // 상/하
        for (char c : names) {
            answer += calUD(c);
        }
        
        // 좌/우 
        int move = n - 1; 
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            while (next < n && names[next] == 'A') {
                next++;
            }
            
            int forward = i + (n - next) + Math.min(i, n - next);
            move = Math.min(move, forward);
            forward = 2 * i + (n - next);
            move = Math.min(move, forward);
            forward = i + 2 * (n - next);
            move = Math.min(move, forward);
        }
        
        return answer + move;
    }
    
    private int calUD(char target) {
        int a = (int)'A';
        int current = (int)target;
        int z = (int)'Z';
        return Math.min(current - a, z - current + 1);
    }
}
