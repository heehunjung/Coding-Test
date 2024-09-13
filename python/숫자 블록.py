from collections import deque

# Read input
N, M, P, K = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

# Directions: up, down, left, right
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# Initialize visited states
visited = [[[False for _ in range(P)] for _ in range(M)] for _ in range(N)]

# Initialize BFS queue starting from the top-left cell (0, 0)
initial_remainder = grid[0][0] % P
visited[0][0][initial_remainder] = True
queue = deque()
queue.append((0, 0, initial_remainder, 0))  # (row, col, remainder, steps)

min_steps = -1

while queue:
    i, j, rem, steps = queue.popleft()
    
    if rem == K:
        if min_steps == -1 or steps < min_steps:
            min_steps = steps
            # Since we're looking for the minimal steps, we can skip further processing if steps == 0
            if min_steps == 0:
                break  # Can't find a shorter path than 0 steps

    # Explore adjacent cells
    for dx, dy in directions:
        ni, nj = i + dx, j + dy
        if 0 <= ni < N and 0 <= nj < M:
            new_rem = (rem * 10 + grid[ni][nj]) % P
            if not visited[ni][nj][new_rem]:
                visited[ni][nj][new_rem] = True
                queue.append((ni, nj, new_rem, steps + 1))

print(min_steps)
