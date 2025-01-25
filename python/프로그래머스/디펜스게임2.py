import heapq

def solution(n, k, enemy):
    temp = []
    heap = []
    idx = 0
    while len(temp) != len(enemy):
        if enemy[idx] <= n:
            temp.append(enemy[idx])
            n -= enemy[idx]
            heapq.heappush(heap, -enemy[idx])
            idx += 1
        else:
            if k > 0:
                k -= 1
                if heap:
                    hp = heapq.heappop(heap)
                    if -hp > enemy[idx]: 
                        n -= hp
                    else:
                        temp.append(enemy[idx])
                        heapq.heappush(heap, hp)
                        idx += 1                   
                else:
                    temp.append(enemy[idx])
                    idx += 1     
            else:
                break
    return len(temp)
  # heap을 사용해서 현재까지의 최대값을 빠르게 구한다.
