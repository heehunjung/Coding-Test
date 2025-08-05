import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        String[] answer;
        List<Integer> li = new ArrayList<>();
        int min = 1;
        int fixing = 0;
        
        for (int idx = 0; idx < expressions.length; idx++) {
            String exp = expressions[idx];
            String[] exps = exp.split(" ");
            for (int i = 0; i <= 4; i += 2) {
                for (char ch : exps[i].toCharArray()) {
                    if(ch == 'X') break;
                    int num = ch - '0';
                    min = Math.max(num, min);
                }
            }
            
            if (exps[4].equals("X")) {
                li.add(idx);  // 현재 인덱스 추가
                continue;
            }
            if(fixing != 0) continue;
            int f = Integer.parseInt(exps[0]);
            int l = Integer.parseInt(exps[2]);
            int r = Integer.parseInt(exps[4]);

            if (exps[1].equals("+")) {
                // 1의자리 
                if((f%10) + (l%10) != (r%10)) {
                    fixing = (f%10) + (l%10) - (r%10);
                    continue;
                } else {
                    min = Math.max((r%10),min); 
                }   

                // 10의자리 
                if((f/10) + (l/10) != (r/10)) {
                    fixing = (f/10) + (l/10) - (r/10%10);
                    continue;
                } else {
                    min = Math.max((r%10),min); 
                }               
            }

            if (exps[1].equals("-")) {
                if((f%10) < (l%10)) {
                    fixing = (l%10) - (f%10) + (r%10); 
                }
            }
        }

        answer = new String[li.size()];
        int cIdx = 0;

        if(min == 8) fixing = 9;
        
        for(int idx: li) {
            String exp = expressions[idx];
            String[] exps = exp.split(" ");
            
            int f = Integer.parseInt(exps[0]);
            int l = Integer.parseInt(exps[2]);
            
            String result = "?";
            String op = exps[1];
            
            //fixing
            if(fixing != 0) {
                result = String.valueOf(cal(f , l , op, fixing));
            } else {
                if(op.equals("+")) {
                    if(f%10 + l%10 <= min && f/10 + l/10 <= min) {
                        result = String.valueOf(f+l);
                    } 
                } else {
                    if(f%10 - l%10 >= 0) {
                        result = String.valueOf(f-l);
                    }
                }
            }
            answer[cIdx] = f + " " + op +" " + l + " = "+ result;
            cIdx++;
        }
        return answer;
    }
    
    int cal(int a, int b, String c, int n) {
        int result = 0;
        int r1 = 0;
        int r10 = 0;
        int r100 = 0;
        if (c.equals("+")) {
            r1 = a%10 + b%10;
            if(r1 >= n) {
                r1 = r1 - n;
                r10 += 1;
            }
            r10 += (a/10 + b/10);
            if(r10 >= n) {
                r10 = r10 - n;
                r100 += 1;
            }
        } else {
           r1 = a%10 - b%10;
            if(r1 < 0) {
                r10 -= 1;
                r1 = r1 + n;
            }
            r10 += (a/10 - b/10);
        }
        
        return r100 * 100 + r10 * 10 + r1;
    }
}
