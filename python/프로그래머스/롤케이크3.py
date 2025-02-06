def solution(topping):
    answer = 0
    chersu = {}
    bro = {}
    
    for tp in topping:
        if tp not in chersu:
            chersu[tp] = 1 
            # 새로운 키 벨류
        else:
            chersu[tp] += 1
            # 기존의 값에 추가
    for tp in topping:

        if len(chersu) == len(bro):
            answer += 1
        
        if tp in chersu:
            chersu[tp] -= 1
        
        if tp not in bro:
            bro[tp] = 1
        else:
            bro[tp] += 1
        
        if chersu[tp] == 0:
            chersu.pop(tp)
    return answer
