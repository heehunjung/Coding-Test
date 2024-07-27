n, k = map(int, input().split())

a, b = []

a = list(map(int, input().split()))
b = list(map(int, input().split()))

b.sort(reverse=True)
a.sort()
for i in range(k):
  if a[i] < b[i]:
    a[i] = b[i]
  else:
    break
print(sum(a))
