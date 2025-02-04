def solution(k, ranges):
    answer = []
    n = 0
    value = []
    value.append(k)
    while k != 1:
        if k % 2 == 0:
            k = k // 2
        else:   
            k = k * 3 + 1
        value.append(k)
        n += 1
    box = []
    for i in range(n):
        bb = (value[i] + value[i+1]) /2
        box.append(bb)

    for rg in ranges:
        a, b = rg
        f, s = a, n + b
        bb = 0
        if s < f:
            answer.append(-1)
            continue
        for i in range(f,s):
            bb += box[i]

        answer.append(bb)
    
    return answer
