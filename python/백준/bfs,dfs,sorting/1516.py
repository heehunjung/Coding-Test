import sys
from collections import deque

N = int(input())
graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)
cost = [0] * (N + 1)
DP = [0] * (N + 1)

for i in range(1, N + 1):
  tmp = list(map(int, input().split()))[:-1]
  cost[i] = tmp[0]
  for j in tmp[1:]:
    graph[j].append(i)
    indegree[i] += 1

q = deque()

for i in range(1, N + 1):
  if not indegree[i]:
    q.append(i)
    DP[i] = cost[i]

while q:
  n = q.popleft()

  for i in graph[n]:
    indegree[i] -= 1
    DP[i] = max(DP[i], DP[n] + cost[i])

    if not indegree[i]:
      q.append(i)
for i in range(1, N + 1):
  print(DP[i], end='\n')
