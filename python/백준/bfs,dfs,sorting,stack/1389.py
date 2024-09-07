from collections import deque

n,m = map(int,input().split())

board = []
for i in range(m):
    board.append(list(map(int,input().split())))

result = 0 # result에 입력시 min으로 update

queue = deque()


        
    
for i in range(1,n+1):
    current = i
    queue.append(current) 
    level = 0
    compare = 0
    temp = deque()
    while queue:
        current = queue.popleft()
        compare += level
        for li in board:
            if current == li[0]:
                queue.append(li[1])
                temp.append(li[1])                                                           
        if not queue:
            level += 1
        
    if i ==1:
        result = compare
    else:
        result = min(compare,result)
        print("compare,result = ",compare,result)
        

print(result)