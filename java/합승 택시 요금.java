import java.util.*;
class Solution {
    ArrayList<int[]>[] graph;
    static final int max = 100000 * 200; // 1 <= f <= 100000 , 3 <= n <= 200
    static int answer = max;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < fares.length; i++){
            int v1 = fares[i][0];
            int v2 = fares[i][1];
            int m  = fares[i][2]; 
            graph[v1].add(new int []{v2, m});
            graph[v2].add(new int []{v1, m});
        }
        
        // s -> 모든 지점 다익스트라 시작 
        int [] distance = new int [n+1];
        Arrays.fill(distance, max);
        PriorityQueue<int [] > pq = new PriorityQueue<>((o1,o2) -> {
           return o1[1] - o2[1];  // 누적 거리가 적은 순서대로  
        });
        
        distance[s] = 0;
        pq.add(new int []{s, 0}); // 시작 지점 pq 삽입
        
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            if(distance[cur[0]] != cur[1]) continue; // 기록된 최단거리가 아닌 경우 continue
            for(int i = 0; i < graph[cur[0]].size(); i++){
                int [] next = graph[cur[0]].get(i);
                if(distance[next[0]] > distance[cur[0]] + next[1]){
                    distance[next[0]] = distance[cur[0]] + next[1];
                    pq.add(new int []{next[0], distance[cur[0]] + next[1]}); // pq 추가 
                }
            }
        }
        // 각자 택시 경우 answer 갱신
        answer = Math.min(answer, distance[a] + distance[b]);
        
        // S -> I  + I -> A + I -> B
        for(int i = 1; i <= n; i++){ // 중간 지점 잡기 
            if(i == s) continue;
            int sum = 0;
            sum = distance[i];
            // 다익스트라 추가로 진행 i -> A and i -> B
            int [] record = new int [n+1];
            Arrays.fill(record, max);
            record[i] = 0;

            pq.add(new int []{i, 0}); 
            while(!pq.isEmpty()){
                int [] cur = pq.poll();
                if(record[cur[0]] != cur[1]) continue; // 기록된 최단거리가 아닌 경우 continue
                for(int j = 0; j < graph[cur[0]].size(); j++){
                    int [] next = graph[cur[0]].get(j);
                    if(record[next[0]] > record[cur[0]] + next[1]){
                        record[next[0]] = record[cur[0]] + next[1];
                        pq.add(new int []{next[0], record[cur[0]] + next[1]}); // pq 추가 
                    }
                }
            }
            sum += record[a];
            sum += record[b];
            answer = Math.min(answer, sum);
        }
        return answer;
    }
}
