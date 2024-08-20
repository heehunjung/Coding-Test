import sys


from collections import deque

input = sys.stdin.readline
n,m = map(int,input().split())

li = []
for i in range(n):
    li.append(list(map(int,input().split())))

moves = [(1,0),(-1,0),(0,1),(0,-1),(1,1),(1,-1),(-1,1),(-1,-1)]
result = 0 

# 모든 점에대해 검사
for Y in range(n):
    for X in range(m):
        #해당 부분에 아기 상어가 없는 경우에만 검사
        if li[Y][X] == 0:
            count = 0
            q = deque([(X, Y,count)])
            #8가지 방향이니깐 진행 했던 부분 체크
            visited = [[False] * m for _ in range(n)]
            visited[Y][X] = True
        else:
            continue
        while q:
            x,y,count = q.popleft()
            if li[y][x] == 1:
                result = max(count,result)
                break
            for move in moves:
                nx,ny = x+move[0],y+move[1]
                if 0<=nx<m and 0<=ny<n and not visited[ny][nx]:
                    visited[ny][nx] = True
                    q.append((nx, ny,count+1))
print(result)
            