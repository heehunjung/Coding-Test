# import sys


# def backTracking(cnt):
#     global flag

#     # 3개의 장애물을 설치했다면
#     if cnt == 3:
#         # 선생님의 위치에서 감시를 한다.
#         if bfs():
#             flag = True # 성공했다면 flag를 true로 초기화
#             return
#     else:
#         # 모든 빈공간에 장애물을 3개씩 설치해본다.
#         for x in range(n):
#             for y in range(n):
#                 if graph[x][y] == "X":
#                     graph[x][y] = "O"
#                     backTracking(cnt + 1) # backTracking
#                     graph[x][y] = "X"

# # bfs를 통해 감시
# def bfs():
#     dx = [1, -1, 0, 0]
#     dy = [0, 0, 1, -1]
#     for t in teacher:# 선생님의 위치에서
#         for k in range(4): # 상/하/좌/우 탐색
#             nx, ny = t

#             while 0 <= nx < n and 0 <= ny < n:
#                 if graph[nx][ny] == "O":
#                     break

#                 # 학생이 보이면 실패
#                 if graph[nx][ny] == "S":
#                     return False

#                 nx += dx[k]
#                 ny += dy[k]

#     # 모두 통과하면 학생이 안보이는 것으로 성공
#     return True


# n = int(sys.stdin.readline())
# flag = False
# graph = []
# teacher = []

# # 반복문을 통해 복도 정보를 입력 받는다.
# for i in range(n):
#     graph.append(list(map(str, sys.stdin.readline().split())))
#     for j in range(n):
#         if graph[i][j] == "T": # 선생님이 있는 좌표를 저장
#             teacher.append([i, j])


# backTracking(0)

# if flag:
#     print("YES")
# else:
#     print("NO")
import sys

def backTraking(cnt):
    global flag
    if cnt == 3:
        if bfs(): # 길이를 체크하는게 아니라 성공 실패 여부를 체크하는거고
            flag = True
            return
    else:
        for x in range(n):
            for y in range(n):
                if graph[x][y] == "X":
                    graph[x][y] = "O"
                    backTraking(cnt+1) # 반환하지 않고 그냥 나온 경우 
                    graph[x][y] = "X" # 그대로 진행
                    # 이 부분은 그냥 중복되지 않은 순열 뽑는 거랑 같은 거임

def bfs():
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    for t in teacher:
        for k in range(4):
            nx,ny = t
            while 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] == "O":
                    break
                if graph[nx][ny] == "S":
                    return False
                nx += dx[k]
                ny += dy[k]
    return True

n = int(sys.stdin.readline())
flag =False
graph = []
teacher = []

for i in range(n):
    graph.append(list(map(str, sys.stdin.readline().split())))
    for j in range(n):
        if graph[i][j] == "T":
            teacher.append([i,j])

backTraking(0)

if flag:
    print("YES")
else:
    print("NO")
