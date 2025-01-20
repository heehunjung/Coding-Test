# 중복을 체크해서 시간을 줄이자, bfs
from collections import deque
def solution(x, y, n):
    answer = -1
    dp = [[0,0] for _ in range(y+1)]
    visited = [0 for _ in range(y+1)]
    q = deque()
    q.append([x,0])
    visited[x] = 1
    while q:
        current, count = q.popleft()
        
        if current == y:
            answer = count
            break
        
        if (current + n <= y and visited[current + n] == 0):
            q.append([current + n, count + 1])
            visited[current + n] = 1
        if (current * 2 <= y and visited[current *2] == 0):
            q.append([current * 2, count + 1])
            visited[current*2] = 1
        if (current * 3 <= y and visited[current *3] == 0):
            q.append([current * 3, count + 1])
            visited[current*3] = 1
    return answer
