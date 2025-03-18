import heapq
from math import inf

def solution(N, road, K):
    answer = 0
    graph = [[] for _ in range(N+1)]
    distance = [inf for _ in range(N+1)]
    
    for f,s, v in road:
        graph[f].append([s,v])
        graph[s].append([f,v])
    
    q = []
    distance[1] = 0
    heapq.heappush(q, [distance[1], 1])
    result = []
    
    while q:
        d, i = heapq.heappop(q)
            
        for ii, dd in graph[i]:
            if distance[ii] > d + dd:
                distance[ii] = dd  + d
                heapq.heappush(q, [distance[ii], ii])
    
    for  d in distance:
        if d <= K:
            answer += 1
            
    return answer
