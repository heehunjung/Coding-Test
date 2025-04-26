import java.util.*;

class Solution {
    private int[][] length_2 = {{2,0}, {0,2},{-2,0},{0,-2}};
    private int[][] between = {{1,0}, {0,1},{-1,0},{0,-1}};
    private int[][] length_1_1 = {{1,1}, {-1,1}, {-1,-1}, {1,-1}};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5;i++) {
            answer[i]=cal(Arrays.toString(places[i]));
        }
        return answer;
    }
    
    private int cal(String place) {
        String[] current = place.replaceAll("\"", "")
                            .replaceAll("\\[", "")
                            .replaceAll("\\]", "")
                            .replaceAll("\\s+", "")
                            .split(",");        
        String[][] currentPlace = new String[5][5];
        
        for(int i=0;i<5;i++){
            currentPlace[i] = current[i].split("");
        }
        
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++){
                if (currentPlace[i][j].equals("P")) {
                    boolean isOk = true;
                    for(int[]next: between) {
                        int nextX = i+next[0];
                        int nextY = j+next[1];
                        if (0<=nextX && nextX <5 && 0<=nextY && nextY < 5) {
                            if(currentPlace[nextX][nextY].equals("P")) {
                                return 0;
                            }   
                        }
                    }
                    
                    for(int k=0;k<4;k++) {
                        int xPlus = i+length_2[k][0];
                        int yPlus = j+length_2[k][1];
                        int xPlus1 = i+length_1_1[k][0];
                        int yPlus1 = j+length_1_1[k][1];
                        
                        if (isValid(xPlus, yPlus,currentPlace)) {
                            if(currentPlace[i+between[k][0]][j+between[k][1]].equals("O")) {
                                isOk = false;
                                break;
                            }
                        }
                        if (isValid(xPlus1,yPlus1,currentPlace)) {
                            if(currentPlace[i+length_1_1[k][0]][j].equals("O") || currentPlace[i][j+length_1_1[k][1]].equals("O")) {
                                isOk = false;
                                break;
                            }                 
                        } 
                    }
                    if (!isOk) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    private boolean isValid(int x, int y, String[][] cp) {
        if (0 <= x && x < 5 && 0 <= y && y < 5) {
            if(cp[x][y].equals("P")) {
                return true;
            }
        }
        return false;
    }
}
