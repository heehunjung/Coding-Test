from collections import deque
def solution(begin, target, words):
    answer = 0
    
    if target not in words:
        return 0
    length = len(words)
    visited = [False for _ in range(length)]
    newTree = deque()
    newTree.append([begin])
    count = 0
    
    while newTree:
        current = newTree.popleft()
        if target in current:
            return count
        list = []
        isContinue = False
        for now in current: 
            for i in range(length):
                if visited[i] == False and checkWords(now,words[i]):
                    visited[i] = True
                    list.append(words[i])
                    isContinue = True
        newTree.append(list)

        count += 1

        if isContinue == False:
            return 0
                    

        
        
    return answer

def checkWords(begin,word):
    length = len(begin)
    result = 0
    
    for i in range(length):
        if begin[i] == word[i]:
            result += 1
    
    if result == length - 1:
        return True
    
    return False
    