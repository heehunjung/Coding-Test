from collections import deque

n = int(input())
m = int(input())

result = 0

tree = [[] for _ in range(n+1)]
visited = [ False for _ in range(n+1)]

for _ in range(m):
    a,b = map(int,input().split())
    tree[a].append(b)
    tree[b].append(a)

def dfs(nextNode): # 현재 탐색중인 노드를 파라미터로
    global result
    nearNodes = tree[nextNode] #해당 노드 근접 노드
    visited[nextNode] =True #방문처리
    
    for node in nearNodes:
        if not visited[node]: #방문 하지않은 노드만
            dfs(node)         
            result += 1       #count

dfs(1)
print(result)
