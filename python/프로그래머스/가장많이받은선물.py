from collections import defaultdict

def solution(friends, gifts):
    length = len(friends)
    answer = [0 for _ in range(length)]
    give = defaultdict(list)
    get = defaultdict(list)
    
    for gift in gifts:
        a, b = gift.split(" ")
        give[a].append(b)
        get[b].append(a)
    
    for i in range(length):
        for j in range(i + 1, length):
            f, s = friends[i], friends[j]
            f_num = give[f].count(s)
            s_num = give[s].count(f)
            f_jisu = len(give[f]) - len(get[f])
            s_jisu = len(give[s]) - len(get[s])
            print(i, f_num, f_jisu)
            print(j, s_num, s_jisu)
            
            # 주고 받은 기록이 없는 경우
            if f_num == 0 and s_num == 0:
                if f_jisu == s_jisu:
                    continue
                if f_jisu > s_jisu:
                    answer[i] += 1
                else:
                    answer[j] += 1
            else:
                #같은 경우
                if f_num == s_num:
                    if f_jisu == s_jisu:
                        continue
                    if f_jisu > s_jisu:
                        answer[i] += 1
                    else:
                        answer[j] += 1            
                else:   
                #한 사람이 더 큰 경우
                    if f_num > s_num:
                        answer[i] += 1
                    else:
                        answer[j] += 1
    return max(answer)
