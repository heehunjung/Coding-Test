def solution(h1, m1, s1, h2, m2, s2):
    answer = 0
    second1 = h1*60*60 + m1*60 + s1
    second2 = h2*60*60 + m2*60 + s2
    s_ = second2-second1
    
    if second1 == 0 or second1 == 60*60*12:
        answer += 1
    
    
    for i in range(second1, second2):
        s = (i*6)%360
        m = (i/10)%360
        h = (i/120)%360
        
        ns = 360 if (i+1)*6%360 == 0 else (i+1)*6%360
        nm = 360 if (i+1)/10%360 == 0 else (i+1)/10%360
        nh = 360 if (i+1)/120%360 == 0 else (i+1)/120%360
        
        if s < h and ns >= nh :
            print(s,m,h)
            answer += 1
        if s < m and ns >= nm :
            print(s,m,h)
            answer += 1
        if ns==nm==nh :
            answer -= 1
    return answer
