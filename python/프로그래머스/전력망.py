from collections import deque

def solution(n, wires):
    answer = n
    
    li = [[] for _ in range(n+1)]
    

    for wire in wires:
        node1,node2 = wire
        
        li[node1].append(node2)
        li[node2].append(node1)
    for wire in wires:
        answer = min(answer,disconnect(wire,wires,li,n))
        
    return answer

def disconnect(wire, wires, li, n):
    visited = [0 for _ in range(n+1)]
    node1, node2 = wire
    
    li[node1].remove(node2)
    li[node2].remove(node1)
   
    count = bfs(1, li, n)
    
    li[node1].append(node2)
    li[node2].append(node1)
    
    print(wire,count)
    return abs((n - count) - count)

    
def bfs(start, li, n):
    visited = [False] * (n + 1)
    queue = deque()
    queue.append(start)
    visited[start] = True
    count = 1
    
    while queue:
        current = queue.popleft()
        
        for neighbor in li[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1
    
    return count
    
    
    
    
    
    
    
    
    
    
    
    
    