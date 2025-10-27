import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n>0) {
            int cnt = n%3;
            if(cnt==0) {
                cnt = 4;
                n = n/3-1;
            } else {
                n = n/3;
            }
            
            sb.append(cnt);
        }
        sb.reverse();
        
        return sb.toString();
    }
}
