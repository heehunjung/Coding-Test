def solution(se,k):
    answer = [0, len(se)]
    summ = 0
    left = 0
    
    for right in range(len(se)):
        summ += se[right]
        
        while summ > k:
            summ -= se[left]
            left += 1
        
        if summ == k:
            if right - left < answer[1] - answer[0]:
                answer = [left, right]

    return answer 
