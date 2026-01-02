class Solution {
    public long solution(int w, int h) {
        long W = (long)w;
        long H = (long)h;
        
        long tc = W * H;

        long uc = W + H - gcd(w, h);
        
        return tc - uc;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
