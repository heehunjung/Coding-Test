import sys 
sys.setrecursionlimit(10000) #재귀 깊이 설정
def solution(maps):
    answer = []
    moves = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    maps = [list(row) for row in maps]  # 문자열 배열을 리스트 배열로 변환

    def dfs(current):
        x, y = current
        
        # 이미 방문한 경우 0 반환
        if maps[x][y] == "X":
            return 0

        # 현재 위치 값 추가 및 방문 처리
        result = int(maps[x][y])
        maps[x][y] = "X"

        # 4방향 탐색
        for move in moves:
            nx, ny = x + move[0], y + move[1]
            if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] != "X":
                result += dfs([nx, ny])  # 반환된 값을 누적

        return result

    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if maps[i][j] != "X":  # 아직 방문하지 않은 경우
                temp = dfs([i, j])
                if temp != 0:  # 유효한 결과만 추가
                    answer.append(temp)

    # 정렬 후 반환, 비어 있으면 [-1]
    return sorted(answer) if answer else [-1]
