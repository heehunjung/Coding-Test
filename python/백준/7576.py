#bfs,dfs
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(visited, graph, count):
  queue = deque()
  for i in range(m):
    for j in range(n):
      if graph[i][j] == 1:
        visited[i][j] = 1
        queue.append((j, i, count + 1))
  while queue:
    for _ in range(len(queue)):
      now_x, now_y, count = queue.popleft()
      for i in range(4):
        nx = now_x + dx[i]
        ny = now_y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and graph[ny][nx] == 0:
          queue.append((nx, ny, count + 1))
          graph[ny][nx] = 1
          visited[ny][nx] = 1

  return count - 1


n, m = map(int, input().split())

tomato = [list(map(int, input().split())) for _ in range(m)]
visited = [[0] * n for _ in range(m)]
count = 0
check = 0
result = []
for i in range(m):
  for j in range(n):
    if tomato[i][j] == 1 and not visited[i][j]:
      check = 1
count = bfs(visited, tomato, 0)
if check == 0:
  print(0)
  check = 1
else:
  for i in range(m):
    for j in range(n):
      if (tomato[i][j] == 0):
        check = 0
if check == 0:
  print(-1)
else:
  print(count)
