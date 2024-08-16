# import sys
# ##sys stdin readline
# input = sys.stdin.readline

# N = int(input())
# dp = list(0 for _ in range(N + 1))

# for now in range(N):
#   T, P = map(int, input().split(' '))
#   dp[now + 1] = max(dp[now + 1], dp[now])
#   if now + T < N + 1:
#     dp[now + T] = max(dp[now + T], dp[now] + P)

# print(dp[-1])

import sys

input = sys.stdin.readline

n = int(input())

dp = list(0 for _ in range(n + 1))

for now in range(n):
  t, p = map(int, input().split())
  #다음 dp의 최적 값을 업데이
  dp[now + 1] = max(dp[now + 1], dp[now])
  if now + t < n + 1:
    dp[now + t] = max(dp[now + t], dp[now] + p)

print(dp[-1])
