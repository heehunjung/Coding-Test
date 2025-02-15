from collections import deque

def solution(players, m, k):
    answer = 0
    server_add_time = deque()
    current_server = 0
    add_server = deque()

    for i in range(len(players)):
        if i != 0:
            if server_add_time and i == server_add_time[0] + k:
                minus = add_server.popleft()
                current_server -= minus
                server_add_time.popleft()

        check = players[i] // m
        if check > current_server:
            server_add_time.append(i)
            
            plus = check - current_server
            current_server = check
            
            add_server.append(plus)
            answer += plus
            continue


    return answer
