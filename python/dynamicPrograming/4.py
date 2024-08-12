n, m = map(int, input().split())
money = [0] * n
tempDp = (2**63 - 1)
for i in range(n):
  money[i] = int(input())

dp = [(2**63 - 1)] * (m + 1)
index = 0
for i in range(1, money[n - 1] + 1):
  if m >= i:
    if i < money[0]:
      dp[i] = -1
    if i == money[index]:
      dp[i] = 1
      index += 1

if m < money[0]:
  print(-1)
elif m == money[0]:
  print(1)
else:
  for i in range(money[0] + 1, m + 1):
    for j in range(n):
      tempDp = (2**63 - 1)
      if i - money[j] > 0:
        if dp[i - money[j]] != -1:
          tempDp = dp[i - money[j]] + 1
      dp[i] = min(dp[i], tempDp)
    if dp[i] == (2**63 - 1):
      dp[i] = -1
