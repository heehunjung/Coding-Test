import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1 = 0;
        long q2 = 0;
        for (int i = 0; i< queue1.length; i++) {
            q1 += queue1[i];
            q2 += queue2[i];
        }
        if ((q1 + q2) % 2 != 0) return -1;
        long target = (q1 + q2) / 2;        
        if (target == q1) {
            return 0;
        }

        // int[] combined = new int[queue1.length + queue2.length];
        // for (int i = 0; i < queue1.length; i++) {
        //     combined[i] = queue1[i];
        // }
        // for (int i = 0; i < queue2.length; i++) {
        //     combined[queue1.length + i] = queue2[i];
        // }
        // return dfs(queue1, queue2, 0, 0, target, q1, 0);
        // return prefixSum(combined, target);
        return greedy(queue1, queue2, target, q1, q2);
    }
    
    private int greedy(int[] q1, int[]q2,long target,long s1, long s2) {
        Queue<Integer> dq1 = new LinkedList<>();
        Queue<Integer> dq2 = new LinkedList<>();
        for(int i=0; i< q1.length;i++) {
            dq1.offer(q1[i]);
            dq2.offer(q2[i]);
        }
        
        int length = q1.length;
        int count = 0;
        while (s1 != s2) {
            int temp = 0;
            if (dq1.size()==0 || dq1.size()==length*2) {
                return -1;
            }
            
            if (s1 > s2) {
                count += 1;
                temp = dq1.poll();
                s1 -= temp;
                s2 += temp;
                dq2.offer(temp);
                
            }
            if (s1 < s2) {
                count += 1;
                temp = dq2.poll();
                s1 += temp;
                s2 -= temp;
                dq1.offer(temp);
            }
        }
        return count;   
    }
        private long sum(Queue<Integer> q) {
            long sum = 0;
            for (int v: q) {
                sum += v;
            }
            return sum;
        }
    }
//     private int prefixSum(int[] arr, long target) {
//         long[] prefix_sum = new long[arr.length];
//         long result = target * 2 + 1;
//         prefix_sum[0] = arr[0];
//         for (int i=1;i<arr.length;i++) {
//             prefix_sum[i] = arr[i] + prefix_sum[i-1];
//             // System.out.println(prefix_sum[i]);
//         }
//         for (int i=arr.length-1;i>=2;i--) {
//             if (prefix_sum[i] < target) {
//                 break;
//             }
//             for(int j=i-2;j>=0;j--){
//                 long now = prefix_sum[i] -prefix_sum[j];
//                 // System.out.println("now "+now);
//                 if (now > target){
//                     break;
//                 }
//                 if (now==target) {
//                     // System.out.println("yosi "+ now);
//                     int l = j+1;
//                     int r = i;
//                     if (l < arr.length/2 && r >= arr.length/2) {
//                         result = Math.min(result,l + (r-arr.length/2)+1 );
//                         continue;
//                     } else {
//                         if (l >= arr.length/2) {
//                             l -= arr.length/2;
//                             r -= arr.length/2;
//                         }
//                         if (r == arr.length/2 -1) {
//                             result = Math.min(result,l);
//                             continue;
//                         }
//                         result = Math.min(result,(r+1) + arr.length/2 );
//                         continue;
//                     }
//                 } 
//             }
//         }
//         if(result == target * 2 + 1) {
//             result = -1;
//         }
//         return (int)result;
//     }
//     private int dfs(int[] queue1, int[] queue2, int idx1, int idx2, long target, long current, int count) {
//         if (current == target) {
//             return count;
//         }
//         System.out.println(idx1+","+idx2+","+current);
//         if (idx1+1 < queue1.length && current - queue1[idx1] <= target) {
//             dfs(queue1, queue2, idx1+1, idx2, target, current - queue1[idx1], count+1);
//         }
//         if (idx2+1 < queue2.length && current - queue2[idx2] <= target) {
//             dfs(queue1, queue2, idx1, idx2+1, target, current + queue2[idx2], count+1);
//         }
//         return -1;
//     }
// }
//     private int bfs(int[] queue1, int[] queue2)
//         Queue<long[]> q = new ArrayDeque<>();
//         long q1 = 0;
//         long q2 = 0;
//         for (int i = 0; i< queue1.length; i++) {
//             q1 += queue1[i];
//             q2 += queue2[i];
//         }
//         if ((q1 + q2) % 2 != 0) return -1;
//         long target = (q1 + q2) / 2;        
//         if (target == q1) {
//             return 0;
//         }
//         for (int i = 0; i< queue1.length; i++) {
//             if (queue1[i] == target || queue2[i] == target) {
//                 return (i+1) + (i) + queue1.length;
//             }
//         }
//         q.offer(new long[]{1, 0, q1 - queue1[0], 1});
//         q.offer(new long[]{0, 1, q1 + queue2[0], 1});
                
//         while(!q.isEmpty()) {
//             long[] current = q.poll();
//             // System.out.println(current[0] + ", " + current[1] + ", " + current[2] + ", " + current[3] + ", ");
//             if (current[2] == target) {
//                 return (int)current[3];
//             }
        
//             if (current[0] + 1 <= queue1.length && current[2] - queue1[(int)current[0]] <= target) {
//                 q.offer(new long[]{current[0]+1, current[1], current[2] - queue1[(int)current[0]], current[3] + 1});
//             }
//             if (current[1] + 1 <= queue2.length && current[2] + queue2[(int)current[1]] <= target) {
//                 q.offer(new long[]{current[0], current[1]+1, current[2] + queue2[(int)current[1]], current[3] + 1});
//             }
//         }
    //     return -1;
    // 
