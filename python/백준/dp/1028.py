# def checkDiamond(x,y,move):
#     nx = x + move[1]
#     ny = y + move[0]
#     if 0 <= nx < c and 0 <= ny < r:
#         if diamond[ny][nx] == 1:
#             return 1 
#     return -1 #해당 좌표 0 이거나 유효하지 못한 좌표인 경우 
# def checkMaxPoint(x,y,length,move):
#     if length == 0:
#         return 1
#     nx = x + move[1]*length
#     ny = y + move[0]*length
#     if 0 <= nx < c and 0 <= ny < r:
#         if diamond[ny][nx] == 1:
#             return 1 
#     return -1 #해당 좌표 0 이거나 유효하지 못한 좌표인 경우 
# r,c = map(int,input().split())

# diamond = []
# dp = [[-1]*c for _ in range(r)]
# for i in range(r):
#     diamond.append(list(map(int,input().rstrip())))


    
# result = 0
#         #왼쪽아래,오른쪽아래,오른쪽위,왼쪽위
# moves = [(1,-1),(1,1),(-1,1),(-1,-1)]

# for y in range(r):
#     for x in range(c):
#         length = 1
#         if diamond[y][x] == 1:
#             while True:
#                 px,py = x,y
#                 check = 1
#                 for move in moves:
#                     if checkMaxPoint(px,py,result,move) == 1:
#                         if result == 0:
#                             length == 1
#                         else:
#                             lenght = result -1
#                         for _ in range(length):
#                             if checkDiamond(px,py,move) == 1: 
#                                 # px, py 업데이트
#                                 px += move[1]
#                                 py += move[0]
#                             else:
#                                 # px, py 업데이트
#                                 px += move[1]
#                                 py += move[0]
#                                 check = 0
#                         if check == 0:
#                             break
#                         else:
#                             tempX,tempY = px-move[0],py-move[1]
#                     else:
#                         px = x + move[1]*length
#                         py = y + move[0]*length
#                         check = 0
#                         break
#                 if px == x and py == y and check == 1:
#                     result = max(result,length+1)
#                     length = result - 1
#                     length += 1
#                 elif 0 <= px < c and 0 <= py < r:
#                     length += 1
#                 else:
#                     break
                
                
# print(result)
                
n, m = map(int, input().split())
board = [[0] * (m+2) for _ in range(n+2)]

for i in range(1,n+1):
    s = input()
    for j in range(1,m+1):
        board[i][j] = int(s[j-1])

ld = [[0] * (m+2) for _ in range(n+2)]
rd = [[0] * (m+2) for _ in range(n+2)]
lu = [[0] * (m+2) for _ in range(n+2)]
ru = [[0] * (m+2) for _ in range(n+2)]

for i in range(n, 0, -1):
    for j in range(1, m+1):
        if board[i][j] == 1:
            ld[i][j] = ld[i+1][j-1] + 1
            rd[i][j] = rd[i+1][j+1] + 1

for i in range(1, n+1):
    for j in range(1, m+1):
        if board[i][j] == 1:
            lu[i][j] = lu[i-1][j-1] + 1
            ru[i][j] = ru[i-1][j+1] + 1

result = 0
for i in range(1, n+1):
    for j in range(1, m+1):
        l = result if result != 0 else 1
        for k in range(l, min(ld[i][j], rd[i][j])+1):
            t = i + (k-1)*2
            if t > n+1:
                break
            if board[t][j] and lu[t][j] >= k and ru[t][j] >=k:
                result = k
        for k in range(l, min(rd[i][j], ru[i][j])+1):
            t = j + (k-1)*2
            if t > m+1:
                break
            if board[i][t] and lu[i][t] >= k and ld[i][t] >=k:
                result = k
print(result)