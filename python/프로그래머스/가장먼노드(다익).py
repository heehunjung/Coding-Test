from math import inf
import heapq

def solution(n, edge):
    answer = 0
    graph = [[] for _ in range(n+1)]
    distance = [inf for _ in range(n+1)]
    q = []
    
    for f,s in edge:
        graph[f].append(s)
        graph[s].append(f)
    
    distance[1] = 0
    heapq.heappush(q, [distance[1], 1])
    
    #모든 간선 길이를 1이라고 생각 
    while q:
        d, i = heapq.heappop(q)
        
        for ii in graph[i]:
            if distance[ii] > d + 1:
                distance[ii] = d + 1
                heapq.heappush(q, [distance[ii], ii])
    
    maxL = max(distance[1:])
    for v in distance:
        if v == maxL:
            answer += 1      
    return answer
