import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> reports = new HashMap<>();
        Map<String, Integer> reports_num = new HashMap<>();
        for(String id: id_list) {
            reports.put(id, new ArrayList<String>());
            reports_num.put(id, 0);
        }
        
        for(String rp: report) {
            String[] rps = rp.split(" ");
            List<String> cnts = reports.get(rps[0]);
            boolean isExist = false;
            for(String cnt: cnts) {
                if(cnt.equals(rps[1])) {
                    isExist = true;
                    break;
                }
            }
            if(!isExist) {
                cnts.add(rps[1]);
                reports_num.put(rps[1], reports_num.get(rps[1])+1);
            }
        }
        int idx = 0;
        for(String id: id_list) {
            int rpn = 0;
            for(String rp: reports.get(id)) {
                if(reports_num.get(rp) >= k) {
                    rpn++;
                }
            }
            answer[idx++] = rpn;
        }
        return answer;
    }
}
