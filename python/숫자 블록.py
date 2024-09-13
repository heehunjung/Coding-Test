from collections import deque

# 입력 받기
N, M, P, K = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

# 방향: 상하좌우
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 방문한 상태 저장을 위한 집합
visited = set()

# BFS 큐 초기화 (좌상단에서 시작)
initial_remainder = grid[0][0] % P
visited.add((0, 0, initial_remainder))
queue = deque()
queue.append((0, 0, initial_remainder, 0))  # (행, 열, 나머지, 이동 횟수)

min_steps = -1

while queue:
    i, j, rem, steps = queue.popleft()
    
    if rem == K:
        min_steps = steps
        break  # 최소 이동 횟수를 찾았으므로 종료
    
    # 인접한 칸 탐색
    for dx, dy in directions:
        ni, nj = i + dx, j + dy
        if 0 <= ni < N and 0 <= nj < M:
            new_rem = (rem * 10 + grid[ni][nj]) % P
            state = (ni, nj, new_rem)
            if state not in visited:
                visited.add(state)
                queue.append((ni, nj, new_rem, steps + 1))

print(min_steps)
