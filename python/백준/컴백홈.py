r,c,k = map(int,input().split())

road = [[0 for _ in range(c)] for _ in range(r)] # 입력 정보
dx = [1,-1,0,0]
dy = [0,0,1,-1]
# 상하좌우
result = 0 # 결과 저장 변수
for i in range(r):
    li = list(input()) 
    for j in range(c):
        if li[j] == "T":
            road[i][j] = True
        else:
            road[i][j] = False
# 초기화

#dfs , 백트래킹
def dfs(current,count):
    global result 
    
    x,y = current
    road[y][x] = True
    # print(current)
    
    if x == c-1 and y == 0:
        if count == k: # 조건을 만족하는 경우
            result += 1
        road[y][x] = False #조건을 만족하지 않지만 더 탐색하지 않아도 되는 경우
        return  #해당 위치를 다시 방문 안함으로 돌려주고 return 
    
    if count > k: # 조건을 만족하지 않지만 더 탐색하지 않아도 되는 경우
        road[y][x] = False    
        return 

    # for row in visited:
    #     print(row)
    # print(count)
    # print("-------------")

    for i in range(4):
        px = x + dx[i]
        py = y + dy[i]
        
        if 0 <= px < c and 0 <= py < r:
            
            if road[py][px] == False: #방문 한적 없는 위치
                count += 1 # count 증가
                road[py][px] = True # 방문처리
                next = [px,py]
                dfs(next,count) # dfs 방식으로 깊게 탐색
                count -= 1 # 이 경우는 return으로 끝난 것이 아니라 해당 위의 노드가 탐색 끝나서 현재 노드로 돌아온 상황임
                road[py][px] = False  # 이전 상황으로 초기화

current = [0,r-1]
dfs(current,1)
print(result)


    
    
    
