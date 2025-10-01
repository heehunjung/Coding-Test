import java.util.*; 

class Solution {
    String[] heads;
    String[] numbers;
    public String[] solution(String[] files) {
        String[] answer;
        heads = new String[files.length];
        numbers = new String[files.length];
        answer = new String[files.length];
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(String file: files) {
            int idx = 0;
            for(int i=idx;i<file.length();i++) {
                char c = file.charAt(i);
                if ('0' <= c && c <= '9') {
                    heads[index] = sb.toString();
                    sb.setLength(0);
                    idx = i;
                    break;
                }
                sb.append(c);
            }

            for(int i=idx;i<file.length();i++) {
                char c = file.charAt(i);
                if ('0' <= c && c <= '9') {
                    sb.append(c);
                    continue;
                } else break; 
            }
                numbers[index] = sb.toString();
                sb.setLength(0);
            index++;
        }
        int[] rows = new int[files.length];
        for (int i = 0; i < files.length; i++) rows[i] = i;

        for (int i = 0; i < files.length - 1; i++) {
            for (int j = 0; j < files.length - 1 - i; j++) {
                if (!compare(rows[j], rows[j + 1])) {
                    int temp = rows[j];
                    rows[j] = rows[j + 1];
                    rows[j + 1] = temp;
                }
            }
        }

        int idx = 0;
        for (int r : rows) answer[idx++] = files[r];
        return answer;
    }
    boolean compare(int ri, int rj) {
        int cp = heads[ri].compareToIgnoreCase(heads[rj]);
        if (cp < 0) return true;
        if (cp > 0) return false;

        int f = Integer.parseInt(numbers[ri]);
        int s = Integer.parseInt(numbers[rj]);
        if (f < s) return true;
        if (f > s) return false;

        return true;
    }
}
