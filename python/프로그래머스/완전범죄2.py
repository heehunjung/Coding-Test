def solution(info, n, m):
    dp = [[[False for _ in range(120)] for _ in range(120)] for _ in range(120)]
    # 총 흔적: 0개 
    dp[0][0][0] = True
    total = 0
    for v1, v2 in info:
        total += v2 
    idx = 0
    # 매 번 훔치는 것은 default
    # 매 흔적을 체크하면서 다음으로 넘어감
    for v1, v2 in info:
        for a in range(n):
            for b in range(m):
                if dp[idx][a][b]:
                    if a + v1 < n:
                        dp[idx+1][a+v1][b] = True
                    if b + v2 < m:
                        dp[idx+1][a][b+v2] = True
        idx += 1
    
    
    for a in range(n):
        for b in range(m):
            if dp[idx][a][b]:
                return a

    return -1 
