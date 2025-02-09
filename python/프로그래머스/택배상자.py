from collections import deque
def solution(order):
    result = 0
    boxes = [i+1 for i in range(len(order))]
    sub_rail = []
    idx = 0
    for c in order:


        if idx < len(boxes) and c == boxes[idx]:
            result += 1
            idx += 1
        else:
            if sub_rail and sub_rail[len(sub_rail)-1] == c:
                sub_rail.pop()
                result += 1
                continue

            start = idx
            isContinue= True
            for i in range(start, len(boxes)):
                idx += 1 
                if boxes[i] == c:
                    result += 1
                    isContinue= True
                    break
                else: 
                    sub_rail.append(boxes[i])
                isContinue = False
            
            if not isContinue:
                return result 

    return result 
