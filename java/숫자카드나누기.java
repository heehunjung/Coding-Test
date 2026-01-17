class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int aa = arrayA[0];
        int bb = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            aa = gcd(aa, arrayA[i]);
            bb = gcd(bb, arrayB[i]);
        }
        
        int answer = 0;

        if (isNotDivisible(arrayB, aa)) {
            answer = Math.max(answer, aa);
        }

        if (isNotDivisible(arrayA, bb)) {
            answer = Math.max(answer, bb);
        }

        return answer;
    }

    private boolean isNotDivisible(int[] array, int v) {
        if (v <= 1) return false; 
        for (int num : array) {
            if (num % v == 0) return false;
        }
        return true;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
