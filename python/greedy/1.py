#n,k를 공백을 기준으로 구분하여 입력받기
n, k = map(int, input().split())

result = 0

while n != 1:
  if n >= k:
    n = n // k
  else:
    break
  result += 1

result += (n - 1)
print(result)
