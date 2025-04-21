import java.util.*;

class Solution {
    private int[] result = new int[]{-1};
    private int[] rion = new int[11];
    private int[] apeach = new int[11];
    private int max = 0;
    private int maxDiff = -1;
    
    public int[] solution(int n, int[] info) {
        for (int i=0; i<11;i++) {
            apeach[i]=info[i];
        }
        max = n;
        dfs(0,0);

        return result;
    }
    
    public void dfs(int idx, int count){  
        if (idx == 11){
            if (count == max) {
                int[] sums = cal();
                int r = sums[0];
                int a = sums[1];
                if (r-a > 0) {
                    if (r - a > maxDiff) {
                        maxDiff = r - a;
                        result = rion.clone();
                    } else if((r - a) == maxDiff) {
                        System.out.println();
                        for (int i=10;i>=0;i--) {
                            if(rion[i] > result[i]) {
                                result = rion.clone();
                                break;
                            } else if(rion[i] < result[i]) {
                                break;
                            }
                        }
                    }
                }
            }
            return;
        }
        
        // RION이 해당 점수 먹는 경우
        if (count+apeach[idx]+1 <= max) {
            rion[idx] = apeach[idx] + 1;
            dfs(idx+1, count+apeach[idx]+1);
            rion[idx] = 0;
        }
        
        //RION이 점수 그냥 넘어가는 경우
        for (int i=0;i<=apeach[idx];i++) {
            if (count+i<=max){
                rion[idx] = i;
                dfs(idx+1, count+i);
                rion[idx] = 0;
            }
        }   
    }
    
    private int[] cal() {
        int r = 0;
        int a = 0;
        for (int i=0; i<= 10; i++) {
            if(rion[i] > 0) {
                if (apeach[i] >= rion[i]) {
                     a += 10-i; 
                } else {
                    r += 10-i;
                }
            } else {
                if(apeach[i] > 0) {
                    a += 10-i;
                }
            }
        }
        return new int[]{r, a};
    }
}
