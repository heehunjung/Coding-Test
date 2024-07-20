def gcd_recur(a, b):
  if b == 0:
    return a
  return gcd_recur(b, a % b)


print(gcd_recur(6, 3))
