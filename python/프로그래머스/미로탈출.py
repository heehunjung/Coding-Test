from collections import deque

def move(start, maps, target):
    moves = [(1,0), (-1,0), (0,-1), (0,1)]
    x = len(maps)
    y = len(maps[0])
    visited = [[0 for _ in range(y)] for _ in range(x)]
    
    q = deque()
    q.append([start[0],start[1],0])
    visited[start[0]][start[1]] = 1
    result = []
    while q:
        now_x, now_y, count = q.popleft()
        
        if maps[now_x][now_y] == target:
            return count    
        for move in moves:
            next_x, next_y = now_x + move[0], now_y + move[1]
            if 0 <= next_x < x and 0 <= next_y < y:
                if visited[next_x][next_y] == 0 and maps[next_x][next_y] != "X":
                    q.append([next_x,next_y,count+1])
                    visited[next_x][next_y] = 1
    return -1
    
def solution(maps):
    start = []
    exit = []
    label = []
    
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] == "S":
                start = [i,j]
            if maps[i][j] == "E":
                exit = [i,j]
            if maps[i][j] == "L":
                label = [i,j]
    
    # print(start, exit, label)

    toL = move(start , maps , "L")
    
    if toL == -1:
        return -1
    
    toX = move(label, maps , "E")
    
    if toX == -1:
        return -1
    
    return toL + toX
