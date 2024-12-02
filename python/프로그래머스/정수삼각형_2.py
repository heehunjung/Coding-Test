def solution(triangle):
    answer = -1
    length = len(triangle)
    dp = [[0 for _ in range(length)] for _ in range(length)]
    
    dp[0][0] = triangle[0][0]
    
    for i in range(length):
        leng = len(triangle[i])
        
        for j in range(leng):
            if i != 0:
                if j == 0:
                    dp[i][j] = dp[i-1][j] + triangle[i][j]
                    continue
                if j == leng-1:
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j]
                    continue
                dp[i][j] = max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j]
                pass
    
    
    answer = max(dp[length-1])
        
    return answer