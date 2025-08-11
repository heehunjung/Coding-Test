import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<String> ums = new ArrayList<>();
        
        // 파싱
        String prev = "";
        for(String a: m.split("")) {
            if(a.equals("#")) {
                ums.remove(ums.size() - 1);
                ums.add(prev+a);
            } else {
            prev = a;
            ums.add(a);
            }
        }

        int ctime = 0;
        //do logic
        for(String c: musicinfos) {
            String[] infos = c.split(",");
            int radioTime = convert(infos[0], infos[1]);
            
            if(check(radioTime, infos[3], ums)) {
                // System.out.println(infos[2]);
                if(ctime < radioTime) {
                    answer = infos[2];
                    ctime = radioTime;
                }
                // System.out.println(answer + ", " + ctime);
            }
        }
        
        if(answer == "") answer = "(None)";
        
        return answer;
    }
    
    boolean check(int time, String um, List<String> ums) {
        int size = um.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<time;i++) {
            sb.append(um.charAt(i%size));
        }
        String total = sb.toString();
        // System.out.println(total);
        for(int i=0; i<time;i++) {
            if(i+ums.size() > total.length()) break;
            if(total.charAt(i) == '#') continue;
            int idx = i;
            boolean isOk = true;
            for(String s: ums) { 
                if(idx-i >= ums.size()) return true;
                String a = String.valueOf(total.charAt(idx++));
                if(idx < total.length() && total.charAt(idx) == '#'){
                    a += String.valueOf(total.charAt(idx++));
                }
                if(!s.equals(a)) {
                    isOk = false;
                    break;
                } 
            }
            if(isOk) return true;
        }
        return false;
    }
    
    int convert(String a, String b) {
        String[] h1 = a.split(":");
        String[] h2 = b.split(":");
        // if(h2[0].equals("00") && h2[1].equals("00")) h2[0] = "24";
        return Integer.valueOf(h2[0]) * 60 + Integer.valueOf(h2[1]) - Integer.valueOf(h1[0]) * 60 - Integer.valueOf(h1[1]); 
    }
}
