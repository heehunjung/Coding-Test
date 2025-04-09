def solution(diffs, times, limit):
    def cal(diff, time, time_prev ,lev):
        if lev >= diff:
            return time
        else:
            rec = diff - lev
            return (diff - lev) * (time + time_prev) + time

    start = 1
    end = max(diffs)
    length = len(diffs)
    finish = False

    while start <= end:
        temp = times[0]
        level = (start + end) // 2 
        for idx in range(1, length):
            temp += cal(diffs[idx], times[idx], times[idx-1], level)
        if temp <= limit:
            end = level - 1
        else:
            start = level + 1
    return start
# 이분 탐색하면 중간 값 비교 후 작을 경우 클 경우 범위를 나누자, 나눌 때 해당 중간 값을 제외해야함
