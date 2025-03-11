from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    # 모든 좌표 * 2 : ㄷ 자 형태 경로일 때 사실 한 개의 길인데 컴퓨터는 2개로 인식해서 2배로 늘려줌 
    box = [[-1 for _ in range(102)] for _ in range(102)]
    visited = [[0 for _ in range(102)] for _ in range(102)]
    moves = [[1,0],[-1,0],[0,1],[0,-1]]
    
    for rec in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, rec)
        
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                if x1 < x < x2 and y1 < y < y2:
                    box[x][y] = 0
                # 0이면 box의 내부인것임. 내부가 아닌 테두리에 1을 표시 
                elif box[x][y] != 0:
                    box[x][y] = 1
    
    def bfs(start, target):
        x, y = start
        q = deque()
        q.append([x * 2,y * 2, 0])
        visited[x * 2][y * 2] = 1
        while q:
            cx, cy , count = q.popleft()
            if [cx, cy] == target:
                return count
            
            for move in moves:
                nx, ny = cx + move[0], cy + move[1]
                
                if 0 <= nx < len(box) and 0 <= ny < len(box) and visited[nx][ny] == 0:
                    if box[nx][ny] == 1:
                        q.append([nx,ny,count + 1])
                        visited[nx][ny] = 1

    return bfs([characterX , characterY], [itemX * 2, itemY * 2]) // 2
