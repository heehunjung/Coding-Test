import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int total = convertToTime(video_len.split(":"));
        int current = convertToTime(pos.split(":"));
        int op_s = convertToTime(op_start.split(":"));
        int op_f = convertToTime(op_end.split(":"));
        
        for(String cmd: commands) {
            // isOpening 
            if(op_s <= current && current < op_f) {
                current = op_f;
            }
            
            // prev
            if (cmd.equals("prev")) current -= 10;
            
            // next
            else if (cmd.equals("next")) current += 10;
            if (current < 10) current = 0;
            if (current > total-10) current = total;

        }
        
        // isOpening 
        if(op_s <= current && current < op_f) {
            current = op_f;
        }
        
        return convertToStr(current);
    }
    
    private int convertToTime(String[] time) {
        int m = Integer.parseInt(time[0]);
        int s = Integer.parseInt(time[1]);  
        
        return m*60 + s;
    }
    
    private String convertToStr(int total) {
        int m = total / 60;
        int s = total % 60;

        return String.format("%02d:%02d", m, s);
    }
}
