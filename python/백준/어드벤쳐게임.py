def dfs(current):
    global money
    global visited
    
    currnetRoom = rooms[current]
    roomType = currnetRoom[0]
    pay = currnetRoom[1][0]
    nextRooms = currnetRoom[1][1:]
    beforeM = money
    # print(current)
    
    if roomType == 0: # 트롤
        if money >= pay:
            money = money - pay
        else:
            visited[current] = False 
            return 
        
    elif roomType == 1: #레프리콘
        if money < pay:
            money = pay
        
    else: # 빈 방
        pass
    
    if current == n:
        results.append(index)
        return 
    visited[current] = True    
    for room in nextRooms:
        if not visited[room]:
            dfs(room)
            if roomType == 0: # 트롤
                money += pay
            if roomType == 1:
                money = beforeM
    visited[current] = False
    

        
n = -1
results = []
n = int(input())  # 다음 n 값 입력
index = 1

while n != 0:
    
    
    money = 0
    rooms = [[] for _ in range(n+1)]  # rooms 리스트 초기화
    visited = [False for _ in range(n+1)]

    # 0 -> T, 1 -> L, 2 -> E
    for i in range(1,n+1):
        temp = input().split()
        
        if temp[0] == 'T':
            rooms[i].append(0)
            rooms[i].append(list(map(int, temp[1:-1])))  # T에 해당하는 숫자 리스트 추가
            
        elif temp[0] == 'L':
            rooms[i].append(1)
            rooms[i].append(list(map(int, temp[1:-1])))  # L에 해당하는 숫자 리스트 추가
            
        else:
            rooms[i].append(2)
            rooms[i].append(list(map(int, temp[1:-1])))  # E에 해당하는 숫자 리스트 추가
    
            
    dfs(1)
    n  = int(input())  # 다음 n 값 입력
    index += 1

index -= 1
set_result = set(results)

set_index = 0
for i in range(1, index+1):
    if i in set_result:  # set에서 값을 직접 확인
        print("YES")
    else:
        print("NO")

