import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int max = 0;
        for(int i=numbers.length-1; i>=0;i--){
            if (i==numbers.length-1 || max <= numbers[i]){
                max = numbers[i];
                answer[i] = -1;
                continue;
            }            
            if(numbers[i+1] > numbers[i]) {
                answer[i] = numbers[i+1];
                continue;
            }
            boolean ok = true;
            for(int j=i+1; j<numbers.length-1;j++) {
                if(answer[j] > numbers[i]) {
                    ok = false;
                    answer[i] = answer[j];
                    break;
                }
            }
            if (ok) answer[i] = -1;
        }
        return answer;
    }
}
