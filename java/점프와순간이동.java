public class Solution {
        
    public int solution(int n) {
        int ans = 1;
        while(n>2) {
            int na = n % 2;
            n /= 2;
            ans += na;
        }
        return ans;
    }  
}
