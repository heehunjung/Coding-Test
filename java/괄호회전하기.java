import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<String> str = new ArrayDeque<>();
        for(String ss: s.split("")) {
            str.offer(ss);
        }
        if (check(str)) {
            answer += 1; 
        }
        
        for(int i=0;i<str.size()-1;i++) {
            String sss = str.poll();
            str.offer(sss);
            if (check(str)) {
                answer += 1; 
            }
        }
        
        return answer;
    }
    
    private boolean check(Deque<String> str) {
        Deque<String> fin = new ArrayDeque<>();
        for (String s : str) {  
            if (s.equals("(") || s.equals("[") || s.equals("{")) {
                fin.push(s);
            } else {
                if (fin.isEmpty() || !isMatchingPair(fin.pop(), s)) {
                    return false;
                }
            }
        }
        return fin.isEmpty();
    }
    
    private boolean isMatchingPair(String open, String close) {
        return (open.equals("{") && close.equals("}")) ||
               (open.equals("[") && close.equals("]")) ||
               (open.equals("(") && close.equals(")"));
    }
}
