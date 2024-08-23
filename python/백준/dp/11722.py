# import sys

# input = sys.stdin.readline

# n = int(input())
# array = list(map(int,input().split()))
# dp = [0] * len(array)
# dp[0] = 1
# for i in range(1,len(array)):
#     for j in range(0,i):
#         if array[i]< array[j]:
#             dp[i] = max(dp[i],dp[j]+1)
#     if dp[i] == 0:
#         dp[i] = 1

# result = max(dp)

# print(result)
import sys

input = sys.stdin.readline

n = int(input())
array = list(map(int, input().split()))
dp = [0] * len(array)
dp[0] = 1
for i in range(1, len(array)):
    for j in range(0, i):
        if array[i] < array[j]:
            dp[i] = max(dp[i], dp[j] + 1)
    if dp[i] == 0:
        dp[i] = 1

result = max(dp)

print(result)
