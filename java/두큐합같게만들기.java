import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        int n = queue1.length;
        ArrayDeque<Integer> dq1 = new ArrayDeque<>();
        ArrayDeque<Integer> dq2 = new ArrayDeque<>();
        long v1 = 0;
        long v2 = 0;
        for(int i=0;i<n;i++) {
            int t1 = queue1[i];
            int t2 = queue2[i];
            v1 += t1;
            v2 += t2;
            dq1.offer(t1);
            dq2.offer(t2);
        }
        
        if(v1==v2) return 0;
         
        int m1 = 0;
        int m2 = 0;
        
        while(v1!=v2) {
            if(m1>n && m2 >n) return -1;
            int p;
            if(v1 > v2) {
                p = dq1.pop();
                v1-=p;
                v2+=p;
                dq2.offer(p);
                m1++;
            }
            if(v1 < v2) {
                p = dq2.pop();
                v1+=p;
                v2-=p;
                dq1.offer(p);
                m2++;
            }
        }
        answer = m1+m2;
        return answer;
    }
    
}
