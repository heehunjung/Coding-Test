from collections import deque

def bfs(usado,start):
    q = deque()
    q.append(start)
    
    visited = [0] * (N+1)
    result = 0
    
    while q:
        curNode = q.popleft()
        for nextNode,value in node[curNode]:
            if visited[nextNode] == 0 and nextNode != start:
               if value >= usado:
                   result += 1
                   q.append(nextNode)
                   visited[nextNode] = 1
# value가 usado 보다 작은 거는 이제 다 제외해도 되니깐 
# value가 usado 보다 큰 것들만 탐색
# 그리고 해당 노드 기준으로 탐색하기 때문에 최신화되는 노드와의 우사도가 최선의 값임
# 그냥 다 구하는게 더 헷갈림
N,Q = map(int,input().split())
node = [[] for _ in range(N+1)]

for _ in range(N-1):  
    a, b, c = map(int, input().split())  
    node[a].append((b, c))  
    node[b].append((a, c))  

for row in node:
    print(row)
for _ in range(Q):
    k,v = map(int,input().split())
    print(bfs(k,v))
    
    
# bfs + dp