def solution(prices):
    answer = []
    length = len(prices)
    for i in range(length):
        times = 0
        for j in range(i+1, length):
            if prices[i] > prices[j]:
                times = j - i
                break
            if j == length - 1:
                times =  j - i 
        
        answer.append(times)
        
    return answer