def solution(k, tangerine):
    answer = 0
    box = []
    tangerine.sort()
    count = 1
    num = len(tangerine)
    
    if num == 1:
        return 1
    for i in range(num-1):
        if tangerine[i] == tangerine[i+1]:
            count += 1
            if i == num-2:
                box.append(count)
        else:
            box.append(count)
            count = 1
            if i == num-2:
                box.append(1)
    
       
    box.sort(reverse = True)

    for b in box:
        if k >= b:
            k -= b
            answer += 1
        else:
            answer += 1
            break
        if k == 0:
            break
    
    return answer
