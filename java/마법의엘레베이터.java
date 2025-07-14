import java.util.*;

class Solution {
    
    public int solution(int storey) {
        return doSomething(storey);
    }
    
    int doSomething(int storey) {
        List<Integer> li = makeNum(storey);
        int current = 0;
        int result = 0;
        for(int i=0;i<li.size();i++) {
            current += li.get(i); 
            if (current >= 5) {
                if(i != li.size()-1) {
                    if (li.get(i+1) >= 5) {
                        result += 10-current;
                        current = 1;
                    } else {
                        if(current == 5) {
                            result += current;
                            current = 0;
                        }
                        else {
                            result += 10-current;
                            current = 1;                            
                        }
                    }   
                } else {
                    result += Math.min(11-current, current);    
                }
            } else {
                result += current; 
                current = 0;
            }
        } 
        return result; 
    }
    
    List<Integer> makeNum(int number) {
        List<Integer> result = new ArrayList<>();

        while (number > 0) {
            result.add(number % 10); 
            number /= 10;           
        }

        return result;
    }    
}
