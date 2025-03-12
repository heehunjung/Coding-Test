from collections import deque

def solution(n, roads, sources, destination):
    # 그래프 구성
    graph = [[] for _ in range(n + 1)]
    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)
    
    #destination에서 시작하는 BFS
    distances = [-1] * (n + 1)
    q = deque([destination])
    distances[destination] = 0
    
    while q:
        current = q.popleft()
        for neighbor in graph[current]:
            if distances[neighbor] == -1:
                distances[neighbor] = distances[current] + 1
                q.append(neighbor)
    # 각 source에 대해 결과 추출
    return [distances[source] for source in sources]
