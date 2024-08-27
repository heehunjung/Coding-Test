def checkDiamond(x,y,move):
    nx = x + move[1]
    ny = y + move[0]
    if 0 <= nx < c and 0 <= ny < r:
        if diamond[ny][nx] == 1:
            return 1 
    return -1 #해당 좌표 0 이거나 유효하지 못한 좌표인 경우 


r,c = map(int,input().split())

diamond = []

for i in range(r):
    diamond.append(list(map(int,input().rstrip())))


    
result = 0
        #왼쪽아래,오른쪽아래,오른쪽위,왼쪽위
moves = [(1,-1),(1,1),(-1,1),(-1,-1)]

for y in range(r):
    for x in range(c):
        length = 1
        if diamond[y][x] == 1:
            tempX,tempY = x,y
            while True:
                px,py = x,y
                check = 1
                for move in moves:
                    for _ in range(length):
                        if checkDiamond(px,py,move) == 1: 
                            # px, py 업데이트
                            px += move[1]
                            py += move[0]
                        else:
                            # px, py 업데이트
                            px += move[1]
                            py += move[0]
                            check = 0
                    if check == 0:
                        break
                    else:
                        tempX,tempY = px-move[0],py-move[1]
                if px == x and py == y and check == 1:
                    result = max(result,length+1)
                    length = result - 1
                    length += 1
                elif 0 <= px < c and 0 <= py < r:
                    length += 1
                else:
                    break
                
                
print(result)
                







