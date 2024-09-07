N,Q = map(int,input().split())

usados = [[-1 for _ in range(N+1)] for _ in range(N+1)]  #처리 되지 않은 곳은 -1

for i in range(N-1):
    p,q,r = list(map(int,input().split()))
    
    # 작은 인덱스가 y축으로 
    if p > q:
        temp = p
        p = q
        q = temp
    if usados[p][q] == -1:
        usados[p][q] = r
    else:
        usados[p][q] = min(r,usados[p][q])

    #자기보다 작은
    for k in range(1,p):
        # print(k,",",p,":",usados[k][p])
        if usados[k][p] != -1:
            usados[k][q] = min(usados[k][p],usados[p][q])
    # #자기와 같은
    # for k in range(p+1,N+1):
    #     if usados[p][k] != -1:
    #         if usados[k][q] == -1:
    #             usados[k][q] = min(usados[p][q],usados[p][k])
    #         else:
    #             usados[k][q] = min(usados[p][q],usados[k][q])
                
    #자기보다 큰
    for k in range(q+1,N+1):
        if usados[q][k] != -1:
            if usados[p][k] == -1:
                usados[p][k] = min(usados[q][k],usados[p][q])
            else:
                usados[p][k] = min(usados[q][k],usados[p][k])

for usado in usados:
    print(usado)

print("------------------\n")


results = [0 for _ in range(Q)]
for i in range(Q):
    k,v = map(int,input().split())
    for index in range(1,v):
        if usados[index][v] >= k and usados[index][v] != -1 :
            # print(index,",",v)
            results[i] += 1
    for index in range(v+1,N+1):
        if usados[v][index] >= k and usados[v][index] != -1:
            # print(v,",",index)
            results[i] += 1

for result in results:
    print(result)
