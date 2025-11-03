import java.util.*;

class Solution {

    public int solution(int[] a) {
        int len = a.length;

        int[] prefixMin = new int[len];  
        int[] suffixMin = new int[len];  

        prefixMin[0] = a[0];
        for (int i = 1; i < len; i++) {
            prefixMin[i] = Math.min(a[i], prefixMin[i - 1]);  
        }

        suffixMin[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(a[i], suffixMin[i + 1]);  
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] == prefixMin[i] || a[i] == suffixMin[i]) count++;  
        }

        return count;
    }
}
