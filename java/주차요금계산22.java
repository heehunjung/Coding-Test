import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for (String record : records) {
            String[] info = record.split(" ");
            int time = parseTime(info[0]);
            String carNum = info[1];
            String status = info[2];

            if (status.equals("IN")) {
                inTimeMap.put(carNum, time);
            } else {
                int parkedTime = time - inTimeMap.remove(carNum);
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
            }
        }

        int lastTime = parseTime("23:59");
        for (String carNum : inTimeMap.keySet()) {
            int parkedTime = lastTime - inTimeMap.get(carNum);
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + parkedTime);
        }

        int[] answer = new int[totalTimeMap.size()];
        int idx = 0;
        for (int totalTime : totalTimeMap.values()) {
            if (totalTime <= baseTime) {
                answer[idx++] = baseFee;
            } else {

                int overTime = totalTime - baseTime;
                int extraFee = (int) Math.ceil((double) overTime / unitTime) * unitFee;
                answer[idx++] = baseFee + extraFee;
            }
        }

        return answer;
    }

    private int parseTime(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
