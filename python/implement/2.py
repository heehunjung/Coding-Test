n = int(input("시간을 입력하세요: "))  # 정수로 변환

sec = 0
min = 0
hour = 0

while True:
    sec += 1
    if sec == 60:
        sec = 0
        min += 1
    if min == 60:
        min = 0
        hour += 1

    # 10보다 작은 수는 두 번째 자리수가 없으므로 첫 번째 자리수만 검사
    if (str(sec).find('3') != -1 or 
        str(min).find('3') != -1 or 
        str(hour).find('3') != -1):
        print(hour, "시", min, "분", sec, "초")

    if hour == n + 1:  # 비교를 위해 int(n) + 1로 변경
        break
