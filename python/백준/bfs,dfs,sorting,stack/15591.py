from collections import deque

def bfs(usado,start):
    q = deque()
    q.append(start)
    
    #방문처리 및 결과
    visited = [0] *(N+1)
    result = 0
    
    while q:
        curNode = q.pop()
        for nextNode,value in node[curNode]:
            if visited[nextNode] == 0 and nextNode != start:
                if value >= usado:
                    result += 1
                    q.append(nextNode)
                    visited[nextNode] = 1        
    return result
        
N,Q = map(int,input().split()) 

node = [[] for _ in range(N+1)]  
for _ in range(N-1):  
    a, b, c = map(int, input().split())  
    node[a].append((b, c))  
    node[b].append((a, c))  


for _ in range(Q):
    k,v = map(int,input().split())
    print(bfs(k,v))


#그냥 내 생각에서 nxn 행렬 채워야 된다 생각하면 일단 bfs,dfs 생각하고
#dp 까지 이어나가자 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#유사도에대해 깊게 생각하지 않아 어렵게 푼 것 같네
