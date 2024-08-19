n = int(input())
first = 3
second = 7
result = 0
for i in range(2,n):
    result = second * 2 + first
    first = second
    second = result
    
result = result % 9901

print(result)