import java.util.*;
    
class Solution {
    
    public int solution(int[] numbers, int target) {
        int answer = dfs(target, numbers, 0, numbers[0]);
        answer += dfs(target, numbers, 0, -1*numbers[0]);
        return answer;
    }
    
    
    public int dfs(int target ,int[] numbers ,int index, int value) {
        if (index==(numbers.length-1)) {
            return value == target ? 1:0;
        }
        
        int plus = dfs(target, numbers, index+1, value+numbers[index+1]);
        int minus = dfs(target, numbers, index+1, value-numbers[index+1]);
        
        return plus + minus;
    }
}
