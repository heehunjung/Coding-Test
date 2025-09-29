import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer;
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), idx++);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<msg.length();i++) {
            int cntIdx = i;
            sb.append(msg.charAt(cntIdx++));
            while(map.containsKey(sb.toString())) {
                if(cntIdx >= msg.length()) break;
                sb.append(msg.charAt(cntIdx++));
            }
            
            if(sb.length() > 1 && !map.containsKey(sb.toString())) {
                map.put(sb.toString(), idx++);
                sb.deleteCharAt(sb.length() - 1);
            }
            result.add(map.get(sb.toString()));
            i += sb.length()-1;
            sb.setLength(0);
        }
        
        answer = new int[result.size()];
        idx = 0;
        for(int c: result) {
            answer[idx++] = c;
        }
        return answer;
    }
}
