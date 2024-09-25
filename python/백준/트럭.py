# from collections import deque

# n,w,l = map(int,input().split())
# a = list(map(int,input().split()))

# outside = deque(a)
# inside = deque()
# total = 0
# tiktak = 0 # 단위 시간을 저장
# #반복문 동작이 단위 시간 마다 반복 이라고 생각
# while outside:
#     tiktak += 1 # 시간 업데이트
#     nextBus = outside.popleft()
    
#     # 처음 버스 출발
#     if len(inside) == 0:
#         total += nextBus
#         inside.append([nextBus,1]) #버스무게, 위치
#         continue
    
#     if total + nextBus <= l: # 최대 하중 이하인 경우
                
#         if len(inside) + 1 <= w:
#             total += nextBus
            
#             outbus = 0
#             for info in inside:
#                 info[1] += 1 # 위치 업데이트
#                 if info[1] > w:
#                     outbus += 1
            
#             for _ in range(outbus):
#                 temp = inside.popleft()
#                 total -= temp[0] 
            
#             inside.append([nextBus,1])
#         else:
#             outbus = 0
#             for info in inside:
#                 info[1] += 1 # 위치 업데이트
#                 if info[1] > w:
#                     outbus += 1
            
#             for _ in range(outbus):
#                 temp = inside.popleft()
#                 total -= temp[0] 
            
#             if len(inside) + 1 <= w:
#                 total += nextBus
#                 inside.append([nextBus,1])
#             else:
#                 outside.appendleft(nextBus)
#     else:
        
#         outbus = 0
#         for info in inside:
#             info[1] += 1 # 위치 업데이트
#             if info[1] > w:
#                 outbus += 1
            
#         for _ in range(outbus):
#             temp = inside.popleft()
#             total -= temp[0]
            
#         outside.appendleft(nextBus)

#         if nextBus + total <= l:
#             for info in inside:
#                 info[1] -= 1 # 위치 업데이트
#             tiktak -= 1
            
# while inside:
#     outbus = 0
#     for info in inside:
#         info[1] += 1 # 위치 업데이트
#         if info[1] > w:
#             outbus += 1

#     for _ in range(outbus):
#         inside.popleft()

#     tiktak += 1 # 시간 업데이트

# print(tiktak)
        
    

    
# # 고찰 
# # 구현문제인건 맞았음 
# # 케이스를 좀 빡빡하게 체크했어야됨 접근은 좋았음 , 필요없는 부분도 넘 많앙


# 일반적인 정답
n,w,L = map(int,input().split())

truck = list(map,input().split())

bridge = [0] * w
time = 0

while bridge:
    time += 1
    bridge.pop(0)
    
    if truck:
        if sum(bridge) + truck[0] <= L:
            bridge.append(truck.pop(0))
        else:
            bridge.append(0) # 원복

print(time)