import math
def solution(r1, r2):
    answer = 0
    def cal(target, x):
        return math.sqrt(target**2 - x**2)
    
    for x in range(1, r2 + 1):
        if x < r1:
            temp = cal(r1, x)
            y1 = math.floor(temp)
            # 내부 원 경계상의 점이 정수일 경우
            if temp == y1:
                y1 -= 1
        else:
            y1 = 0
            answer += 1  # x축상의 점 (x,0)을 포함
        
        y2 = math.floor(cal(r2, x))
        answer += (y2 - y1)
    return answer * 4
