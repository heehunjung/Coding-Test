import math

def solution(arrayA, arrayB):
    answer = 0
    a=arrayA[0]
    b=arrayB[0]

    for i in range(len(arrayA)):
        a=math.gcd(a,arrayA[i])
        b=math.gcd(b,arrayB[i])
    cheA=1
    cheB=1
    for i in range(len(arrayA)):
        if arrayA[i] % b==0:
            cheA=0
        if arrayB[i] % a==0:
            cheB=0

    if cheA==0 and cheB==0:
        return cheA
    else:
        return max(a,b)
