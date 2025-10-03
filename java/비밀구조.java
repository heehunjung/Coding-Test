import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        boolean[] cd = new boolean[n];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0;i<n;i++) {
            cal(cd, arr1[i]);
            cal(cd, arr2[i]);
            for(boolean c: cd) {
                if(c) sb.append("#");
                else sb.append(" ");
            }
            answer[index++] = sb.toString();
            sb.setLength(0);
            cd = new boolean[n];
        }
        return answer;
    }
    
    void cal(boolean[] cd, int a) {
        int idx = cd.length-1;
        while(a > 0) {
            int c = a%2;
            a = a/2;
            if(c==1) cd[idx] = true;
            idx--;
        }

    }
}
