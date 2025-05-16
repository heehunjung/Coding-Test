import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> m = new HashMap<>();
        
        for(String[] cloth: clothes) {
            m.put(cloth[1], m.getOrDefault(cloth[1],0)+1);
        }
        
        for(Integer v: m.values()){
            answer *= (v+1);
        }
        answer -= 1;
        return answer;
    }
}
