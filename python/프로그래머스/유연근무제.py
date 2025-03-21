def solution(schedules, timelogs, startday):
    answer = 0
    def checkTime(expect, current):
        ep_h, ep_m = expect // 100, expect % 100
        cu_h, cu_m = current // 100, current % 100
        if ep_m >= 60:
            ep_h += 1
            ep_m -= 60
            
        if ep_h == cu_h:
            if ep_m >= cu_m:
                return True
        if ep_h > cu_h:
            return True

        return False
    
    # 1000
    for i in range(len(timelogs)):
        expected = schedules[i]
        eventFlag = False
        isSafe = True
        # 7
        for j in range(len(timelogs[i])):
            today = j + startday
            if today >= 8:
                today %= 7
            if today == 6 or today == 7:
                eventFlag = False
            else:
                eventFlag = True
            
            if eventFlag:
                if not checkTime(expected + 10, timelogs[i][j]):
                    isSafe = False
                    break
        if isSafe:
            answer += 1
    return answer
