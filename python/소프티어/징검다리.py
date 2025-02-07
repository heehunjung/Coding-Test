import sys
    
n = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))

answer = [1 for _ in range(n)]   

for i in range(1, n):
    for j in range(i):
        if li[j] < li[i]:
            answer[i] = max(answer[j] + 1, answer[i])
    
print(max(answer))
