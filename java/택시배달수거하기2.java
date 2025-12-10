import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int lastIdx = 0;
        
        for(int i=n-1;i>=0;i--) {
            if(deliveries[i]!=0 || pickups[i]!=0) {
                lastIdx = i;
                break;
            }
            if(i==0) lastIdx = -1;
        }
        
        int lastD = lastIdx; 
        int lastP = lastIdx;
        
        while(lastIdx >= 0) {
            answer += (lastIdx+1)*2;
            lastD = doWork(lastD, cap, deliveries);
            lastP = doWork(lastP, cap, pickups);
            lastIdx = Math.max(lastD,lastP);
        }
        
        return answer;
    }
    
    int doWork(int idx,int cap,int[] arr) {
        int result = -1;
        for(int i=idx;i>=0;i--) {
            if(arr[i] >= cap) {
                arr[i] -= cap;
                cap = 0;
            } else {
                cap -= arr[i];
                arr[i] = 0;
            }
            
            if(cap == 0) {
                int cnt = i;
                while(cnt >= 0){
                    if(arr[cnt]!=0) return cnt;
                    cnt--;
                }
                return result;
            }
        }
        return result;
    }
}
