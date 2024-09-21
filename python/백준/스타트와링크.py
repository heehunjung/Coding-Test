import math
import sys

input = sys.stdin.readline

def backTraking(count,index):
    global total
    
    if len(teamA) == n//2:
        #teamA 기준으로 teamB 생성
        teamB = []
        for a in people:
            if a not in teamA:
                teamB.append(a)
                
        sumA = sum(teamA)
        sumB = sum(teamB)

        tempResult = abs(sumA-sumB)
        
        if tempResult == 0:
            return 0
        total = min(total,tempResult)
        if count == combination_count:
            return total        
        
    for i in range(index,n):

        if not visited[i]:
            visited[i] = True
            teamA.append(i)

            backTraking(count+1 , index+1)
            visited[i] = False
            teamA.pop()
            
    return total

def sum(team):
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
        
print(backTraking(0,0))


