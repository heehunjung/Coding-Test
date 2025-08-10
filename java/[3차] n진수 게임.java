import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int num = 0;
        int len = 0;
        int idx = 0;
        while(t!=0) {
            String now = nnum(n, num);
            len += now.length();
            while(true) {
                if(m*idx+p>len) break;
                if (t == 0) break;
                int idx2 = (m*idx+p)-(len-now.length());
                answer.append(now.charAt(idx2-1));
                idx++;
                t--;
            }
            num++;
        }
        
        return answer.toString();
    }
    
    String nnum(int n, int num) {
        String chars = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        if(num==0) sb.append(0);
        else{
            while (num > 0) {
                sb.append(chars.charAt(num % n));
                num /= n;
            }
        }

        return sb.reverse().toString();
    }
}
