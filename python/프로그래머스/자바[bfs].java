import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Deque<Integer> nextNode = new ArrayDeque<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++ ) {
            if(visited[i]==0)
                answer += network(nextNode,computers,visited,i,n);
        }
        
        return answer;
    }
    
    private int network(Deque<Integer> node,int[][] computers, int[] visited,int startNode,int n) {
        
        node.addFirst(startNode);
        while (!node.isEmpty()) {
            int current = node.removeFirst();
            visited[current] = 1;
            
            for(int i = 0; i < n ; i++) {
                if(computers[current][i]==1 && visited[i] == 0) {
                    node.addLast(i);
                    visited[i] = 1;
                }
            }
        }

        return 1;
    }
}