def solution(n, computers):
    answer = 0 
    visited = [0] * n
    
    def dfs(node):
        visited[node] = 1
        for neighbor in range(n):
            if computers[node][neighbor] == 1 and visited[node] == 0:
                dfs(neighbor)
    
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer +=1 

    return answer 