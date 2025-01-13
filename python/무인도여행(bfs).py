from collections import deque

def solution(maps):
    answer = []
    moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    maps = [list(row) for row in maps]  # 문자열 배열을 리스트 배열로 변환
    
    def bfs(start):
        x, y = start
        
        q = deque()
        q.append([x, y])
        result = int(maps[x][y])
        maps[x][y] = "X"
        
        
        while q:
            x, y = q.popleft()

            for move in moves:
                nx, ny = x + move[0], y + move[1]
                if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] != "X":
                    q.append([nx, ny])
                    result += int(maps[nx][ny])
                    maps[nx][ny] = "X" 
        return result
    
    # 모든 지점 탐색
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != "X":
                answer.append(bfs([i, j]))

    # 정렬 후 반환, 비어 있으면 [-1]
    return sorted(answer) if answer else [-1]

