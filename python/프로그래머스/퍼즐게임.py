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
        for idx in range(1, length):
            temp += cal(diffs[idx], times[idx], times[idx-1], start)
        if temp <= limit:
            end = start-1 
            start = start // 2 + 1 
        else:
            start = (start + end) // 2 + 1
    return start
  
