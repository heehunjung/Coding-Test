import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentServer = 0;
        int count = 0;
        Queue<int[]> servers = new ArrayDeque<>();

        for (int player: players) {
            int needServer = player / m;
            if (!servers.isEmpty()) {
                int[] server = servers.peek();
                if (server[0] + k == count) { 
                    currentServer -= server[1];
                    servers.poll();
                }
            }
            
            if (needServer > currentServer) {
                answer += (needServer-currentServer);
                servers.offer(new int[]{count, needServer-currentServer});
                currentServer = needServer;
            }
            count += 1;
        }
        return answer;
    }
}
