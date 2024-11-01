def solution(board, skill):
    n = len(board)
    m = len(board[0])
    # 누적합을 위한 2차원 배열 초기화
    delta = [[0] * (m + 1) for _ in range(n + 1)]
    
    for current in skill:
        t, r1, c1, r2, c2, degree = current
        if t == 1:  # 공격 스킬
            degree *= -1
        
        # 차분 배열에 스킬 적용
        delta[r1][c1] += degree
        delta[r1][c2 + 1] -= degree
        delta[r2 + 1][c1] -= degree
        delta[r2 + 1][c2 + 1] += degree

    # 누적합을 통해 최종 보드 상태 계산
    for i in range(n):
        for j in range(m):
            delta[i][j + 1] += delta[i][j]
    
    for j in range(m):
        for i in range(n):
            delta[i + 1][j] += delta[i][j]

    # 최종 보드에 차분 값을 더함
    for i in range(n):
        for j in range(m):
            board[i][j] += delta[i][j]

    # 0보다 큰 값의 개수 세기
    answer = sum(1 for row in board for value in row if value > 0)
    
    return answer