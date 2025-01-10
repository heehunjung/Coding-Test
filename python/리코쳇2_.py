from collections import deque

def bfs(board, start, target):
    x, y = start
    visited = [[0 for _ in range(len(board[0]))] for _ in range(len(board))]
    moves = [(1,0), (-1,0), (0,1), (0,-1)]
    result = -1
    q = deque()
    q.append([x,y,0])
    visited[x][y] = 1
    result = []
    while q:
        cx, cy, count = q.popleft()
        if [cx, cy] == target:
            result.append(count)
            
        for move in moves:
            nx, ny = cx + move[0] , cy + move[1]
            while 0 <= nx < len(board) and 0 <= ny < len(board[0]) and board[nx][ny] != "D":
                if nx + move[0] == len(board) or ny + move[1] == len(board[0]) or nx + move[0] == -1 or ny + move[1] == -1:
                    if board[nx][ny] != "D" and visited[nx][ny] == 0:
                        visited[nx][ny] = 1
                        q.append([nx,ny,count + 1])
                        break           
                else:
                    if board[nx][ny] != "D" and board[nx + move[0]][ny + move[1]] == "D" and visited[nx][ny] == 0:
                        visited[nx][ny] = 1
                        q.append([nx,ny,count + 1])
                        break
                nx += move[0]
                ny += move[1]
    
    if not result:
        return -1
    return min(result)
    
    
    
def solution(board):
    answer = 0
    start = []
    target = []
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == "R":
                start = [i,j]
            if board[i][j] == "G":
                target = [i,j]
    answer = bfs(board, start, target)
    return answer
