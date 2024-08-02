from bisect import bisect_left, bisect_right


def count(array, left, right):
  right_index = bisect_right(array, right)
  left_index = bisect_left(array, left)
  return right_index - left_index


n, m = map(int, input().split())
list = list(map(int, input().split()))

result = count(list, n, n)

if count == 0:
  print(-1)
else:
  print(count)
