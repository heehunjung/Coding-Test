import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        List<Long> result = new ArrayList<>();
        
        for(long number: numbers) {
            int[] bits = longToBit(number);
            long dif1 = 0;
//             for(int bit:bits) {
//                 System.out.print(bit);
//             }
            
//             System.out.println("");
//             System.out.println(bitToLong(bits));
            if (bits[bits.length-1] == 0) {
                dif1 = number + 1;
                result.add(dif1);
                continue;
            }
            // 2개 다른 수 
            for(int i=bits.length-2;i>=0;i--){
                if(bits[i]==0) {
                    boolean isFind = false;
                    bits[i]=1;
                    if(dif1 == 0) {
                        dif1 = number + (1L << (bits.length - (i + 1)));
                    }                 
                    // System.out.println(number+","+i);
                    for(int j=i+1;j<bits.length;j++) {
                        if (bits[j] == 1) {
                            bits[j] = 0;
                            isFind = true;
                            result.add(Math.min(bitToLong(bits), dif1));
                            bits[j] = 1;
                            break;
                        }
                    }  
                    if(isFind) {
                        bits[i]=0;
                        break;
                    }
                    result.add(dif1);
                    bits[i]=0;
                    break;
                }
            }
        }
        long[] arr = new long[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    private long bitToLong(int[] bits) {
        long result = 0;
        int len = bits.length;

        for (int i = 0; i < len; i++) {
            if (bits[i] == 1) {
                result += (1L << (len - 1 - i));
            }
        }

        return result;
    }
    
    private int[] longToBit(long num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int current = (int)(num % 2);
            list.add(current);
            num = num / 2;
        }

        Collections.reverse(list);

        int[] bits = new int[list.size()+1];
        bits[0] = 0;
        for (int i = 0; i < list.size(); i++) {
            bits[i+1] = list.get(i);
        }

        return bits;
    }
}
