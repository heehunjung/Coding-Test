def solution(info, n, m):
    dp = [[[False] * m for _ in range(n)] for _ in range(len(info) + 1)]
    dp[0][0][0] = True
    
    for i, (info_a, info_b) in enumerate(info):
        for A in range(n):
            for B in range(m):
                if dp[i][A][B]:
                    # A 도둑이 훔치는 경우
                    na = A + info_a
                    nb = B + info_b
                    if na < n:
                        dp[i+1][na][B] = True
                
                    # B 도둑이 훔치는 경우
                    if nb < m:
                        dp[i+1][A][nb] = True
    
    for a in range(n):
        for b in range(m):
            if dp[len(info)][a][b]:
                return a
    
    return -1
