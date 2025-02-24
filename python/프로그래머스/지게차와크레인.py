from collections import deque
def 창고외부체크_DFS(storage, visited, start, moves):
    n = len(storage)
    m = len(storage[0])
    check = [[False] * m for _ in range(n)]
    
    def dfs(x, y):
        for dx, dy in moves:
            nx, ny = x + dx, y + dy
            # 창고 범위를 벗어나면 외부로 나갔다고 판단하여 True 반환
            if not (0 <= nx < n and 0 <= ny < m):
                return True
            # 이동 가능한 칸(visited가 1)이고 아직 방문하지 않은 경우
            if visited[nx][ny] == 1 and not check[nx][ny]:
                check[nx][ny] = True
                if dfs(nx, ny):
                    return True
        return False
    
    return dfs(start[0], start[1])

def 지게차(storage,target,moves, visited):
    n = len(storage)
    m = len(storage[0])
    visit  = [[0 for _ in range(m)] for _ in range(n)]

    temp = []
    for x in range(n):
        for y in range(m):
            if storage[x][y] == target:
                for move in moves:
                    nx, ny = x + move[0], y + move[1]
                    if 0 <= nx < n and 0 <= ny < m:
                        if visited[nx][ny] == 1:
                            if 창고외부체크_DFS(storage, visited, [nx,ny], moves):       
                                temp.append([x,y])
                                break
                    else:
                        temp.append([x,y])
                        break  
    for t in temp:
        visited[t[0]][t[1]] = 1

def 크레인(storage,target,moves, visited):
    n = len(storage)
    m = len(storage[0])
    for x in range(n):
        for y in range(m):
            if storage[x][y] == target:
                visited[x][y] = 1
                
def solution(storage, requests):
    moves = [(1,0),(-1,0),(0,1),(0,-1)]
    n = len(storage)
    m = len(storage[0])
    answer = 0
    visited = [[0 for _ in range(m)] for _ in range(n)]
    for req in requests:
        req_li = list(req)
        if len(req_li) == 1:
            지게차(storage, req_li[0], moves, visited)
        else:
            크레인(storage, req_li[0], moves, visited)
    
    for a in visited:
        for b in a:
            if b == 0:
                answer += 1
    
    return answer
