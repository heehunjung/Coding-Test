def checkBoard(board, mark):
    result = 0
    bingo = 0
    
    for i in range(3):
        isBingo = True
        isBingo_ = True
        for j in range(3):
            if board[i][j] == mark:
                result += 1
            else:
                isBingo = False
            if board[j][i] != mark:
                isBingo_ = False
        if isBingo == True:
            bingo += 1
        if isBingo_ == True:
            bingo += 1 
    
    isBingo = True
    for i in range(3):
        if board[i][i] != mark:
            isBingo = False
            break
    if isBingo == True:
        bingo += 1
    
    isBingo = True
    for i in range(3):
        if board[i][2-i] != mark:
            isBingo = False
            break
    if isBingo == True:
        bingo += 1    
    
    return [result,bingo]
                
def solution(board):
    
    o_count , o_bingo = checkBoard(board,"O")    
    x_count , x_bingo = checkBoard(board,"X")

    if o_bingo == 2 and x_bingo == 0:
        if o_count == 5 and x_count == 4:
            return 1
        else:
            return 0
    
    if o_bingo > 1 or x_bingo > 1:
        return 0

    if o_bingo == 1 and x_bingo == 1:
        return 0
    
    if o_bingo == 1 and x_bingo == 0:
        if o_count == x_count + 1:
            return 1
        else:
            return 0
    
    if o_bingo == 0 and x_bingo == 1:
        if o_count == x_count:
            return 1
        else:
            return 0
       
    if o_count == x_count + 1 or o_count == x_count:
        return 1
    else:
        return 0
    
    return answer
