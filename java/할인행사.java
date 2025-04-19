class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int disNum = discount.length;
        for (int j = 0; j <= disNum-10; j++) {
            int[] temp = number.clone();
            boolean isOk = true;
            for (int i = j; i < j+10; i++) {
                if (!cal(temp, want, discount[i])) {
                     isOk = false;
                    break;
                }
            }
            if (isOk) {
                answer += 1;   
            }
        }
        return answer;
    }
    
    private boolean cal(int[] number,String[] want,String discount) {
        for (int i = 0; i < number.length; i++) {
            if (want[i].equals(discount) && number[i] > 0) {
                number[i] -= 1;
                return true;
            }
        }
        
        return false;
    }
}
