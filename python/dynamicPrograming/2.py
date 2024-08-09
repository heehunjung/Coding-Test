#바텀업
n = int(input())
list = list(map(int, input().split()))

dp = [0] * n

dp[0] = list[0]
dp[1] = max(list[0], list[1])
for i in range(2, n):
  dp[i] = max(dp[i - 2] + list[i], dp[i - 1])

print(dp[n - 1])
