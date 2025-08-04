import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> skills = new HashMap<>();
        int idx = 0;
        for (char sk : skill.toCharArray()) {
            skills.put(sk, idx++);
        }
        for(String tree: skill_trees) {
            int currentIdx = -1;
            boolean isOk = true;
            for(char s: tree.toCharArray()) {
                if (skills.containsKey(s)) {
                    int temp = skills.get(s);
                    if(currentIdx == -1) {
                        if(temp == 0) currentIdx = 0;
                        else {
                            isOk = false; 
                            break;
                        }
                    } else {
                        if (temp == currentIdx + 1) currentIdx = temp;
                        else {
                            isOk = false;
                            break;
                        }
                    }
                }
            }
            
            if(isOk) answer ++;
        }
        return answer;
    }
}
