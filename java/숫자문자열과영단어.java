import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Map<String, Integer> mp = new HashMap<>();
        mp.put("zero", 0);
        mp.put("one", 1);
        mp.put("two", 2);
        mp.put("three", 3);
        mp.put("four", 4);
        mp.put("five", 5);
        mp.put("six", 6);
        mp.put("seven", 7);
        mp.put("eight", 8);
        mp.put("nine", 9);

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if('0' <= c && c <= '9') {
                // sb가 이미 있는 경우 
                if(sb.length() > 0) {
                    result.append(mp.get(sb.toString()));
                    sb.setLength(0);
                }
                result.append(c);
                continue;
            }
            sb.append(c);
            if(mp.containsKey(sb.toString())) {
                result.append(mp.get(sb.toString()));
                sb.setLength(0);                
            }
        }
        return Integer.valueOf(result.toString());
    }
}
