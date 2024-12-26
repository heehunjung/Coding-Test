def solution(n, m, x, y, r, c, k):
    moves = [(1, 0), (0, -1), (0, 1), (-1, 0)]  # d, l, r, u
    moves_str = ['d', 'l', 'r', 'u']

    # 맨해튼 거리 계산 함수
    def cal_dist(sx, sy, ex, ey):
        return abs(sx - ex) + abs(sy - ey)

    # 현재 위치에서 목표 위치까지 이동이 가능한지 판단
    dist = cal_dist(x, y, r, c)
    if dist > k or (k - dist) % 2 == 1:
        return "impossible"

    # Greedy 방식으로 경로 탐색
    result = []
    while k > 0:
        for i in range(4):
            nx, ny = x + moves[i][0], y + moves[i][1]

            # 유효한 좌표인지 확인
            if 1 <= nx <= n and 1 <= ny <= m:
                # 이동 후 남은 거리가 유효한지 확인
                remaining_dist = cal_dist(nx, ny, r, c)
                if remaining_dist <= k - 1 and (k - 1 - remaining_dist) % 2 == 0:
                    result.append(moves_str[i])
                    x, y = nx, ny
                    k -= 1
                    break

    return ''.join(result)
