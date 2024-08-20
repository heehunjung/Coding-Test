li = list(input())

stack = []
result = 0
tmp = 1

for i in range(len(li)):
    if li[i] == "(":
        stack.append(li[i])
        tmp *= 2
    elif li[i] == "[":
        stack.append(li[i])
        tmp *= 3
    elif li[i] == ")":
        if not stack or stack[-1] == "[":
            result = 0
            break
        if li[i-1] == "(":
            result += tmp
        stack.pop()
        tmp //= 2
    elif li[i] == "]":
        if not stack or stack[-1] == "(":
            result = 0
            break
        if li[i-1] == "[":
            result += tmp
        stack.pop()
        tmp //= 3

if stack:
    print(0)
else:
    print(result)