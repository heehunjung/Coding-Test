from itertools import product

def solution(word):
    words = []
    for i in range(1, 6):
        for c in product(['A', 'E', 'I', 'O', 'U'], repeat=i):
            words.append(''.join(list(c)))

    words.sort()
    return words.index(word) + 1

def test():
    for p in product('ab','12'):
        print(p)
    
    for p in product('ab',repeat=2):
        print(p)    