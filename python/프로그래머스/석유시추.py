from collections import deque

def solution(land):
    answer = []
    n = len(land)
    m = len(land[0])
    check = [[-1 for _ in range(m)] for _ in range(n)]
    visited = [[False for _ in range(m)] for _ in range(n)]
    def bfs(x,y,check,idx):
        moves = [(0,1), (0,-1),(1,0),(-1,0)]
        n = len(check)
        m = len(check[0])
        q = deque()
        q.append([x , y])
        visited[x][y] = True
        count = 1 
        check[x][y] = idx
        while q:
            x, y = q.popleft()
            
            for px,py in moves:
                if 0 <= x + px < n and 0 <= y + py < m:
                    if land[x+px][y+py] == 1 and not visited[x+px][y+py]:
                        q.append([x+px, y+py])
                        visited[x+px][y+py] = True
                        check[x+px][y+py] = idx
                        count += 1
        return count
    idx = 0
    value = [0 for _ in range(n*m)]
    for x in range(n):
        for y in range(m):
            if land[x][y] == 1 and not visited[x][y]:
                temp = bfs(x,y,check,idx)
                value[idx] = temp
                idx += 1
    
    for y in range(m):
        visit = []
        for x in range(n):
            v = check[x][y]
            if v != -1:
                visit.append(v)
        temp_result = 0
        for a in set(visit):
            temp_result += value[a]
        answer.append(temp_result)

    return max(answer)
