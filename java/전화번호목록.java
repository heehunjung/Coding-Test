import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> q = new HashMap<>();
        
        int idx=0;
        for(String num: phone_book) {
            q.put(num, idx);  
            idx += 1;
        }
        idx = 0;
        for(String num: phone_book) {
            StringBuilder sb = new StringBuilder();
            for(String s: num.split("")) {
                sb.append(s);
                if (q.containsKey(sb.toString()) && q.get(sb.toString()) != idx) {
                    return false;
                }
            }
            idx += 1;
        }
        return answer;
    }
}
