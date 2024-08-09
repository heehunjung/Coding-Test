# 탑 다운
# dp = [0] * 100

# def fibo(x):
#   if x == 1 or x == 2:
#     return 1
#   if dp[x] != 0:
#     return dp[x]
#   dp[x] = fibo(x - 1) + fibo(x - 2)
#   return dp[x]

# print((fibo(99)))
# 바텀 업

d = [0] * 100

d[1] = 1
d[2] = 2

n = 99

for i in range(3, n + 1):
  d[i] = d[i - 1] + d[i - 2]

print(d[n])
