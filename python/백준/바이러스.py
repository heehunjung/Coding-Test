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

def dfs(nextNode):
    global result
    nearNodes = tree[nextNode]
    visited[nextNode] =True
    
    for node in nearNodes:
        if not visited[node]:
            print(node)
            dfs(node)
            result += 1

dfs(1)
print(result)
