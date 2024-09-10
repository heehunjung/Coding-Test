# from collections import Counter

# # 좌표 리스트 예시 (x, y)
# coords = [(1, 2), (3, 4), (1, 2), (5, 6), (3, 4), (3, 4)]

# # 좌표의 빈도수 카운팅
# counter = Counter(coords)

# print(coords)

# print(counter)

# sorted_counter_by_coord = sorted(counter.items(), key=lambda y: y[0])
# print(sorted_counter_by_coord)


#왜 좌표만 정렬되었는가?
#counter.items()는 (좌표, 빈도수) 형식의 튜플을 반환합니다.
#key=lambda x: x[0]는 튜플의 첫 번째 요소인 **좌표 (x, y)**를 기준으로 정렬을 지시합니다.
#좌표 (x, y)는 튜플로 취급되기 때문에 좌표를 기준으로 먼저 정렬이 이루어지고, 빈도수는 고려되지 않습니다

from collections import Counter

points = [[1, 2], [3, 4], [1, 2], [5, 6], [3, 4], [3, 4]]


tuple_points = [tuple(point) for point in points]
counter = Counter(tuple_points)
list_counter = list(counter.items())
print(list_counter)

#Counter의 반환 값은 빈도수를 값으로 데이터를 키로 저장하는 변형된 딕셔러니의 형태
#Counter.items() -> 키-값 쌍을 튜플로 이루어진 dict_item 객체로 반환 -> list로 감싸줌