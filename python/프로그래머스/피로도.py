# def solution(k, dungeons):
#     length = len(dungeons)
#     visited = [False for _ in range(length)]
    
#     def dfs(k, result):
#         max_result = result
        
#         for i in range(length):
#             if not visited[i] and k >= dungeons[i][0]:  # 최소 필요 피로도 확인
#                 visited[i] = True
#                 max_result = max(max_result, dfs(k - dungeons[i][1], result + 1))  # 탐색 결과 갱신
#                 visited[i] = False  # 백트래킹
        
#         return max_result

#     max_answer = 0
#     for i in range(length):
#         if k >= dungeons[i][0]:  # 시작 가능 여부 확인
#             visited[i] = True
#             max_answer = max(max_answer, dfs(k - dungeons[i][1], 1))  # 초기 탐색 시작
#             visited[i] = False

#     return max_answer

def solution(k, dungeons):
    answer = -1
    length = len(dungeons)
    visited = [False for _ in range(length)]
    for i in range(length):
        mini = dungeons[i][0]
        if mini <= k:
            visited[i] = True
            answer = max(answer,dfs(dungeons,length,k-dungeons[i][1],visited,1));
            visited[i] = False
    return answer

def dfs(dungeons,length,k,visited,result):
    max_result = result
    
    for i in range(length):
        if visited[i] == False:
            if k >= dungeons[i][0]:
                visited[i] = True
                max_result = max(max_result,dfs(dungeons,length,k-dungeons[i][1],visited,result + 1))
                visited[i] = False
    
    return max_result