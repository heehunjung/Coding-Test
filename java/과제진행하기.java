import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        Deque<int[]> q = new ArrayDeque<>(); //stack
        Arrays.sort(plans, (a,b)-> a[1].compareTo(b[1]));
        
        String[] first = plans[0];
        q.add(new int[]{toTime(first[1]), Integer.parseInt(first[2]),0});
        int cnt = toTime(first[1]);
        
        for(int i=1;i<plans.length;i++) {
            String[] plan = plans[i];
            String name = plan[0];
            int start = toTime(plan[1]);
            int time = Integer.parseInt(plan[2]);
            
            while(!q.isEmpty()) {
                int[] running = q.pop();
                int fin = cnt + running[1];
                
                if(fin <= start) {
                    result.add(plans[running[2]][0]);
                    cnt = fin;
                } else {
                    running[1] = fin-start;
                    q.push(new int[]{running[0],running[1],running[2]});
                    break;
                }
            }
            cnt = start;
            q.push(new int[]{start, time, i});
        }
        
        while(!q.isEmpty()) {
            int idx = q.pop()[2];
            result.add(plans[idx][0]);
        }
        
        answer = new String[result.size()];
        
        for(int i=0;i<result.size();i++) answer[i] = result.get(i);
        
        return answer;
    }
    
    int toTime(String start) {
        String[] hm = start.split(":");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        
        return h*60 + m;
    }
}
