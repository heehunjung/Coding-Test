import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int max = Arrays.stream(citations).max().getAsInt();
        int min = 0;
        int answer = 0;
        int result = 0;
        while(min <= max) {
            answer = (max + min)/2;
            if(hIndex(answer, citations)) {
                min = answer + 1;
                result = answer;
            } else {    
                max = answer - 1;
            }
        }
        
        return result;
    }
        
    boolean hIndex(int h, int[] cita) {
        int count = 0;
        for(int ct: cita) {
            if (ct >= h) count++;
        }
        
        if (count >= h) return true;
        return false;
    }
}
