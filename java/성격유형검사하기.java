import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[][] chs = new String[4][2];
        chs[0][0] = "R";
        chs[0][1] = "T";
        chs[1][0] = "C";
        chs[1][1] = "F";
        chs[2][0] = "J";
        chs[2][1] = "M";
        chs[3][0] = "A";
        chs[3][1] = "N";
        Map<String,Integer> pnts = new HashMap<>();
        for(String[] ch: chs) {
            pnts.put(ch[0], 0);
            pnts.put(ch[1], 0);
        }
        
        for(int i=0;i<survey.length;i++) {
            String[] svs= survey[i].split("");
            int point = choices[i];
            if(point>4) pnts.put(svs[1], pnts.get(svs[1])+point-4);
            if(point<4) pnts.put(svs[0], pnts.get(svs[0])+(point-4)*(-1));
        }
        
        for(String[] cs: chs) {
            int f = pnts.get(cs[0]);
            int s = pnts.get(cs[1]);
            
            if(f >= s) answer += cs[0];
            else answer += cs[1];
        }
        return answer;
    }
}
