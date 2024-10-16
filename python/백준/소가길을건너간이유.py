from collections import deque

n,k,r  = map(int,input().split())
moves = [(1,0),(-1,0),(0,1),(0,-1)]
maps = [[0 for _ in range(n+1)] for _ in range(n+1)]
roads = [[[] for _ in range(n+1)] for _ in range(n+1)]
points = []
result = 0

def bfs(start,visited):
    result = 0 #갈수있는 개수를 구함
    q = deque()
    q.append(start)

    
    while q:
        x,y = q.pop()
        visited[x][y] = 1        
        for move in moves:
            px,py = x + move[0] , y + move[1]
            if 1 <= px < n+1 and 1 <= py < n+1 and visited[px][py] == 0:
         
                if [px,py] not in roads[x][y]:
                    if [px,py] in points:
                        result += 1
                        visited[px][py] = 1        
                    q.append([px,py])
    

    return result 

for _ in range(r):
    x1,y1,x2,y2 = map(int,input().split())
    roads[x1][y1].append([x2,y2])
    roads[x2][y2].append([x1,y1])
    
    
for _ in range(k):
    x,y  = map(int,input().split())
    cow = [x,y]
    points.append(cow)

for point in points:
    visited = [[0 for _ in range(n+1)] for _ in range(n+1)]
    temp = bfs(point,visited)
    temp = k - 1 - temp #해당 소가 못가는 곳

    result += temp

print(result//2)
    


                
                
    
    