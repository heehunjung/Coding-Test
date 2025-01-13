from collections import deque

def solution(n, edge):
    answer = 0
    nodes = [[] for _ in range(n+1)]
    result = [0 for _ in range(n+1)]
    visited = [0 for _ in range(n+1)]
    
    for ed in edge:
        f, s = ed
        nodes[f].append(s)
        nodes[s].append(f)
    
    def bfs(start):
        visited[start] = 1
        q = deque()
        q.append([start, 0])
        
        while q:
            current, count = q.popleft()
            
            for next in nodes[current]:
                if visited[next] == 0:
                    q.append([next, count + 1])
                    result[next] = count + 1
                    visited[next] = 1
    
            
    bfs(1)
    
    maxV = max(result)
    
    for i in result:
        if i == maxV:
            answer += 1
            
    return answer
