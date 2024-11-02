def solution(triangle):
    answer = 0
    length = 0
    
    for row in triangle:
        length += len(row)
    
    dp = [0 for _ in range(length+1)]
    
    dp[0] = triangle[0][0]

    n = 1
    for row in triangle:
        row_len = len(row)
        
        if row_len == 1:
            continue
    
        for i in range(row_len):

            current_row = row_len
            before_row = row_len -1
            
            if i == 0:
                dp[n] = dp[n-before_row] + row[i]
            elif i == row_len-1:
                dp[n] = dp[n-current_row] + row[i]
            else:
                dp[n] = max(dp[n-current_row],dp[n-current_row+1]) + row[i]
            n += 1

    answer = max(dp)
        
    
    return answer