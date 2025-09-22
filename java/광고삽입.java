import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toTime(play_time.split(":"));
        int advTime  = toTime(adv_time.split(":"));

        if (advTime == 0 || advTime >= playTime) return "00:00:00";

        int[] ttt = new int[playTime];

        for (String log : logs) {
            String[] lgs = log.split("-");
            int s = toTime(lgs[0].split(":"));
            int e = toTime(lgs[1].split(":"));
            if (s < 0) s = 0;
            if (e > playTime) e = playTime;
            for (int i = s; i < e; i++) ttt[i]++;
        }

        long maxSum = 0;
        for (int i = 0; i < advTime; i++) maxSum += ttt[i];
        long curSum = maxSum;
        int maxIdx = 0;

        for (int i = 1; i <= playTime - advTime; i++) {
            curSum = curSum - ttt[i - 1] + ttt[i + advTime - 1];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxIdx = i;
            }
        }

        return timeToString(maxIdx);
    }

    int toTime(String[] times) {
        return Integer.parseInt(times[0]) * 3600
             + Integer.parseInt(times[1]) * 60
             + Integer.parseInt(times[2]);
    }

    String timeToString(int time) {
        int sec = time % 60;  time /= 60;
        int min = time % 60;  int hour = time / 60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}

