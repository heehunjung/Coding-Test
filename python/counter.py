from collections import Counter

# 좌표 리스트 예시 (x, y)
coords = [(1, 2), (3, 4), (1, 2), (5, 6), (3, 4), (3, 4)]

# 좌표의 빈도수 카운팅
counter = Counter(coords)

print(coords)

print(counter)

sorted_counter_by_coord = sorted(counter.items(), key=lambda y: y[0])
print(sorted_counter_by_coord)


#왜 좌표만 정렬되었는가?
#counter.items()는 (좌표, 빈도수) 형식의 튜플을 반환합니다.
#key=lambda x: x[0]는 튜플의 첫 번째 요소인 **좌표 (x, y)**를 기준으로 정렬을 지시합니다.
#좌표 (x, y)는 튜플로 취급되기 때문에 좌표를 기준으로 먼저 정렬이 이루어지고, 빈도수는 고려되지 않습니다