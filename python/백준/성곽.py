# 1. 방 -> dfs
# 2. 가장 넓은 방 -> dfs 마다 최대 길이 return 후 max
# 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기 -> 붙은 방 다 확인하면서 비교해야되나
import math
def toBinary(num):

    return [int(x) for x in f"{num:04b}"]


def whatis(currentNode):
    x,y = currentNode
    global visited
    global depth
    global rooms
    
    visited[x][y] = True
    value = rooms[x][y]
    binary = toBinary(value)
    index = 0
    rooms[x][y] = room_num
    
    for move in moves:       
        if binary[index] == 1:
            index += 1 
            continue
        px,py = x + move[0], y + move[1]
        # print(index)
        index += 1
        if 0 <= px < m and 0 <= py < n:
            nextNode = [px,py]
            # print("currnet: ",currentNode,"binary: ",binary ,",index: ",index-1,", nextNode: ",nextNode)

            if not visited[px][py] :
                whatis(nextNode)
                depth += 1 

            
            
n,m = map(int,input().split())
rooms = []
moves = [(1,0),(0,1),(-1,0),(0,-1)]
        #남: 8 ,동: 4 ,북: 2, 서: 1
room_num = 0 
room_v = []
result = 0
visited = [[False for _ in range(n)]for _ in range(m)]
for i in range(m):
    rooms.append(list(map(int,input().split())))

for i in range(m):
    for j in range(n):
        if not visited[i][j]:
            room_num += 1
            node = [i,j]
            depth = 1
            whatis(node)
            room_v.append(depth)
            result = max(depth,result)

for room in rooms:
    
print(room_num)
print(result)




near_room = [[False for _ in range(room_num + 1)] for _ in range(room_num + 1)]

result_near = 0
for i in range(m):
    for j in range(n):
        room_value1 = rooms[i][j]
        for move in moves:
            px,py = i + move[0], j + move[1]
            
            if 0 <= px < m and 0 <= py < n:
                room_value2 = rooms[px][py]
                if room_value1 != room_value2 and near_room[room_value1][room_value2] == False:
                    near_room[room_value1][room_value2] = True
                    near_room[room_value2][room_value1] = True
                    
                    result_near = max(result_near, room_v[room_value1-1] + room_v[room_value2-1])
                    
print(result_near)
                    
        
            
    



        
            
    
    
     
        


