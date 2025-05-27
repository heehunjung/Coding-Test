import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int fullHP = health;
        int t = attacks[0][0];
        
        int idx=0;
        int ss=0;
        while(true) {
            boolean isAttacked = false;
            if (t == attacks[idx][0]) {
                health -= attacks[idx][1];
                ss = 0;
                idx += 1;
                isAttacked = true;
            }
            
            if(!isAttacked) {
                ss += 1;
                health += bandage[1];

                if(ss == bandage[0]) {
                    ss = 0;
                    health += bandage[2];
                }  
            }
            
            if(idx == attacks.length) {
                if (health > 0) answer = health;
                else answer = -1;
                break;
            }
            
            if (health >= fullHP) health = fullHP;    
            if (health <=0) return -1;
            t++; 
        }
        return answer;
    }
}
