array = [7, 4, 9, 0, 3]
#삽입 정렬
for i in range(1, len(array)):
  #삽입하면서 주위 인덱스들도 바꿔줘야 해서
  for j in range(i, 0, -1):
    if array[j] < array[j - 1]:
      array[j], array[j - 1] = array[j - 1], array[j]
    else:
      break
  print(array)

#뒤에서 찾으면 자기 자리에 바로 들어가면 됨 - 오름차순 기준
