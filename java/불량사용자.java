import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int len;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        int idx = 0;
        len = banned_id.length;
        for(String bid: banned_id) {
            map.put(idx, new ArrayList<Integer>());
            for(int i=0;i<user_id.length;i++){
                if(check(user_id[i], bid)) map.get(idx).add(i);
            }
            idx++;
        }
        
        Set<List<Integer>> set = new HashSet<>();
        fill(0, new ArrayList<>(), set);
        return set.size();
    }
    
    void fill(int idx, List<Integer> li, Set<List<Integer>> set) {
        if(idx ==len) {
            List<Integer> sorted = new ArrayList<>(li);
            Collections.sort(sorted);
            set.add(sorted);  // 정렬된 복사본을 추가
            return;
        }
        
        for(int cnt: map.get(idx)) {
            if (li.contains(cnt)) continue; // 중복 user_id 방지
            li.add(cnt);
            fill(idx+1, li, set);
            li.remove(li.size()-1);
        }
    }
    
    boolean check(String id, String banid) {
        if(id.length() != banid.length()) return false;
        
        char[] ids = id.toCharArray();
        char[] bids = banid.toCharArray();

        for(int i=0;i<ids.length;i++) {
            if(bids[i]=='*') continue;
            if(bids[i]!=ids[i]) return false;
        }
        
        return true;
    }
  
}
