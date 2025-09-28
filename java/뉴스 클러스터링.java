import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String myStr1 = str1.toLowerCase();
        String myStr2 = str2.toLowerCase();
        List<String> p1 = new ArrayList<>();
        List<String> p2 = new ArrayList<>();
        
        List<String> sl = new ArrayList<>();
        Map<String,Integer> pm1 = new HashMap<>();
        Map<String,Integer> pm2 = new HashMap<>();
        
        addList(myStr1, p1);
        addList(myStr2, p2);
        
        float t = p1.size() + p2.size();
        if(t==0) return 65536;
        
        float c = 0;
        for(String f: p1) {
            for(String s:p2) {
                if(f.equals(s)&& !sl.contains(f)) {
                    sl.add(s);
                    pm1.put(s, 0);
                    pm2.put(s, 0);
                }
            }
        }
        
        for(String f: p1) {
            if(pm1.containsKey(f)) {
                pm1.put(f, pm1.get(f)+1);
            }
        }        
        for(String f: p2) {
            if(pm2.containsKey(f)) {
                pm2.put(f, pm2.get(f)+1);
            }
        }
        
        for(String key: sl) {
            c += Math.min(pm1.get(key), pm2.get(key));
        }
        t -= c;
        
        float r = c/t;
        return (int)(r*65536);
    }
    
    void addList(String str, List<String> p) {
        for(int i=0;i<str.length()-1;i++) {
            char f = str.charAt(i);
            char s = str.charAt(i+1);
            if('a' <= f && f <= 'z' && 'a' <= s && s <= 'z') {
                 p.add(""+f+s);
            }
        }
    }
}
