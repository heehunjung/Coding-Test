import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    List<String> combis = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for(int i: course) {
            for(String order:  orders) {
                String[] temp = order.split("");
                Arrays.sort(temp);
                combination(i,i,0,temp);
            }
            Set<String> set = new HashSet<>(combis);
            combis = new ArrayList<>(set);
        }
        
        for(String a: combis) {
            for(String order: orders) {
                String[] aa = a.split("");
                boolean isOk = true;
                for(String aaa :aa) {
                    if (!order.contains(aaa)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }
        
        for(String key: map.keySet()) {
            if (map.get(key) > 1) result.add(key);
        }

        Collections.sort(result, (a,b) -> {
            if(a.length() == b.length()) return map.get(b) - map.get(a);
            else return a.length() - b.length();
        });
        
        List<String> copy = new ArrayList<>(result);  // 복사본 생성

        int cnt = 0;
        int count = 0;
        int idx = 0;

        for (String aa : copy) {
            if (cnt < aa.length()) {
                cnt = aa.length();
                count = map.get(aa);
                continue;
            }

            if (map.get(aa) != count) {
                result.remove(aa);  // 객체 자체로 제거
            } 
        }
        
        Collections.sort(result, (a,b) -> a.compareTo(b));
        
        answer = new String[result.size()];
        for(int i=0;i<result.size();i++) answer[i] = result.get(i);
        return answer;
    }
    
    private void combination(int l, int k,int s ,String[] list) {
        if (l == 0) {
            combis.add(sb.toString());
            return ;
        }
        
        for(int i=s; i<list.length;i++) {
            sb.append(list[i]);
            combination(l-1, k, i+1, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}
