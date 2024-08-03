n = int(input())

list = list(map(int, input().split()))

result = [0] * n
check = dict()
for i in range(n):
  count = 0
  if list[i] not in check:
    for j in range(n):
      if list[i] > list[j]:
        count += 1
    result[i] = count
    check[i] = list[i]  
  else:
    

print(*result)
