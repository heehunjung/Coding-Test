dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
def dfs(graph, x,y):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if nx >=0 and ny >= 0 and nx < len(graph[0]) and ny < len(graph)  and graph[ny][nx] == 0:
      graph[ny][nx]=1
      dfs(graph,nx,ny)
  return 1
n,m= map(int,input().split())

graph = []
for i in range(n):
  graph.append(list(map(int,input())))
result = 0
for y in range(n):
  for x in range(m):
    if graph[y][x] == 0:
      if(dfs(graph,x,y)==1):
        result += 1

print(result)
        
      

