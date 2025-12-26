import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int l=0;
        int r=0;
        int max = sequence.length;
        int v = sequence[0];
        int before_len = Integer.MAX_VALUE;
        while(l<max) {
            if(v==k) {
                int len = r-l+1;
                if(len < before_len) {
                    answer[0] = l;
                    answer[1] = r;
                    before_len = len;
                }
            }   
            if(v>k) {
                v-=sequence[l];
                l++;
                continue;
            }
            if(v<=k) {
                if(r==max-1) break;
            }
            if(r<max-1) {
                r++;
                v+=sequence[r];
            }
        }
        
        return answer;
    }
}
