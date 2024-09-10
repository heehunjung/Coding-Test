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

fruits = ['apple', 'banana', 'apple', 'orange', 'banana', 'apple']

fruits_counter = Counter(fruits)
tuple_points = [tuple(point) for point in points]
counter = Counter(tuple_points)
list_counter = list(counter.items())
print(list_counter)


nums = [1, 2, 2, 3, 3, 3, 4, 4, 4, 4]

# 숫자 리스트에서 각 숫자의 빈도 계산
num_counter = Counter(nums)

# 가장 많이 등장한 2개의 항목 찾기
most_common_nums = num_counter.most_common(2)
#most_common -> 빈도 순으로 내림차순 정렬 상위 n개만 반환 가능
#빈도수가 같으면 먼저 등장한 항목이 우선

print(most_common_nums)



counter1 = Counter({'apple': 3, 'banana': 1})
counter2 = Counter({'apple': 1, 'banana': 2, 'orange': 3})

# 두 Counter 합치기
combined_counter = counter1 + counter2

print(combined_counter)


#Counter의 반환 값은 빈도수를 값으로 데이터를 키로 저장하는 변형된 딕셔러니의 형태
#Counter.items() -> 키-값 쌍을 튜플로 이루어진 dict_item 객체로 반환 -> list로 감싸줌