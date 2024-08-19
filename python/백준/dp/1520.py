# import sys

# input = sys.stdin.readline
# Y, X = map(int, input().split())

# dp = [[0 for _ in range(X)] for _ in range(Y)]

# dx = [1, -1, 0, 0]
# dy = [0, 0, 1, -1]

# array = [[0 for _ in range(X)] for _ in range(Y)]
# for i in range(Y):
#   array[i] = list(map(int, input().split()))
# count = 0

# def recul(x, y):
#   global count
#   # 종료 조건
#   if x == X - 1 and y == Y - 1:
#     count += 1
#     return 0

#   for i in range(4):
#     x_ = x + dx[i]
#     y_ = y + dy[i]
#     if 0 <= x_ < X and 0 <= y_ < Y:
#       if array[y][x] > array[y_][x_]:
#         dp[y_][x_] = 0
#         recul(x_, y_)
#   return 0

# recul(0, 0)
# print(count)

# 이거 한번 고쳐보자
#######################################################################################

import sys

input = sys.stdin.readline
n, m = map(int, input().split())
graph = []

moves = [[1, 0], [0, 1], [-1, 0], [0, -1]]

visited = [[-1] * m for _ in range(n)]
for _ in range(n):
  graph.append(list(map(int, input().split())))


def dfs(x, y):
  # Base Case
  if x == n - 1 and y == m - 1:
    return 1

  # 이미 방문한 곳일 때
  if visited[x][y] != -1:
    return visited[x][y]

  visited[x][y] = 0

  for move in moves:
    nx, ny = x + move[0], y + move[1]

    if 0 <= nx < n and 0 <= ny < m:
      if graph[x][y] > graph[nx][ny]:
        visited[x][y] += dfs(nx, ny)

  return visited[x][y]


print(dfs(0, 0))
