from itertools import combinations

def solution(n, q, ans):
    answer = 0
    codes = [i+1 for i in range(n)]

    for temp in combinations(codes, 5):
        isOK = True
        for i in range(len(q)):
            count = 0
            for l in q[i]:
                if l in temp:
                    count += 1
            if count != ans[i]:
                isOK = False
                break
        if isOK:
            answer += 1
    
    return answer
