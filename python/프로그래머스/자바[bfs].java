import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Deque<Integer> nextNode = new ArrayDeque<>();
        int[] visited = new int[n];
        
        // 모든 컴퓨터를 순차적으로 확인
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer += network(nextNode, computers, visited, i, n);  // 새로운 네트워크를 찾으면 1 증가
            }
        }
        
        return answer;  // 네트워크 개수 반환
    }
    
    private int network(Deque<Integer> node, int[][] computers, int[] visited, int startNode, int n) {
        node.addLast(startNode);  // 시작 노드를 큐에 넣음
        
        while (!node.isEmpty()) {
            int current = node.removeFirst();  // 큐에서 노드를 꺼냄
            
            if (visited[current] == 1) {  // 이미 방문한 노드는 무시
                continue;
            }
            
            visited[current] = 1;  // 큐에서 꺼낸 시점에 방문 처리

            // 현재 노드와 연결된 다른 노드들을 탐색
            for (int i = 0; i < n; i++) {
                if (computers[current][i] == 1 && visited[i] == 0) {
                    node.addLast(i);  // 아직 방문하지 않은 노드를 큐에 추가
                }
            }
        }

        return 1;  // 새로운 네트워크를 찾았으므로 1 반환
    }
}
