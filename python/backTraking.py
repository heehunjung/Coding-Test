N,M = map(int,input().split())

answer = []

def back():
    
    if len(answer) == M:
        print("".join(map(str,answer)))
        return
    
    for i in range(1,N+1):
    
        if i not in answer:
            answer.append(i)
            back()
            #return 되서 돌아오면 
            # 3이 pop 되는거야 ㄷ
            answer.pop() # pop 하는 방식이 dfs와 유사 하지만 가지치기 한다는 점에서 다르다

back()