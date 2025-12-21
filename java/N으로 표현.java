import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            int baseNum = 0;
            for (int k = 0; k < i; k++) {
                baseNum = baseNum * 10 + N;
            }
            dp.get(i).add(baseNum);
            
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (int num1 : set1) {
                    for (int num2 : set2) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) { 
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }

            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
