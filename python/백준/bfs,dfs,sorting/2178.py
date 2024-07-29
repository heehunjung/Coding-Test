from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(graph):
  queue = deque([(0, 0, 1)])  # 튜플 형태의 큐임
  graph[0][0] = 0  # visited
  result = 0
  while queue:
    x, y, count = queue.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      result = count
      if 0 <= nx < m and 0 <= ny < n and graph[ny][nx] == 1:
        graph[ny][nx] = 0
        queue.append((nx, ny, count + 1))
        if nx == m - 1 and ny == n - 1:
          return count + 1

  return result


n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]

print(bfs(graph))

## bfs로 최단거리 구할 때 내가 원하는 점이 마지막인지 check 아니면 종료 조건 추가해야함
