import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] node = new int[]{0,0};
        HashMap<String, List<String>> hash = new HashMap<>();
        String[] dirss = dirs.split("");
        
        // start, next 
        for(String dir: dirss) {
            int px = node[0];
            int py = node[1];
            if(dir.equals("U")) node[1] += 1;
            if(dir.equals("D")) node[1] -= 1;
            if(dir.equals("R")) node[0] += 1;
            if(dir.equals("L")) node[0] -= 1;
            
            if(-5 > node[0]) node[0] = -5;
            if(5 < node[0]) node[0] = 5;
            if(-5 > node[1]) node[1] = -5;
            if(5 < node[1]) node[1] = 5;        
            
            String f = px + "," + py;
            String s = node[0] + "," + node[1];

            // 움직인 경우, 현재 위치 기준으로 찾는다 
            if (!(px == node[0] && py == node[1])) {
                List<String> nowww = hash.get(f);
                List<String> nowww2 = hash.get(s);
                
                // 이미 지나간 경로 
                if(nowww != null && nowww.contains(s)) {
                    continue;
                }
                // 새로운 경로
                answer += 1;
                
                if(nowww == null) {
                    List<String> n =new ArrayList<>();
                    n.add(s);
                    hash.put(f, n);
                } else {
                    nowww.add(s);
                }
                
                if(nowww2 == null) {
                    List<String> n2 =new ArrayList<>();
                    n2.add(f);
                    hash.put(s, n2);
                } else {
                    nowww2.add(f);
                }
            }
        }
        
        return answer;
    }
}
