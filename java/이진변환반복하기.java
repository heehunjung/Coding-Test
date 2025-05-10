import java.util.*;

class Solution {
    List<Integer> li = new ArrayList<>();
    public int[] solution(String s) {
        int[] answer = new int[2];
        int total = 0;
        int count = 0;
        List<Integer> ss = new LinkedList<>();
        for(String sss: s.split("")) {
            ss.add(Integer.valueOf(sss));
        }
                
        while(ss.size() > 1) {
            int current = count(ss);
            count += 1;
            total += (ss.size()-current);
            ss = toBinary(current);
            // System.out.println(ss);
        }
        
        answer[0] = count;
        answer[1] = total;
        return answer;
    }
    
    private int count(List<Integer> s) {
        int result = 0;
        for(int i = 0; i < s.size(); i++) {
            if(s.get(i).equals(1)) {
                result += 1;
            }
        }
        return result;
    }
    
    private List<Integer> toBinary(int count) {
        List<Integer> result = new LinkedList<>();
        
        while(count > 0) {
            result.add(0, count % 2); 
            count = count/2;
        }
        return result;
    }
}
