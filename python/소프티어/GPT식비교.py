import sys

n = int(sys.stdin.readline())
li = []
for _ in range(n):
    r, l = 0, 0
    temp = list(map(int, sys.stdin.readline().split('.')))
    if len(temp) == 1:
        r = temp[0]
        l = -1
    else:
        r, l = temp
    li.append([r,l])
li.sort(key = lambda x :(x[0], x[1]))

for l in li:
    f,s = l
    if s == -1:
        print(f)
    else:
        print(f,".",s , sep = "")
