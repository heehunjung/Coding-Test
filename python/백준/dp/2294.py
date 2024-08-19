import sys

input = sys.stdin.readline

n,k = map(int,input().split())

li = []

for _ in range(n):
    li.append(int(input()))

coins = list(set(li))
dp = [10001] * (k+1)
dp[0] = 0
for coin in coins:
    for i in range(coin,k+1):
        