import math
def solution(k, d):
    answer = 1
    
    x = 0
    y = d
    def calY(x, target):
        p = target ** 2 - x ** 2
        return math.floor(p ** 0.5)
    
    while y > 0:
        # 체크 로직
        answer += y // k
        # 업데이트 로직
        x += k
        if x**2 >= d **2:
            break
        y = calY(x, d)
    answer += d // k 
    return answer
