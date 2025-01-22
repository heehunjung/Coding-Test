
def solution(storey):
    answer = 0
  
    strStorey = list(str(storey))
    strStorey.reverse()

    for i in range(len(strStorey)):
        temp = 0
        if int(strStorey[i]) >5:
            temp = 10 - int(strStorey[i])
            if i == len(strStorey) - 1:
                temp += 1
            else:
                strStorey[i+1] = str(int(strStorey[i+1]) + 1)
        elif int(strStorey[i]) == 5 and i != len(strStorey) - 1 and int(strStorey[i+1]) >= 5 :
            temp = 10 - int(strStorey[i])
            strStorey[i+1] = str(int(strStorey[i+1]) + 1)
        else:
            temp = int(strStorey[i])
        answer += temp
        

    
    print(strStorey)
 
    return answer 
