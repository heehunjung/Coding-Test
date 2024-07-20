def gcd_recur(a, b):
  if b == 0:
    return a
  # if a%b == 0:
  #   return b
  return gcd_recur(b, a % b)


print(gcd_recur(192, 162))
