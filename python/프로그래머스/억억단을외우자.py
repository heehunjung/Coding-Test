from collections import defaultdict
import math
def solution(e, starts):
    answer = []
    
    def calDiv(num):
        if num == 1:
            return 1
        sqrt_n = int(math.sqrt(num))
        result = 2
        for i in range(2, sqrt_n + 1):
            if num % i == 0:
                if num // i == i:
                    result += 1
                else:
                    result += 2
        return result
    
    temp = []
    minStart = min(starts)
    starts_rev = sorted(starts, reverse=True)
    
    for i in range(minStart, e+1):
        temp.append(calDiv(i))
    
    rev_temp = list(reversed(temp))  
    
    maxV, idx = 0, 0
    maxIdx = 0
    resultDict = defaultdict(int)
    
    for i in range(len(rev_temp)):
        if rev_temp[i] >= maxV:
            maxV = rev_temp[i]
            maxIdx = e - i
        if i + starts_rev[idx] == e:
            resultDict[starts_rev[idx]] = maxIdx
            idx += 1
    for start in starts:
        answer.append(resultDict[start])
    return answer
