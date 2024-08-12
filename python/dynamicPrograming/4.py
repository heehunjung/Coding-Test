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

print(dp[1:])

# ###

# # 정수 N, M을 입력 받기
# n, m = map(int, input().split())
# # N개의 화폐 단위 정보를 입력 받기
# array = []
# for i in range(n):
#   array.append(int(input()))

# # 한 번 계산된 결과를 저장하기 위한 DP 테이블 초기화
# d = [10001] * (m + 1)

# # 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
# d[0] = 0
# for i in range(n):
#   for j in range(array[i], m + 1):
#     if d[j - array[i]] != 10001:  # (i - k)원을 만드는 방법이 존재하는 경우
#       d[j] = min(d[j], d[j - array[i]] + 1)

# # 계산된 결과 출력
# if d[m] == 10001:  # 최종적으로 M원을 만드는 방법이 없는 경우
#   print(-1)
# else:
#   print(d[m])
