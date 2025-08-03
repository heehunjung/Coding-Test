import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> stk = new ArrayDeque<>();
        
        for(String cityRaw: cities) {
            String city = cityRaw.toLowerCase();
            boolean isHit = false;
            for(String cs: stk) {
                // cache hit ! 
                if (city.equals(cs)){    
                    answer += 1;
                    stk.remove(cs);
                    stk.offer(cs);
                    isHit = true;
                    break;
                }
            }
            
            if (!isHit) {
                answer += 5;
                if(stk.size() == cacheSize) {
                   stk.poll();
                }
                stk.offer(city);
            }
        }
        
        return answer;
    }
}
