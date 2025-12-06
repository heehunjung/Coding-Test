import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long rr1=(long)r1*r1;
        long rr2=(long)r2*r2;
        for(int i=1;i<=r2;i++) {
            long d = caly(i, rr1);
            long u = caly(i, rr2);
            if(d == 0 || d*d + (long)i*i == rr1) answer++;
            answer += (u-d);
        }
        
        return answer*4;
    }
    
    long caly(int x, long r) {        
        long xx = (long)x*x;
        if(xx>=r) return 0;
        long yy = r-xx;
        return (long)Math.sqrt(yy);
    }
}
