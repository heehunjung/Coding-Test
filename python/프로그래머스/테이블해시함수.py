def solution(data, col, row_begin, row_end):
    sorted_data = sorted(data, key = lambda x: (x[col-1], -x[0]))
    hashList = []

    for i in range(row_begin-1, row_end):
        result = 0
        for value in sorted_data[i]:
            result += value % (i+1)
        hashList.append(result)
    
    
    answer = 0
    for value in hashList:
        answer ^= value
    
    return answer
