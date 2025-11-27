import java.util.*;

class Solution {
    Map<String, String> map = new HashMap<>();
    Map<String, Integer> money = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int num = enroll.length;
        int[] answer = new int[num];
        
        for(int i=0;i<num;i++) {
            map.put(enroll[i], referral[i]);
        }
        
        int sellNum = seller.length;
        
        for(int i=0;i<sellNum;i++) {
            dadan(seller[i], amount[i]*100);
        }
        
        for(int i=0;i<num;i++) {
            answer[i] = money.getOrDefault(enroll[i],0);
        }
        return answer;
    }
    
    void dadan(String people, int m) {
        if(m < 10) {
            money.put(people, money.getOrDefault(people, 0) + m);
            return;
        }
        
        int babun = (int)(m*(0.1));
        money.put(people, money.getOrDefault(people, 0) + m-babun);
        if(map.get(people).equals("-")) return;
        String parent = map.get(people);
        dadan(parent, babun);
    }
}
