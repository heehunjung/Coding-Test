# def solution(sequence, k):
#     answer = [0, len(sequence)]
#     summ = 0
#     dp = [[] for _ in range(len(sequence))]
#     index = 0
#     for idx,sec in enumerate(sequence):
#         if index == 0:
#             dp[index].append([idx, sec])
#         else:
#             for val in dp[index-1]:
#                 prv_idx, prv_sec = val

#                 if prv_sec+sec <= k:
#                     dp[index].append([prv_idx, prv_sec+sec])
#                 if sec <= k:
#                     dp[index].append([index, sec])
                
#         for val in dp[index]:
#             current_idx, current_sec = val
#             if current_sec == k:
#                 if index - current_idx < answer[1] - answer[0]:
#                     answer = [current_idx, index]
#         index += 1 
#     return answer
# 시간 복잡도 통과 x

def solution(sequence, k):
    answer = [0, len(sequence)]
    summ = 0
    dp = [[] for _ in range(len(sequence))]
    index = 0
    for idx,sec in enumerate(sequence):
        if index == 0:
            dp[index].append([idx, sec])
        else:
            for val in dp[index-1]:
                prv_idx, prv_sec = val

                if prv_sec+sec <= k:
                    dp[index].append([prv_idx, prv_sec+sec])
                if sec <= k:
                    dp[index].append([index, sec])
                
        for val in dp[index]:
            current_idx, current_sec = val
            if current_sec == k:
                if index - current_idx < answer[1] - answer[0]:
                    answer = [current_idx, index]
        index += 1

    return answer
    
