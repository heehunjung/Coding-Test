#bfs+dfs
from collections import deque


#넓이 탐색
def bfs(start, graph, visited):
  #deque
  queue = deque([start])
  #처음 노드 방문 처리
  visited[start] = 1
  #경로 저장할 List
  result = []
  #큐가 empty 될때까지
  while queue:
    #같은 레벨의 노드를 저장하기 위한 list
    tempList = []
    #현재 노드 pop (가장 오래된 것)
    now = queue.popleft()
    #경로에 입력
    result.append(now)
    #모든 간선 check
    for i in range(m):
      #해당 노드 인접 노드 중 방문 x 를 방문처리 + tempList에 입력
      if graph[i][0] == now and visited[graph[i][1]] == 0:
        visited[graph[i][1]] = 1
        tempList.append(graph[i][1])
      if graph[i][1] == now and visited[graph[i][0]] == 0:
        visited[graph[i][0]] = 1
        tempList.append(graph[i][0])
    #temp List 오름차순 정렬
    tempList.sort()
    #오름차순대로 queue에 push
    for i in range(len(tempList)):
      queue.append(tempList[i])
  print(*result)


#깊이 탐색
def dfs(now, graph, visited, stack):
  tempList = []
  stack.append(now)
  visited[now] = 1

  for i in range(m):
    if graph[i][0] == now and visited[graph[i][1]] == 0:
      tempList.append(graph[i][1])
    if graph[i][1] == now and visited[graph[i][0]] == 0:
      tempList.append(graph[i][0])
  tempList.sort()
  for i in range(len(tempList)):
    if (visited[tempList[i]] == 0):
      dfs(tempList[i], graph, visited, stack)
  return 0


n, m, v = map(int, input().split())

visited = [0] * (n + 1)
stack = []
graph = [[] for _ in range(m)]
for i in range(m):
  graph[i] = list(map(int, input().split()))

dfs(v, graph, visited, stack)
print(*stack)
visited = [0] * (n + 1)
bfs(v, graph, visited)
