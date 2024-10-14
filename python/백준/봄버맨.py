# input
r,c,n = map(int,input().split())
board =  []
board_time = [[-2 for _ in range(c)] for _ in range(r)] # -2은 폭탄 없는 곳임

for _ in range(r):
    board.append(list(input()))

for i in range(r):
    for j in range(c):
        if board[i][j] == "O":
            board_time[i][j] = 1 # time = 1 부터 시작
# board_time 초기화

moves = [(1,0),(-1,0),(0,1),(0,-1)]

time = 1
bombaman = 2 # 봄버맨 설치 시간
boom = 3     # 폭탄 터지는 시간

while time != n:
    time += 1 # 위치 생각 위 중간 아래 time = 1 부터 시작 

    # bomber
    if time%bombaman == 0:
        for i in range(r):
            for j in range(c):
                if board_time[i][j] == -2:
                    board_time[i][j] = -1
        
    # Boom timer on
    for i in range(r):
        for j in range(c):
            if board_time[i][j] != -2: #폭탄이 있는 경우에만 count
                board_time[i][j] += 1
            
            if board_time[i][j] == 3: # Boom !     
                for move in moves:
                    ni,nj = i + move[0], j + move[1]
                    if 0 <= ni < r and 0 <= nj < c:    
                        if move == (1,0) or move == (0,1):
                            if board_time[ni][nj] == 2:
                                continue
                        board_time[ni][nj] = -2

                board_time[i][j] = -2

    
    # board 그리기
    for i in range(r):
        for j in range(c):
            if board_time[i][j] == -2:
                board[i][j] = '.'
            else:
                board[i][j] = 'O'
        
#     print("=====",time)
#     for row in board:
#         print(row)
#     for row in board_time:
#         print(row)
    

# print("==result==")
for row in board:
    print("".join(map(str, row)))
