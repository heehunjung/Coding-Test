#N*N 행렬의 모든 원소를 각자 더하는 함수
def mul_add_all():
    result = 0
    for y in range(N):
        for x in range(N):
            temp = filter[y][x] * filterSized_image[y][x]
            result += temp
    return result

#좌측 상단 점을 기준으로 N*N 행렬을 만드는 함수
def make_N_size_image(x,y):
    resized_image = [[0 for _ in range(N)] for _ in range(N)]

    for i in range(N):              #y축
        for j in range(N):          #x축
            resized_image[i][j] = image[y+i][x+j]

    return resized_image

N,M = map(int,input().split())
size = M-N+1

filter = []
image = []
filterSized_image = []

for _ in range(N):
    filter.append(list(map(int,input().split())))
for _ in range(M):
    image.append(list(map(int,input().split())))

filterd_image = [[0 for _ in range(size)] for _ in range(size)]

for y in range(size):
    for x in range(size):
        filterSized_image = make_N_size_image(x,y)
        temp = mul_add_all()
        filterd_image[y][x] = temp

# 필터링된 이미지 출력
for row in filterd_image:
    print(' '.join(map(str, row)))
