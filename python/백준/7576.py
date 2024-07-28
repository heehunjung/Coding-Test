#bfs,dfs
from collections import deque
import sys

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(visited, graph, count):
  queue = deque()
  for i in range(m):
    for j in range(n):
      if graph[i][j] == 1:
        visited[i][j] = 1

        queue.append((j, i, count))
  #일반적인 bfs랑 다르게 한 노드에서 출발하는게 x
  #모든 그래프을 초기에 확인 후 시작 노드들을 queue에 저장해둠
  while queue:
    #queue에 저장된 시작점 노드들을 다 check
    for _ in range(len(queue)):
      now_x, now_y, count = queue.popleft()
      for i in range(4):
        nx = now_x + dx[i]
        ny = now_y + dy[i]
        if 0 <= nx < n and 0 <= ny < m and graph[ny][nx] == 0:
          queue.append((nx, ny, count + 1))
          graph[ny][nx] = 1
          visited[ny][nx] = 1

  return count


n, m = map(int, input().split())

tomato = [list(map(int, input().split())) for _ in range(m)]
visited = [[0] * n for _ in range(m)]
count = 0
check = 0
result = []
for i in range(m):
  for j in range(n):
    if (tomato[i][j] == 0):
      count = 1
if count == 0:
  print(0)
  sys.exit(0)
count = bfs(visited, tomato, 0)
for i in range(m):
  for j in range(n):
    if (tomato[i][j] == 0):
      print(-1)
      sys.exit(0)

print(count)


### 특이한 인풋 -1 -1 -1 , 0 0 0 같은 걸 잘 생각하자~