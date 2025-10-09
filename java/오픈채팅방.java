import java.util.*;
    
class Solution {
    final String enter = "님이 들어왔습니다.";
    final String exit = "님이 나갔습니다.";
    Map<String, String> names = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[] record) {
        String[] answer;
        for(String rc: record) {
            String[] rcs = rc.split(" ");
            doLogic(rcs);
        }
        
        answer = new String[result.size()];
        int idx = 0;
        
        for(String r: result) {
            String[] rr = r.split(" ");
            String word;
            if(rr[1].equals("e")) word = enter;
            else word = exit;
            
            answer[idx++] = names.get(rr[0]) + word;
        }
        return answer;
    }
    
    void doLogic(String[] rr) {
        String cmd = rr[0];
        String uuid = rr[1];
        String nick;
        if(cmd.equals("Enter")) {
            nick = rr[2];
            names.put(uuid, nick);
            result.add(uuid + " e");
        }
        if(cmd.equals("Leave")) {
            result.add(uuid + " l");
            
        }
        if(cmd.equals("Change")) {
            nick = rr[2];
            names.put(uuid, nick);
        }
    }
}
