class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        int startTime = toSeconds(h1, m1, s1);
        int endTime = toSeconds(h2, m2, s2);
        
        for (int i = startTime; i < endTime; i++) {
            
            double curSec = getSecAngle(i);
            double curMin = getMinAngle(i);
            double curHour = getHourAngle(i);
            
            double nextSec = getSecAngle(i + 1);
            double nextMin = getMinAngle(i + 1);
            double nextHour = getHourAngle(i + 1);
            
            if (nextSec == 0) nextSec = 360;
            if (nextMin == 0) nextMin = 360;
            if (nextHour == 0) nextHour = 360;
            
            boolean passMin = false;
            if (curSec < curMin && nextSec >= nextMin) {
                passMin = true;
                answer++;
            }
            
            boolean passHour = false;
            if (curSec < curHour && nextSec >= nextHour) {
                passHour = true;
                answer++;
            }
            
            if (passMin && passHour) {
                if (nextMin == nextHour) {
                    answer--;
                }
            }
        }
        
        if (startTime == 0 || startTime == 12 * 3600) {
            answer++;
        }
        
        return answer;
    }
    
    private int toSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    private double getSecAngle(int time) {
        return (time % 60) * 6.0;
    }
    
    private double getMinAngle(int time) {
        return (time % 3600) * 0.1; 
    }
    
    private double getHourAngle(int time) {
        return (time % 43200) * (360.0 / 43200); // 1초에 1/120도
    }
}

