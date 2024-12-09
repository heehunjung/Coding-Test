def solution(n, computers):
    answer = 0
    length = len(computers)
    connections = [[] for _ in range(length)]
    visited = [0 for _ in range(length)]
    
    for i in range(length):
        for j in range(length):
            if i != j and computers[i][j] == 1:
                connections[i].append(j)
    
    def dfs(connections,start,visited):
        if visited[start] == 0:
            visited[start] = 1
            for connect in connections[start]:
                dfs(connections,connect,visited)
            return 1
        return 0

    for i in range(length):
        if dfs(connections,i,visited) == 1:
            answer += 1
    
                
    return answer