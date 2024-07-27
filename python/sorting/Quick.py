array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array, start, end):
  if start >= end:  # 원소가 1개인 경우 종료
    return
  pivot = start  #피벗은 해당 분할의 첫번째 원소임
  left = start + 1
  right = end
  while (left <= right):
    #피벗보다 큰 데이터를 찾을 때까지 반복
    while (left <= end and array[left] <= array[pivot]):
      left += 1
    #피벗보다 작은 데이터를 찾을 때까지 반복
    while (right > start and array[right] >= array[pivot]):
      right -= 1
    if (left > right):  #엇갈린 경우 작은 데이터와 피봇과 교체
      array[right], array[pivot] = array[pivot], array[right]
    else:  #엇갈리지 않은 경우
      array[right], array[left] = array[left].array[right]
  #분할 이우 왼쪽 부분과 오른쪽 부분 나눠서 진행
  quick_sort(array, start, right - 1)
  quick_sort(array, right + 1, end)


quick_sort(array, 0, len(array) - 1)
print(array)
