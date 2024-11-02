# from collections import deque
# def solution(begin, target, words):
#     answer = 0
    
#     if target not in words:
#         return 0
#     length = len(words)
#     visited = [False for _ in range(length)]
#     newTree = deque()
#     newTree.append([begin])
#     count = 0
    
#     while newTree:
#         current = newTree.popleft()
#         if target in current:
#             return count
#         list = []
#         isContinue = False
#         for now in current: 
#             for i in range(length):
#                 if visited[i] == False and checkWords(now,words[i]):
#                     visited[i] = True
#                     list.append(words[i])
#                     isContinue = True
#         newTree.append(list)

#         count += 1

#         if isContinue == False:
#             return 0
                    

        
        
#     return answer

# def checkWords(begin,word):
#     length = len(begin)
#     result = 0
    
#     for i in range(length):
#         if begin[i] == word[i]:
#             result += 1
    
#     if result == length - 1:
#         return True
    
#     return False
    
    
from collections import deque

def solution(begin, target, words):
    # target이 words에 없으면 변환할 수 없으므로 0 반환
    if target not in words:
        return 0
    
    # BFS를 위한 큐 초기화 (단어와 현재까지의 변환 횟수를 저장)
    queue = deque([(begin, 0)])
    visited = set()  # 방문한 단어를 저장하여 중복 탐색 방지

    while queue:
        current_word, count = queue.popleft()
        
        # 목표 단어를 찾으면 현재 변환 횟수 반환
        if current_word == target:
            return count
        
        # 변환 가능한 단어를 찾아서 큐에 추가
        for word in words:
            if word not in visited and checkWords(current_word, word):
                visited.add(word)
                queue.append((word, count + 1))
    
    return 0  # 변환할 수 없는 경우 0 반환

def checkWords(begin, word):
    # 두 단어가 하나의 문자만 다르면 True 반환
    diff_count = sum(1 for a, b in zip(begin, word) if a != b)
    return diff_count == 1
