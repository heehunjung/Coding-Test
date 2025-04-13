def solution(points, routes):
    answer = set()
    result = 0
    n = len(routes)
    m = len(routes[0])
    
    max_v = 0
    for a in points:
        max_v = max(max_v, max(a))
    current = [[0 for _ in range(max_v+1)] for _ in range(max_v+1)]
    
    def move(now, goal):
        x, y = now
        current[x][y] -= 1
        x2, y2 = goal
        rx, ry = x, y
        if x != x2:
            if x < x2:
                rx += 1
            else:
                rx -= 1
        else:
            if y < y2:
                ry += 1
            else:
                ry -= 1
        current[rx][ry] += 1
        answer.add((rx, ry))
        return [rx, ry]
    
    now_point = [[] for _ in range(n)]
    for i in range(n):
        fx, fy = points[routes[i][0]-1]
        current[fx][fy] += 1
        now_point[i] =[fx, fy]
    
    for x in range(max_v+1):
        for y in range(max_v+1):
            if current[x][y] > 1:
                result += 1
    
    level = [1 for _ in range(n)]
        
    isFinish = False
    while not isFinish:
        k = 0
        for j in range(n):
            if level[j] == m:
                current[now_point[j][0]][now_point[j][1]] -= 1
                level[j] += 1
                continue                
            if level[j] > m:
                continue
            next_ = move(now_point[j], points[routes[j][level[j]]-1])
            now_point[j] = next_
            k += 1
            if points[routes[j][level[j]]-1] == now_point[j]:
                level[j] += 1

        for cx,cy in answer:
            if current[cx][cy] > 1:
                result += 1
        answer = set()
        # for a in current:
        #     print(a)
        # print("-----------------------------------------")
        if k == 0:
            isFinish = True
        

    return result
