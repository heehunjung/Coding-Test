from collections import deque
import sys
input = sys.stdin.readline
tc = int(input())

result = [0] * tc

for index in range(tc):
    n,k = map(int,input().split())
    times = [0] * (n+1)
    inputs = list(map(int, input().split()))
    for i in range(1,n+1):
        times[i] = inputs[i-1]
    rule = deque()
    check1 = deque()
    check2 = deque()
    for i in range(k):
        rule.append(list(map(int,input().split())))

    goal = int(input())
    #input 처리 끝
    # 첫 번째 요소를 기준으로 정렬
    sorted_rule = sorted(rule, key=lambda x: x[0])

    # goal을 두 번째 요소로 가지는 리스트를 뒤로 보내도록 정렬
    sorted_rule = sorted(sorted_rule, key=lambda x: x[1] == goal)

    # 다시 deque로 변환
    rule = deque(sorted_rule)
    cal = [0] * (n+1)
    
    for i in range(1,n+1):
        cal[i] = times[i]

    level = 1
    first = 0

    for i in range(k):
        a_1 = rule[i][0]
        a_2 = rule[i][1]
        
        cal[a_2] = max(cal[a_1] + times[a_2] , cal[a_2])

        if i < k-1:
            b_1 = rule[i+1][0]
            b_2 = rule[i+1][1]        
            if a_1 == b_1:
                cal[b_2] = cal[a_1]+times[b_2]
        # else:
        #     # cal[b_2] = cal[b_1] + times[b_2]

    result[index] = cal[goal]            
    
for i in range(tc):
    print(result[i])
