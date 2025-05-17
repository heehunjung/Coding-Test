import java.util.*;

class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        int length = diffs.length;
        int f = 1;
        int l = Arrays.stream(diffs).max().getAsInt();
        long time;
        long time_prev;
        int mid = 0;
        while(f <= l) {
            mid = (f+l) / 2;
            time = 0;
            time_prev = 0;
            for(int i=0;i<length;i++) {
                if(diffs[i] <= mid) {
                    time += times[i];
                } else {
                    int repeat = diffs[i]-mid;
                    time += (times[i]+time_prev)*(repeat);
                    time += times[i];
                }
                time_prev = times[i];
            }
            if(time == limit) break;
            if (time < limit) {
                l = mid-1;
            } 
            if (time > limit){
                f = mid+1;
                if(f > l) mid += 1;
            }
        }
        return mid;
    }
}
