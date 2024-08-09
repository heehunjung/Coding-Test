#바텀업
n = int(input())
list = list(map(int, input().split()))

dp = [0] * n

dp[0] = list[0]
dp[1] = list[1]
dp[2] = list[0] + list[2]
for i in range(3, n):
  dp[i] = max(dp[i - 2] + list[i], dp[i - 3] + list[i])

print(dp[n - 1])
