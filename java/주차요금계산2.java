import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> cars = new HashMap<>();
        Map<Integer, Integer> time = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (String record : records) {
            String[] infos = record.split(" ");
            String[] times = infos[0].split(":");
            int h = Integer.parseInt(times[0]);
            int m = Integer.parseInt(times[1]);
            int num = Integer.parseInt(infos[1]);
            if (infos[2].equals("IN")) {
                int total = h * 60 + m;
                cars.put(num, total);
            } else {
                int duration = h * 60 + m - cars.get(num);
                if (time.containsKey(num)) {
                    time.put(num, time.get(num) + duration);
                } else {
                    time.put(num, duration);
                }
                cars.remove(num);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : cars.entrySet()) {
            int carNum = entry.getKey();
            if (time.containsKey(carNum)) {
                continue;
            }
            int duration = (23 * 60 + 59) - entry.getValue();
            pq.offer(new int[]{carNum, calPay(duration, fees)});
        }
        
        for (Map.Entry<Integer, Integer> entry : time.entrySet()) {
            int carNum = entry.getKey();
            int duration = entry.getValue();
            if (cars.containsKey(carNum)) {
                duration += (23 * 60 + 59) - cars.get(carNum);
                cars.remove(carNum);
            }
            pq.offer(new int[]{carNum, calPay(duration, fees)});
        }
        
        int isBefore = -1;
        int totalPay = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int carNum = cur[0];
            int pay = cur[1];
            
            if (isBefore == carNum) {
                totalPay += pay;
            } else {
                answer.add(totalPay);
                totalPay = pay;
                isBefore = carNum;
            }
        }
        answer.add(totalPay);
        answer.remove(0);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int calPay(int duration, int[] fees) {
        int pay = 0;
        if (duration > fees[0]) {
            pay = fees[1] + (int) Math.ceil((double)(duration - fees[0]) / fees[2]) * fees[3];
        } else {
            pay = fees[1];
        }
        return pay;
    }
}
