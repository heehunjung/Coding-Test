from collections import deque, defaultdict

def solution(tickets):
    tickets.sort()
    routes = defaultdict(list)
    
    # 그래프 생성
    for start, end in tickets:
        routes[start].append(end)
    
    answer = []
    stack = ["ICN"]  # 항상 ICN에서 출발
    
    while stack:
        while routes[stack[-1]]:
            stack.append(routes[stack[-1]].pop(0))
        answer.append(stack.pop())
    
    return answer[::-1]  # 결과 뒤집기
