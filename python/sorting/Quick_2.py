array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array):
  #리스트가 하나 이하의 원소만을 담고 있으면 종료
  if len(array) <= 1:
    return array
  pivot = array[0]  #피벗은 첫번째 원소
  tail = array[1:]  #피벗을 제외한 리스트
  #분할된 왼쪽 부분
  left_side = [x for x in tail if x <= pivot]
  rigth_side = [x for x in tail if x > pivot]

  return quick_sort(left_side) + [pivot] + quick_sort(rigth_side)


print(quick_sort(array))
