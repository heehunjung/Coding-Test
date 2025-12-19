import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = starts.clone();
        Arrays.sort(temp);
        
        int[] divNums = new int[e+1];
        for(int i=1;i<=e;i++) {
            for(int j=1;j<=e;j++) {
                int cntNum = i*j;
                if(cntNum > e) break;
                divNums[cntNum]++;
            }
        }
        
        
        int[] maxInfo = new int[]{e, divNums[e]};
        map.put(e, e);
        int idx = temp.length-1;
        for(int i=e;i>=temp[0];i--) {
            int cntCounts = divNums[i];
            if(cntCounts >= maxInfo[1]) {
                maxInfo[0] = i;
                maxInfo[1] = cntCounts;
            }
            
            if(i == temp[idx]) {
                map.put(i, maxInfo[0]);
                idx--;
            }
        }
        
        for(int i=0;i<starts.length;i++) {
            answer[i] = map.get(starts[i]);
        }
        return answer;
    } 
}
