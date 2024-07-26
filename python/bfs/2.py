

def bfs(graph, x, y):
  queue = deque([(x, y, 1)])  # 큐에 (x좌표, y좌표, 현재까지의 거리) 추가
  graph[y][x] = 0

  while queue:
    x, y, count = queue.popleft()

    if x == m - 1 and y == n - 1:
      return count

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if 0 <= nx < m and 0 <= ny < n and graph[ny][nx] == 1:
        graph[ny][nx] = 0
        count = count + 1
        queue.append((nx, ny, count))

  return -1
  
from collections import deque

n, m = map(int, input().split())
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


graph = []
for i in range(n):
  graph.append(list(map(int, input().strip())))

result = bfs(graph, 0, 0)
print(result)
