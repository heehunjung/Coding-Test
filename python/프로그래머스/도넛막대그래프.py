donut = 0
stick = 0
circle = 0
def solution(edges):
    answer = []
    global donut, stick, circle
    # 전역 변수 초기화
    donut = 0
    stick = 0
    circle = 0
    
    max_value = max(max(edge) for edge in edges)
    li = [[] for _ in range(max_value+1)]
    
    for edge in edges:
        li[edge[0]].append(edge[1])    
    
    start = startPoint(li)
    answer.append(start)
    
    for startNode in li[start]:
        checkDonut(li,startNode)
    
    answer.append(donut)
    answer.append(stick)
    answer.append(circle)
    return answer

def startPoint(li):
    answer = -1
    visited = [0 for _ in range(len(li))]
    for connects in li[1:]:
        for node in connects:
            visited[node] = 1
    
    index = 1
    for i in visited[1:]:
        if  i == 0:
            if len(li[index]) > 1:
                answer = index
        index += 1
    return answer
            
        
def checkDonut(li,startNode):
    global donut
    global stick
    global circle
    
    nextNode = startNode
    
    while True:
        nextNodes = li[nextNode]
        
        if len(nextNodes) > 1:
            circle += 1
            return
        
        if len(nextNodes) == 0:
            stick +=1
            return
        
        nextNode = nextNodes[0]
        
        if startNode == nextNode:
            donut +=1 
            return
        
            
    
        
        
        
    
    