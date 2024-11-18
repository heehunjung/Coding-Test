def solution(targets):
    answer = 0
    sorted_targets = sorted(targets, key=lambda x: x[1])
    

    e = 0
    for target in sorted_targets:
        if target[0] >= e:
            answer += 1
            e = target[1]
        
    return answer 
