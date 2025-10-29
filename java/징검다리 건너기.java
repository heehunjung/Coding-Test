import java.util.*;

class Solution {

    public int solution(int[] stones, int k) {
        int left = 0;
        int rigth = 0;
        for(int st: stones) rigth = Math.max(rigth, st);
        
        while(left < rigth) {
            int mid = (left + rigth)/2;
            if(check(mid,k,stones)) left = mid+1;
            else rigth = mid;
        }
        return left;
    }
    
    boolean check(int mid,int k,int[] stones) {
        int cnt = 0;
        int max = 0;
        
        for(int st: stones) {
            int x = st-mid;
            if(x <= 0) cnt++;
            else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }
        max = Math.max(max, cnt);
        if(max < k) return true;
        return false;
    }
}
