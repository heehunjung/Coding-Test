from collections import deque, Counter
import math
def insertStudent(student,start):
    students = likes[student]
    visitedStudent = [0] * 4
    index = 0
    

    for people in students:
        if visited[people] != [-1,-1]:
            visitedStudent[index] = people
            index += 1
    # print("likesfriends",visitedStudent)
    # 1번 조건 x
    if index == 0:    
        visited[student] = start
        sit[start[0]][start[1]] = student
        
        emptySit[start[0]][start[1]] = -1 # 현재 노드 제외
        for near in nears:
            px = start[1] + near[1]
            py = start[0] + near[0]
            if 1 <= px <= N and 1 <= py <= N:
                if sit[py][px] == 0:
                    emptySit[py][px] -= 1
        # print(start[0],start[1],":",  emptySit[start[0]][start[1]])
        max_value = max(max(row) for row in emptySit)

        #다음 3번 조건을 만족할 좌표 계산
        ty,tx = 1,1
        while True:
            if tx == N+1 :
                tx = 1
                ty += 1
                if ty == N+1 :
                    return start
            if emptySit[ty][tx] == max_value:
                start = [ty,tx]
                break
            tx += 1
        return start
    # 1번 조건 o
    tempList = deque()
    for people in visitedStudent:
        if visited[people] != [-1,-1]:
            for near in nears:
                px = visited[people][1] + near[1]
                py = visited[people][0] + near[0]
                
                if 1 <= px <= N and 1 <= py <= N:
                    if sit[py][px] == 0:
                        tempList.append([py,px])
    # 좌표의 빈도수를 세기 위해 Counter 사용
    counter = Counter(map(tuple, tempList))  # 좌표는 리스트이므로 tuple로 변환해서 카운트
# tempList가 비어 있는 경우 처리
    if not tempList:
        # print("case1 (tempList is empty)")
        visited[student] = start
        sit[start[0]][start[1]] = student
        current = start
    else:
        # 가장 많이 중복된 횟수 찾기
        max_count = max(counter.values(), default=0)
        # 중복된 횟수가 가장 많은 좌표들 찾기
        most_common_coords = [coord for coord, count in counter.items() if count == max_count]

        if len(most_common_coords) == 1:
            # print("case2")
            sit[most_common_coords[0][0]][most_common_coords[0][1]] = student
            visited[student] =[most_common_coords[0][0],most_common_coords[0][1]]
            current = most_common_coords[0]
        else:
            # print("case3")
            max_emptySit_value = -1
            best_coord = None
            
            for coord in most_common_coords:
                ty, tx = coord
                # 가장 큰 emptySit 값 체크
                if emptySit[ty][tx] > max_emptySit_value:
                    max_emptySit_value = emptySit[ty][tx]
                    best_coord = coord
                # 만약 emptySit 값이 같다면, 행 번호 -> 열 번호 기준으로 선택
                elif emptySit[ty][tx] == max_emptySit_value:
                    if best_coord is None or (ty, tx) < best_coord:  # 행 번호가 작거나, 행이 같으면 열 번호가 작은 좌표 선택
                        best_coord = coord
                # print("emptysit",ty,tx,":",emptySit[ty][tx])
            most_common_coords = [best_coord]
            sit[most_common_coords[0][0]][most_common_coords[0][1]] = student
            visited[student] = most_common_coords[0]
            current = most_common_coords[0]
    
    
    emptySit[current[0]][current[1]] = -1 # 현재 노드 제외
    for near in nears:
        px = current[1] + near[1]
        py = current[0] + near[0]
        if 1 <= px <= N and 1 <= py <= N:
            if sit[py][px] == 0:
                emptySit[py][px] -= 1
    max_value = max(max(row) for row in emptySit)

    #다음 3번 조건을 만족할 좌표 계산
    ty,tx = 1,1
    while True:
        # if student == 12:
            # print("12:",ty,tx)
        # if student == 13:
            # print("13:",ty,tx)
        if tx == N+1 :
            tx = 1
            ty += 1
            if ty == N+1:
                return start
        if emptySit[ty][tx] == max_value:
            start = [ty,tx]
            break
        tx += 1
    return start
        


N = int(input())
studentNum = N*N 

# 학생 - 선호 정보
likes = [[]for _ in range(studentNum+1)] 
# 학생 위치 정보
visited = [[-1,-1]for _ in range(studentNum+1)]
# 자리 배열
sit = [[0 for _ in range(N+1) ] for _ in range( N+1)]
# 자리당 인근 빈자리 정보
emptySit = [[-1 for _ in range(N+1) ] for _ in range(N+1)]

member = []
# 인근 빈자리 초기화
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if (i == 1 and j == 1) or (i == 1 and j == N) or (i == N and j == 1) or (i == N and j == N):
            # 좌상, 우상, 좌하, 우하 모서리 (1,1), (1,N), (N,1), (N,N)
            emptySit[i][j] = 2
        elif i == 1 or i == N or j == 1 or j == N:
            # 테두리 나머지 부분
            emptySit[i][j] = 3
        else:
            # 그 외의 좌표는 4
            emptySit[i][j] = 4

# 인접 접근 
nears = [[1,0],[0,1],[-1,0],[0,-1]]
# 2,3번 조건을 만족하는 제일 작은 값 -> 반복하며 update 될 예정
start = [2,2]


for _ in range(studentNum):
    a,b,c,d,e = map(int,input().split())    
    member.append(a)
    likes[a] = [b, c, d, e]  # 각 학생에 대해 4명의 선호 학생을 리스트로 추가

for i in range(studentNum):
    start = insertStudent(member[i],start)
    # for sit_ in sit:
    #     print(sit_)
    # print(start)
result = 0
for i in range(1, N+1):
    for j in range(1, N+1):
        student_name = sit[i][j]
        count = 0
        for near in nears:
            px = j + near[0]
            py = i + near[1]

            if 1 <= px <= N and 1 <= py <= N:
                for like in likes[student_name]:
                    if like == sit[py][px]:
                        count += 1

        # 만족도 계산 (count에 따라 결과 업데이트)
        if count == 0:
            result += 0  # count == 0일 때는 만족도 0
        else:
            result += pow(10, count - 1)  # count >= 1일 때는 해당 규칙 적용


# for sit_ in sit:
#     print(sit_)

print(result)



#사실 중간 부터 구현이라고 생각했는데 귀찮아서 메소드 분리 안한게 이렇게 고생하게 됐다
#이렇게 풀면 안된다..