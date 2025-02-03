from collections import deque
def solution(n, computers):
    answer = 0
    li = [[] for _ in range(len(computers))]
    visited = []
    for i in range(len(computers)):
        computer = computers[i]
        for j in range(len(computers)):
            if i != j and computer[j] == 1:
                li[i].append(j)
    q = deque()
    
    def bfs(start):
        q.append([start,1])
        visited.append(start)
        
        while q:
            current, count = q.popleft()
            
            for next in li[current]:
                if next not in visited:
                    q.append([next, count +1])
                    visited.append(next)
            
        return 1
    
    for i in range(len(computers)):
        if i not in visited:
            answer += bfs(i)
                

    return answer
