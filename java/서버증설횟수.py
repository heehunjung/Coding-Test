import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int currentServer = 0;
        List<int[]> servers = new ArrayList<>();
        for (int player: players){
            int needServer = player / m;
            for (int[] server: servers) {
                if (server[1] == 0) {
                    currentServer -= server[0];
                    server[1] -= 1;
                }
                server[1] -= 1;
            }
            if (needServer > currentServer) {
                servers.add(new int[]{needServer-currentServer, k-1});
                answer += needServer-currentServer;
                currentServer = needServer;
            }
        }

        return answer;
    }
}
