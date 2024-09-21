import math
import sys

input = sys.stdin.readline

def backTraking(index):
    global total
    
    if len(teamA) == n//2:
        #teamA 기준으로 teamB 생성
        teamB =[i for i in range(n+1) if i not in teamA]
                
        sumA = calculate_power(teamA)
        sumB = calculate_power(teamB)
        tempResult = abs(sumA-sumB)
        
        if tempResult == 0:
            total = 0
            return True
        
        total = min(total,tempResult)
        return False
    
    for i in range(index,n+1):
        if not visited[i]:
            visited[i] = True
            teamA.append(i)
            
            result = backTraking(i+1)
            if result:
                return True
            
            visited[i] = False
            teamA.pop()
            
    return False

def calculate_power(team):
    result = 0
    for i in team:
        for j in team:
            if j != i:
                result += power[i][j]
    return result
    

n = int(input())
combination_count = math.comb(n, 2) // 2

people = [i+1 for i in range(n)]
visited = [False] * (n+1)
power = [[0 for _ in range(n+1)] for _ in range(n+1)]
total = sys.maxsize # 결과 큰 수로 초기화

teamA = []

for x in range(1,n+1):
    temp = list(map(int,input().split()))
    for y in range(n):
        power[x][y+1] = temp[y]

backTraking(1)  
print(total)


# import sys

# input = sys.stdin.readline

# def backTraking(index):
#     global total

#     if len(teamA) == n // 2:
#         # teamA 기준으로 teamB 생성
#         teamB = [a for a in people if a not in teamA]

#         # 팀 능력치 계산
#         sumA = calculate_power(teamA)
#         sumB = calculate_power(teamB)
#         tempResult = abs(sumA - sumB)

#         if tempResult == 0:
#             total = 0
#             return True  # 조기 종료

#         total = min(total, tempResult)
#         return False  # 재귀 계속 진행

#     for i in range(index, n):
#         if not visited[i]:
#             visited[i] = True
#             teamA.append(i)

#             result = backTraking(i + 1)
#             if result:  # result가 True이면 조기 종료
#                 return True

#             visited[i] = False
#             teamA.pop()
#     return False

# def calculate_power(team):
#     result = 0
#     for i in team:
#         for j in team:
#             if i != j:
#                 result += power[i][j]
#     return result

# n = int(input())
# people = list(range(n))
# visited = [False] * n
# total = sys.maxsize  # 결과 큰 수로 초기화
# teamA = []

# # 능력치 입력받기 (0부터 시작하는 인덱스로 수정)
# power = [list(map(int, input().split())) for _ in range(n)]

# backTraking(0)
# print(total)
