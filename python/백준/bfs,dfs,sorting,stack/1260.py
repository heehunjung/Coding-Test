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

# dfs 깊이 탐색 - stack을 이용
# 시작 노드부터 !
# 현재 노드를 stack에 push
# 그리고 주변 노드 탐색 & 탐색 x 노드를 stack에 넣음
# 이게 안될때까지 reculsive하게 반복
# 그 뒤로 pop 하면 dfs임 처음 들어간것부터 출력이니깐

# bfs 넓이 탐색 - queue를 이용 (deque)
# 시작 노드 부터 !
# 현재 노드를 queue에 push

# 현재 노드를 pop
# 그리고 주변 노드 탐색 & 탐색 x 노드를 넣어요
# 이거를 queue가 비어있을 때 까지 !
# - 이러면 같은 레벨 다 탐색하고 다음 레벨 감
