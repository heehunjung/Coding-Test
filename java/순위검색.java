import java.util.*;

class Solution {
    Map<String, List<Integer>> datas = new HashMap<>();
        
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];        
        
        
        // 쿼리 기준으로 데이터를 만든다.
        for (String ii : info) {
            String[] i = ii.split(" ");
            makeByDfs(i, "", 0);
        }
        for (List<Integer>li: datas. values()){
            Collections.sort(li);
        }
        
        int idx = 0;
        for (String qq: query) {
            String[] q = qq.replaceAll(" and ", "").split(" ");
            int score = Integer.parseInt(q[1]);
            List<Integer> result = datas.get(q[0]);
            if(result==null) {
                answer[idx] = 0;
                idx += 1;
                continue;
            } 
            
            answer[idx] = binarySearch(result, score);
            idx +=1;
        }
        return answer;
    }
    
    private int binarySearch(List<Integer>result, int target) {
        int start = 0;
        int last = result.size()-1;
        
        while(start <= last) {
            int mid = (start + last) / 2;
            
            if(result.get(mid) < target) {
                start = mid +1;
            } else {
                last = mid -1;
            }
        }
        
        return result.size()-start;
    }
    
    private void makeByDfs(String[] words, String key, int current) {
        if(current == 4) {
            if(!datas.containsKey(key)) {
                List<Integer> list= new ArrayList<>();
                datas.put(key, list);
            }
            datas.get(key).add(Integer.parseInt(words[4]));
            return; 
        }
        
        makeByDfs(words, key + words[current], current+1);
        makeByDfs(words, key + "-", current+1);
    }
}
