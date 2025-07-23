import java.util.*;

class Solution {
    Map<String, List<String>> ticketMap = new HashMap<>();
    int num;
    String result = "z";
    public String[] solution(String[][] tickets) {
        String[] answer;
        String start = "ICN";
        
        for(String[] ticket: tickets) {
            String str = ticket[0], des = ticket[1];
            ticketMap.computeIfAbsent(str, k -> new ArrayList<>()).add(des);
        }
        num = tickets.length;
        
        List<String> nextList = ticketMap.get(start);
        for (int i = 0; i < nextList.size(); i++) {
            String next = nextList.get(i);
            Set<String> set = new HashSet<>();
            set.add(start + next + i);
            dfs(start, next, 1, start + next, set);
        }
        
        answer = new String[result.length()/3];
        int idx = 0;
        for(int i=0;i<result.length();i++) {
            answer[idx] = result.substring(i,i+3);
            i += 2;
            idx ++;
        }
        return answer;
    }
    
    void dfs(String str, String dst, int count, String load , Set<String> set) {
        if(count == num) {
            if(0 >= load.compareTo(result)) result = load;
            return;
        }
        if(!ticketMap.containsKey(dst)) return;
        
        List<String> nextList = ticketMap.get(dst);
        for (int i = 0; i < nextList.size(); i++) {
            String next = nextList.get(i);
            if (set.contains(dst + next + i)) continue;
            set.add(dst + next + i);
            dfs(dst, next, count + 1, load + next, set);
            set.remove(dst + next + i);
        }

    }
    
}
