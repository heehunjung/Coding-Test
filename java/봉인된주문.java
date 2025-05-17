import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long target = n;
        Arrays.sort(bans, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        for(String ban: bans) {
            long current = calNum(ban) ;
            if (current <= target) {
                target += 1;    
            }
        }
        
        return findBan(target);
    }
    
    private long calNum(String ban) {
        char[] c = ban.toCharArray();
        long result = 0;
        int length = c.length -1;
        for(char cc: c) {
            int cnt = cc -'a' + 1;
            result += Math.pow(26,length) * cnt;
            length -=1;
        }
        return result;
    }   
    private String findBan(long num) {
        StringBuilder sb = new StringBuilder();

        while(num >= 26) {
            long remain = num % 26;
            if (remain == 0) {
                sb.insert(0,'z');
                num -= 1;
            } else {
                sb.insert(0, (char)('a'+(remain)-1));
            }
            num = num/ 26;
        }
        sb.insert(0, (char)('a'+(num)-1));
        return sb.toString();
    }
}

