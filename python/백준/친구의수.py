from collections import deque

def countRelation(meeting,me):
    relationNo = 0
    for people in meeting:
        if people != 0 and friends[me][people] == False:
            friends[me][people] = True
            friends[people][me] = True
            relationNo += 1

        for connectPeople in meetings[people]:
            if me != connectPeople and connectPeople != 0 and friends[me][connectPeople] == False:
                friends[me][connectPeople] = True
                friends[connectPeople][me] = True
                meetings[me].append(connectPeople)
                meetings[connectPeople].append(me)
                print(connectPeople)
                relationNo += 1
    return relationNo
        
N,M = map(int,input().split())

people = [ a for a in range(1,N+1)] #전체 사람
meetings = [ {}for _ in range(N+1)] #사람 별 대화하는 인원


result = 0 
for i in range(1,M+1):
    resultK = 0
    f,s = map(int,input().split())
    len(meetings[f])
    meetings[f].add(s)
    meetings[s].add(f)
    

    result += i * resultK
    
div = pow(10,9) + 7
print(result)
print(result % div)


