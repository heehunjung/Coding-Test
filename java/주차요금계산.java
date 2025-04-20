import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량별 입차 시간 저장
        Map<Integer, Integer> cars = new HashMap<>();
        // 차량별 총 주차 시간 저장
        Map<Integer, Integer> time = new TreeMap<>(); // 차량 번호 순으로 정렬
        
        // 1. 입출차 기록 처리
        for (String record : records) {
            String[] infos = record.split(" ");
            String[] times = infos[0].split(":");
            int h = Integer.parseInt(times[0]);
            int m = Integer.parseInt(times[1]);
            int num = Integer.parseInt(infos[1]);
            int totalMinutes = h * 60 + m;
            
            if (infos[2].equals("IN")) {
                cars.put(num, totalMinutes);
            } else {
                int inTime = cars.get(num);
                int duration = totalMinutes - inTime;
                time.put(num, time.getOrDefault(num, 0) + duration);
                cars.remove(num);
            }
        }
        
        // 2. 출차 기록 없는 차량 처리 (23:59까지)
        for (Map.Entry<Integer, Integer> entry : cars.entrySet()) {
            int carNum = entry.getKey();
            int inTime = entry.getValue();
            int duration = (23 * 60 + 59) - inTime;
            time.put(carNum, time.getOrDefault(carNum, 0) + duration);
        }
        
        // 3. 요금 계산
        List<Integer> answer = new ArrayList<>();
        for (int duration : time.values()) {
            answer.add(calPay(duration, fees));
        }
        
        // 4. 결과 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int calPay(int duration, int[] fees) {
        if (duration <= fees[0]) {
            return fees[1];
        }
        return fees[1] + (int) Math.ceil((double) (duration - fees[0]) / fees[2]) * fees[3];
    }
}
