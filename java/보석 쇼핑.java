import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int kind = (int) Arrays.stream(gems).distinct().count();  // 전체 보석 종류 수
        Map<String, Integer> gemMap = new HashMap<>();  // 현재 윈도우 내 보석 개수

        int[] answer = new int[] {1, gems.length};  // 초기값: 전체 구간
        int left = 0, right = 0;

        gemMap.merge(gems[0], 1, Integer::sum);  // 첫 보석 추가

        while (left <= right) {
            // 모든 종류 포함 + 구간 길이가 더 짧으면 갱신
            if (gemMap.size() == kind && right - left < answer[1] - answer[0]) {
                answer[0] = left + 1;
                answer[1] = right + 1;
            }

            // 아직 모든 종류를 포함하지 못했다면 오른쪽 확장
            if (gemMap.size() < kind) {
                if (++right == gems.length) break;
                gemMap.merge(gems[right], 1, Integer::sum);
            } 
            // 모든 종류 포함 중이면 왼쪽 줄여보기
            else {
                gemMap.merge(gems[left], -1, Integer::sum);
                if (gemMap.get(gems[left]) == 0) gemMap.remove(gems[left]);
                left++;
            }
        }

        return answer;
    }
}
