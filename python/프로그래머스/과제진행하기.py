def solution(plans):
    answer = []
    
    sorted_plans = sorted(plans, key=lambda x: x[1])
    length = len(sorted_plans)
    visited = [False for _ in range(length)]
    current_index = 0
    index = 0
    
    while True:
        current_index += 1
        
        if current_index == length:
            for i in range(length-1,-1,-1):
                if visited[i] == False:
                    answer.append(sorted_plans[i][0])
            break
            
            
        for i in range(current_index -1 , -1, -1):  # 역순으로 순회
            if visited[i] == False:
                index = i
                break
        
        sub,start,time = sorted_plans[index]
        next_sub,next_start,next_time = sorted_plans[current_index]
        
        current_h, current_m = map(int,start.split(":"))
        next_h, next_m = map(int,next_start.split(":"))
        
        time_gap = (next_h * 60 + next_m) - (current_h * 60 + current_m)       

        if time_gap == int(time):
            answer.append(sub)
            visited[index] = True
        
        if time_gap > int(time):
            remainTime = time_gap - int(time)
            answer.append(sub)
            visited[i] = True
            
            
            for i in range(current_index-1,-1,-1):
                if visited[i] == False:
                    sub,start,time = sorted_plans[i]
                    if remainTime >= int(time):
                        remainTime -= int(time)
                        answer.append(sub)
                        visited[i] = True
                    else:
                        sorted_plans[i][2] = str(int(time)-remainTime)
                        remainTime = 0
                        break
        if time_gap < int(time):
            sorted_plans[index][2] = str(int(time)-time_gap)
                            
        if current_index == length - 1:
            answer.append(next_sub)
            visited[current_index] = True
        
        
    return answer