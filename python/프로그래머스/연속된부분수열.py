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
    left = 0  # 슬라이딩 윈도우의 시작점

    for right in range(len(sequence)):
        summ += sequence[right]  # 윈도우에 오른쪽 값 추가

        # 합이 k보다 클 경우 왼쪽 값을 빼며 조정
        while summ > k:
            summ -= sequence[left]
            left += 1

        # 합이 k와 같을 때, 구간 길이를 비교하여 정답 갱신
        if summ == k:
            if right - left < answer[1] - answer[0]:
                answer = [left, right]

    return answer

    
