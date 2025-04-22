import java.util.*;

class Solution {
    private int max = 2;
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start = 0, last = -1;
        
        for(int k = (people.length-1); k>=0; k--) {
            if(people[k]+people[0] <= limit) {
                last = k;
                break;
            }
        }
        // if (last == -1) {
        //     return people.length-1;
        // }
        answer += (people.length-1-last);
        
        while(start<=last) {
            // 같아진 경우
            if (start == last) {
                answer+=1;
                break;
            }
            // 양 끝에서 2명 태울 수 있는 경우
            if(people[start]+people[last]<=limit) {
                start += 1;
                last -= 1;
                answer += 1;
                continue;
            }
            // 2명 못태우는 경우 
            last -= 1;
            answer += 1;
        }
        return answer;
    }
}
