import java.util.*;

class Solution {
    List<Integer> result = new ArrayList<>();
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        apchuk(arr, 0, 0, arr.length);
        return answer;
    }
     
    void apchuk(int[][] arr, int x, int y, int size) {
        int num = arr[x][y];
        // 종료 조건 
        if(size == 1) {
            if(num == 1) answer[1] += 1;
            if(num == 0) answer[0] += 1;
            return;
        }
        
        for(int i=x;i<x+size;i++) {
            for(int j=y;j<y+size;j++) {
                if (num != arr[i][j]) {
                    apchuk(arr, x, y, size/2); // 좌상
                    apchuk(arr, x+size/2, y, size/2); // 우상
                    apchuk(arr, x, y+size/2, size/2);
                    apchuk(arr, x+size/2, y+size/2, size/2);
                    return;
                }
            }
        }
        
        if(num == 1) answer[1] += 1;
        if(num == 0) answer[0] += 1;
        return;
    }   
}
