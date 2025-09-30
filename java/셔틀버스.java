import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 1) 크루 도착 시간 분 단위로 변환하여 정렬
        int[] arr = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            arr[i] = toTime(timetable[i]); // 분
        }
        Arrays.sort(arr);

        int busTime = toTime("09:00");
        int idx = 0;                 // 아직 탑승하지 않은 첫 크루 인덱스
        int answer = 0;                  // 정답(분)

        for (int bus = 0; bus < n; bus++) {
            int boarded = 0;
            // 2) 이번 버스에 도착 시간이 busTime 이하인 크루를 최대 m명 태움
            while (idx < arr.length && arr[idx] <= busTime && boarded < m) {
                idx++;
                boarded++;
            }

            // 3) 마지막 버스일 때 정답 계산
            if (bus == n - 1) {
                if (boarded < m) {
                    // 자리가 남았으면 버스 시간에 와도 됨
                    answer = busTime;
                } else {
                    // 꽉 찼으면 마지막으로 탄 크루보다 1분 빠르게
                    answer = arr[idx - 1] - 1;
                }
            }

            busTime += t; // 다음 버스 출발 시간
        }

        return formatTime(answer);
    }

    private int toTime(String hhmm) {
        String[] p = hhmm.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    private String formatTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }
}

