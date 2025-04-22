import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> finish = new PriorityQueue<>();
        List<Integer> temp = new ArrayList<>();
        
        int total = progresses.length;
        int finishIndex = 0;
        
        for (int i=0;i<=100;i++) {
            for(int j=0; j<total; j++) {
                //작업 완료 프로세스
                if(progresses[j] == -1) {
                    continue;
                }
                // 작업 완료 중 
                if(progresses[j] < 100) {
                    progresses[j] += speeds[j];
                    if (progresses[j]<100) {
                        continue;    
                    }
                } 
                // 오늘 작업 완료
                finish.offer(j);
                progresses[j] = -1;
            }        
            int num = 0;
            while (!finish.isEmpty() && (finish.peek() == finishIndex)) {
                num += 1;
                finishIndex+=1;
                finish.poll();
            }
                
            if(num != 0) {
                temp.add(num);
            }
        }
        answer = new int[temp.size()];
        
        for(int i=0; i<temp.size();i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
