import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int maxNode = 0;
        for(int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];
        
        for(int[] edge : edges) {
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        
        for(int i = 1; i <= maxNode; i++) {
            
            // 생성된 정점 찾기: 들어오는 건 없고, 나가는 게 2개 이상
            if(inDegree[i] == 0 && outDegree[i] >= 2) {
                answer[0] = i;
            }
            // 막대 그래프 찾기: 나가는 간선이 없는 노드 개수 세기
            else if(outDegree[i] == 0) {
                answer[2]++;
            }
            // 8자 그래프 찾기: 들어오는 거 2개 이상, 나가는 거 2개인 노드 개수 세기
            else if(inDegree[i] >= 2 && outDegree[i] >= 2) {
                answer[3]++;
            }
        }
        

        if(answer[0] != 0) {
            int totalGraphs = outDegree[answer[0]];
            answer[1] = totalGraphs - answer[2] - answer[3];
        }
        
        return answer;
    }
}
