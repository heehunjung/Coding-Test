// import java.util.*;

// class Solution {
//     public int solution(int n, int[][] computers) {
//         int answer = 0;
        
//         Deque<Integer> nextNode = new ArrayDeque<>();
//         int[] visited = new int[n];
        
//         // 모든 컴퓨터를 순차적으로 확인
//         for (int i = 0; i < n; i++) {
//             if (visited[i] == 0) {
//                 answer += network(nextNode, computers, visited, i, n);  // 새로운 네트워크를 찾으면 1 증가
//             }
//         }
        
//         return answer;  // 네트워크 개수 반환
//     }
    
//     private int network(Deque<Integer> node, int[][] computers, int[] visited, int startNode, int n) {
//         node.addLast(startNode);  // 시작 노드를 큐에 넣음
        
//         while (!node.isEmpty()) {
//             int current = node.removeFirst();  // 큐에서 노드를 꺼냄
            
//             if (visited[current] == 1) {  // 이미 방문한 노드는 무시
//                 continue;
//             }
            
//             visited[current] = 1;  // 큐에서 꺼낸 시점에 방문 처리

//             // 현재 노드와 연결된 다른 노드들을 탐색
//             for (int i = 0; i < n; i++) {
//                 if (computers[current][i] == 1 && visited[i] == 0) {
//                     node.addLast(i);  // 아직 방문하지 않은 노드를 큐에 추가
//                 }
//             }
//         }

//         return 1;  // 새로운 네트워크를 찾았으므로 1 반환
//     }
// }

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int[] visited = new int[n];
        
        // 모든 컴퓨터(노드)를 순차적으로 탐색
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {  // 아직 방문하지 않은 노드를 만나면 DFS 시작
                dfs(computers, visited, i, n);  // 해당 노드와 연결된 모든 노드를 탐색
                answer++;  // 하나의 네트워크를 탐색했으므로 네트워크 개수 증가
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, int[] visited, int currentNode, int n) {
        
        visited[currentNode] = 1;
        // 방문 처리
        
        // 현재 노드와 연결된 다른 노드들을 재귀적으로 방문
        for (int i = 0; i < n; i++) {
            if (computers[currentNode][i] == 1 && visited[i] == 0) {  // 연결되어 있고 아직 방문하지 않은 노드라면
                dfs(computers, visited, i, n);  // 재귀 호출로 연결된 노드를 탐색
            }
        }
        
    }
}
