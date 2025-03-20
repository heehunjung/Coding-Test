def process_row(start, w, num, x, is_reverse, n):
    answer = 0
    if is_reverse:
        range_func = range(w - 1, -1, -1)
    else:
        range_func = range(w)
    
    for j in range_func:
        if start > n:
            break
        if start == num:
            x = j
            answer += 1
        if start > num and j == x:
            answer += 1
        start += 1
    
    return start, x, answer

def solution(n, w, num):
    answer = 0
    start = 1
    x = -1
    
    for i in range(n // w + 1):
        is_reverse = i % 2 == 1
        start, x, row_answer = process_row(start, w, num, x, is_reverse, n)
        answer += row_answer
    
    return answer
