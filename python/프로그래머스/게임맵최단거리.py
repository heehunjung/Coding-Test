from collections import deque

def solution(maps):
    n = len(maps[0])
    m = len(maps)
    
    # 도착점이 벽일 경우 바로 -1 반환
    if maps[m - 1][n - 1] == 0:
        return -1

    # BFS 초기화
    queue = deque([(0, 0, 1)])  # (x, y, depth)
    visited = [[False for _ in range(n)] for _ in range(m)]
    visited[0][0] = True
    
    moves = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    while queue:
        x, y, depth = queue.popleft()

        # 도착점에 도달했을 때
        if x == n - 1 and y == m - 1:
            return depth

        # 네 방향으로 이동
        for move in moves:
            px, py = x + move[0], y + move[1]

            if 0 <= px < n and 0 <= py < m and not visited[py][px] and maps[py][px] == 1:
                visited[py][px] = True  # 방문 기록
                queue.append((px, py, depth + 1))

    # 도착점에 도달하지 못한 경우
    return -1
