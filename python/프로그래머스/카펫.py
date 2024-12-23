def solution(brown, yellow):
    answer = []
    x, y = yellow, 1
    
    while x >= y:
        if yellow % x == 0:
            y = yellow / x 
            if 2 * (x+y) + 4 == brown:
                break
            else:
                x -= 1
        else:
            x -= 1
        
    return [x+2,y+2]