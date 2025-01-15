from collections import deque

def solution(n, results):
    graphs = [[deque() for _ in range(2)] for _ in range(n + 1)]  # 승/패 기록 저장용
    for result in results:
        winner, loser = result
        graphs[winner][0].append(loser)  # 승리 기록
        graphs[loser][1].append(winner)  # 패배 기록
    
    def bfs(current, game):
        visited = [0 for _ in range(n+1)]
        q = deque()
        q.append(current)
        visited[current] = 1
        result = 0
        while q:
            now = q.popleft()
            for val in graphs[now][game]:
                if visited[val] == 0:
                    q.append(val)
                    visited[val] = 1
                    result += 1
        return result 
                
                
    answer = 0
    for i in range(1, n + 1):
        win_count = bfs(i, 0)  # 이긴 경기 수
        lose_count = bfs(i, 1)  # 진 경기 수
        
        # 총 경기 수가 n-1이면 순위를 알 수 있음
        if win_count + lose_count == n - 1:
            answer += 1
    
    return answer
