import java.util.*;

class Solution {
    List<Integer> kNums;
    int answer = 0;
    
    public int solution(int n, int k) {
        kNums = toKnum(n,k);
        String s = "";
        
        for(int i=kNums.size()-1;i>=-1;i--) {
            
            if (i == -1) {
                if (kNums.get(0)!=0) {
                    cal(s, i+1);
                    // System.out.println(s);
                }
                break;
            }
            int cnt = kNums.get(i);
            if (cnt == 0) {
                if (!s.equals("")) {
                    cal(s, i+1);
                }
                s = "";
            } else {
                s = s + cnt;
            }
        }
        return answer;
    }
    
    private List<Integer> toKnum(int n, int k) {
        List<Integer> kNums = new ArrayList<>();
        while(n >= k) {
            kNums.add(n%k);
            n = n / k;
        }
        kNums.add(n);
        return kNums;
    }
    
    private boolean isPrimeNum(long n) {
        long nn = (long)Math.pow(n,0.5)+1;
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for(long i=2;i<=nn;i++) {
            if (n%i == 0) {
                return false;
            } 
        }
        return true;
    }
    
    private boolean check(long n, int idx, int length) {
        int l = idx-1;
        int r = idx + length;
        
        //p  
        if (l== -1 && r == kNums.size()) {
            return true;
        }
        
        if (l >= 0 && kNums.get(l)==0) {
            return true;
        }
        if (r < kNums.size() && kNums.get(r)==0) {
            return true;
        }
        return false;
    }
    
    private void cal(String s, int i) {
        long now = Long.parseLong(s);
        if (isPrimeNum(now)) {
            if (check(now, i, s.length())) {
                answer += 1;
            }
        }
    }
}
