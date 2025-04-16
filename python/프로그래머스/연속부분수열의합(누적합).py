def solution(elements):
    answer = []
    li = elements*2 
    n = len(elements)
    prefix_sum = [0 for _ in range(len(li)-1)]
    prefix_sum[0] = elements[0]
    for i, v in enumerate(li[:-2]):
        prefix_sum[i+1] = prefix_sum[i]+ li[i+1]
    
    for i in range(n):
        for j in range(i, i+n):
            temp = prefix_sum[j] - prefix_sum[i]
            answer.append(temp)
            
    return len(set(answer))
