def solution(m, n, puddles):
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[1][1] = 1  # 시작점 초기화

    # 물 웅덩이 표시
    puddles_set = set((y, x) for x, y in puddles)

    # DP 테이블 채우기
    for x in range(1, n + 1):
        for y in range(1, m + 1):
            if (x, y) in puddles_set or (x == 1 and y == 1):
                continue  # 웅덩이거나 시작점은 계산하지 않음
            dp[x][y] = (dp[x - 1][y] + dp[x][y - 1])

    return dp[n][m] % 1000000007
