import java.util.*;

class Solution {
    Map<String, Integer> tms = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> rs = new ArrayList<>();
        for(String term: terms) {
            String[] tm = term.split(" ");
            // System.out.println(tm[0] + " , " + tm[1]);
            tms.put(tm[0], Integer.parseInt(tm[1]));
        }
        for(int i=0; i<privacies.length;i++) {
            String[] pvs = privacies[i].split(" ");
            if(cmpDate(today, pvs[0], pvs[1])) {
                rs.add(i+1);
            }
        }
        answer = new int[rs.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = rs.get(i);
        }
        return answer;
    }
    
    boolean cmpDate(String today, String pv, String tm) {
        int f = 0;
        int l = 0;
        
        String[] td = today.split("\\.");
        String[] pvs = pv.split("\\.");

        f = Integer.parseInt(td[0]) * 28 * 12 + Integer.parseInt(td[1]) * 28 + Integer.parseInt(td[2]);
        l = Integer.parseInt(pvs[0]) * 28 * 12 + Integer.parseInt(pvs[1]) * 28 + Integer.parseInt(pvs[2]) + tms.get(tm) * 28;
        
        return f >= l;
    }
}
