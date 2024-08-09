x = int(input())

dp = [0] * (x + 1)
dp[1] = 0

for i in range(2, x + 1):
  tempMin = dp[i - 1]
  if i % 5 == 0:
    tempMin = min(tempMin, dp[i // 5])
  if i % 3 == 0:
    tempMin = min(tempMin, dp[i // 3])
  if i % 2 == 0:
    tempMin = min(tempMin, dp[i // 2])
  dp[i] = tempMin + 1
  # print(dp[i])

print(dp[x])
