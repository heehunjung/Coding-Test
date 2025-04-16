import copy
def solution(elements):
    answer = set()
    
    li = []
    
    for v in elements:
        li.append(v)
    for i in  range(len(elements)-1):
        li.append(elements[i])
    
    n = len(elements)
    temp = [[] for _ in range(n+1)]
    
    for i in range(len(li)):
        if i <= n-1:
            temp[i+1].append(elements[i])
        for j in range(1, i+1):
            if j <= n and len(temp[j]) <= n-1:
                temp[j].append(temp[j][-1] + li[i])
    
    for tp in temp:
        for v in tp:
            answer.add(v)
    return len(answer)
