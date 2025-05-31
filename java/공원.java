import java.util.*;

class Solution {
    int answer = -1;
    String[][] myPark;
    int[] myMats;
    public int solution(int[] mats, String[][] park) {
        myPark = park;
        Arrays.sort(mats);
        myMats = mats;
        for(int i=0;i<park.length;i++) {
            for(int j=0;j<park[0].length;j++) {
                if(park[i][j].equals("-1")) {
                    mat(i,j,mats[0], 0);
                }
            }
        }
        return answer;
    }

    private void mat(int i, int j, int size, int idx) {
        int max = Math.min(myPark.length-i,myPark[0].length-j);
        if(max < size) return;
        for(int x=i; x<i+size ; x++) {
            for(int y=j; y<j+size ; y++) {
                if(!myPark[x][y].equals("-1")) {
                    return;
                }
            }
        } 
        answer = Math.max(answer, size);
        if(idx+1 == myMats.length) return;
        mat(i,j,myMats[idx+1],idx+1);
    }
}
