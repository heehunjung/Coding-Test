import java.util.*;

class Solution {
    // weight, count    
    Map<Integer, Integer> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    int[] ratio = new int[]{2,3,4};
    long answer = 0;
    
    public long solution(int[] weights) {
        for(int i=0;i<weights.length;i++) 
            map.put(weights[i], map.getOrDefault(weights[i], 0)+1);
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int wg = entry.getKey();
            int num = entry.getValue();
            
            if(num > 1) answer += combination(num,2);
            for(int rt: ratio) {
                for(int rtt: ratio) {
                    if(rtt >= rt) continue;
                    if ((wg * rt) % rtt != 0) continue; 
                    int next = (wg * rt) / rtt;
                    answer += ((long)map.getOrDefault(next, 0) * num);
                }
            }
        }
        return answer;
    }

    long combination(int n, int r) {
        if (r == 0 || n == r) return 1;
        if (r > n/2) r = n - r; 

        long result = 1;

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1); 
        }
        return result;
    }
}
