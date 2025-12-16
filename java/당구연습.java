import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int idx = 0;
        for(int[] ball: balls) {
            answer[idx++] = cal(startX,startY,ball[0],ball[1],m,n);
        }
        return answer;
    }
    
    int cal(int x, int y, int nx, int ny, int m, int n) {
        int xx = Math.abs(x-nx);
        int yy = Math.abs(y-ny);
        int result = 0;
        if(xx != 0) {
            int tempY = Math.min(y+ny, 2*n-y-ny);
            result = xx*xx + tempY*tempY;
        } else {
            if(ny > y) result = (y+ny)*(y+ny);
            else result = (2*n-y-ny)*(2*n-y-ny);
        }
        int next = 0;
        if(yy != 0) {
            int tempX = Math.min(x+nx, 2*m-x-nx);
            next = yy*yy+tempX*tempX;
        } else {
            if(nx > x) next = (x+nx)*(x+nx);
            else next = (2*m-x-nx)*(2*m-x-nx);
        }
        
        result = Math.min(result, next);
        
        return result;
    }
}
