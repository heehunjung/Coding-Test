from collections import deque
from itertools import combinations
import sys
input = sys.stdin.readline
N = int(input())

people = [i for i in range(2,N+1)]
power = [[0 for _ in range(N+1)] for _ in range(N+1)]


for i in range(1,N+1):
    row = list(map(int, input().split()))
    for j in range(1,N+1):
        power[i][j] = row[j-1]

result = -1
fixed_people = 1

for teamA in combinations(people,(N//2-1)):
    teamA_result = 0
    teamB_result = 0
    temp_result = 0
    teamA_origin = teamA+(fixed_people,)
    for memberA in teamA_origin:
        for memberB in teamA_origin:
            if memberA != memberB:
                teamA_result += power[memberA][memberB]
                
    teamB = list(set(people)-set(teamA))
    
    # print("teamA:",teamA,"teamB:",teamB)
    
    for memberA in teamB:
        for memberB in teamB:
            if memberA != memberB:
                teamB_result += power[memberA][memberB]
                
    if teamA_result >= teamB_result:
        temp_result = teamA_result - teamB_result
    else:
        temp_result = teamB_result - teamA_result
    if result == -1:
        result = temp_result
    else:
        result = min(result, temp_result)

print(result)
            
        

        
