def solution(answers):
    answer = []
    n1 = [1,2,3,4,5]
    n2 = [2,1,2,3,2,4,2,5]
    n3 = [3,3,1,1,2,2,4,4,5,5]
    r1, r2, r3 = 0, 0, 0
    for i in range(len(answers)):
        idx1 = i % 5
        idx2 = i % 8
        idx3 = i % 10
        
        if n1[idx1] == answers[i]:
            r1 += 1
        if n2[idx2] == answers[i]:
            r2 += 1
        if n3[idx3] == answers[i]:
            r3 += 1
    
    temp = [r1,r2,r3]
    mV = max(temp)

    for i in range(3):
        if mV == temp[i]:
            answer.append(i+1)
        
    return answer

