import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<int[]> li = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        for(String[]bt: book_time) {
            int f = toTime(bt[0]);
            int s = toTime(bt[1]);
            pq.offer(new int[]{f,s+10});
        }
        while (!pq.isEmpty()) {
            int[] tt = pq.poll();   // 시작 시간이 가장 빠른 예약 꺼내기

            if (li.isEmpty()) {
                li.add(tt);
                continue;
            }

            boolean hasRoom = false;
            for (int[] room : li) {
                // 빈 방 찾기
                if (room[1] <= tt[0]) {
                    // 이 방을 새 예약으로 갱신해야 함
                    room[1] = tt[1]; 
                    hasRoom = true;
                    break;
                }
            }
            if (!hasRoom) {
                li.add(new int[]{tt[0], tt[1]});
            }
        }
        
        return li.size();
    }
    
    int toTime(String time) {
        String[] times = time.split(":");
        
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }
}
