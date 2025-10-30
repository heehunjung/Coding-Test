import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2],b[2]));
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> ss;
        List<Integer> ff;
        for(int[] cost: costs) {
            int f = cost[0], s = cost[1], c = cost[2];
            if(visited[s] && visited[f]) {
                boolean isConnected = false;
                for(int near: map.get(s)) {
                    if(near == f) {
                        isConnected = true;
                        break;
                    }
                }
                if(isConnected) continue;
            } 
            ss = map.getOrDefault(s, new ArrayList<>());
            ff = map.getOrDefault(f, new ArrayList<>());
            List<Integer> ssss = new ArrayList<>(ss);
            List<Integer> ffff = new ArrayList<>(ff);
            for(int sss: ssss) {
                ff.add(sss);
                if(sss!=f)map.get(sss).add(f);
                for(int fff: ffff) map.get(sss).add(fff);
            }
            ss.add(f);
            for(int fff: ffff) {
                ss.add(fff);
                if(fff!=s)map.get(fff).add(s);
                for(int sss: ssss) map.get(fff).add(sss);
            }                 
            ff.add(s);
            
            answer += c;
            map.put(f, ff);
            map.put(s, ss);
            visited[s] = true;
            visited[f] = true;

            // 종료 조건
            if(map.get(f).size() == n-1) break;
        }
        return answer;
    }
}
