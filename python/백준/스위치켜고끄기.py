def change(a):
    if a == 1:
        return 0
    else:
        return 1

def girl(a):
    count = 1
    result  = 0
    while True:
        if 0 <= a -1 - count < n and 0 <= a - 1 + count < n:   #인덱스 내부 인 경우
            left = switch[a-1 - count]
            right = switch[a-1 + count]
        else: # 여기서 리턴
            return result
        # 여기서 업데이트
        if left == right :
            result = max(result , a - 1 + count ) 
            count += 1
        else:
            return result

def man(a):
    count = 1
    while True:
        if count * a > n:
            return count - 1
        count += 1

n = int(input())
switch = list(map(int,input().split()))
std_num = int(input())
students = [[] for _ in range(3)]

for i in range(std_num):
    index, number =(map(int,input().split()))
    
    if index == 1: # 남자
        count = man(number)
        for i in range(1,count+1):
            switch[i*number - 1] = change(switch[i*number -1])
    else:          # 여자
        right = girl(number)
        
        if right == 0:
            switch[number - 1] = change(switch[number-1])
            continue
        
        mid = number - 1
        left = mid - ( right - mid )
        for i in range(left,right+1):
            switch[i] = change(switch[i])
            
    # print(switch)

for i, val in enumerate(switch, 1):
    if i % 20 == 1 and i != 1:
        print()  # 20번째 단위마다 줄 바꿈
    print(val, end=" ")
