import java.util.*;

class Solution {
    int[] result = new int[3];

    public int solution(String dartResult) {
        int answer = 0;
        int idx = 0;
        int cnt = 0;
        List<String> li = new ArrayList<>();
        
        for(int i=0;i<dartResult.length();i++) {
            char c = dartResult.charAt(i);
            if('0' <= c && c <= '9') {
                if(i<dartResult.length()-1 && c == '1') {
                    char nc = dartResult.charAt(i+1);
                    if(nc == '0') {
                        cnt = 10;
                        i++;
                        continue;
                    }
                }
                cnt = c-'0';
            }
            else li.add(String.valueOf(c));
            
            
            if(i!=dartResult.length()-1) {
                char next = dartResult.charAt(i+1);
                if('0' <= next && next <= '9' && i != 0) {
                    cal(cnt, li, idx++);
                    cnt = 0;
                    li = new ArrayList<>();
                }
            } else {
                cal(cnt, li, idx++);   
                cnt = 0;
                li = new ArrayList<>();
            }
        }
        
        for(int r: result) {
            answer += r;
        }
        return answer;
    }
    
    void cal(int n, List<String> ss, int idx) {
        int jg = 0;
        boolean star = false;
        boolean acha = false;
        int c = n;
        for(String s: ss) {
            if(s.equals("S")) jg=1; 
            if(s.equals("D")) jg=2;
            if(s.equals("T")) jg=3;
            if(s.equals("*")) star=true;
            if(s.equals("#")) acha=true;
        }
        while(jg >1) {
            n *= c;
            jg--;
        }
        result[idx] = n;
        if(star) {
            if(idx>0) result[idx-1] *= 2;
            result[idx] *= 2;
        }
        if(acha) result[idx] *= (-1);
    }
}
