from itertools import combinations, product
from bisect import bisect_left

def solution(dice):
    # 선택가능한 주사위 조합 구하기
    a_list = []
    b_list = []

    dice_idx = list(range(0,len(dice)))

    all_combinations = list(combinations(dice_idx, len(dice_idx)//2))

    for combination in all_combinations:
        a_list.append(list(combination))
        b_list.append(list(set(dice_idx).difference(combination)))

    # 주사위 결과 구하기
    win_cnt = []
    for i in range(len(a_list)):
        win = 0
        a_dice = []
        b_dice = []
        for j in a_list[i]:
            a_dice.append(dice[j])
        for j in b_list[i]:
            b_dice.append(dice[j])

        a_result = [sum(combination) for combination in product(*a_dice)]
        b_result = [sum(combination) for combination in product(*b_dice)]

        a_result.sort()
        b_result.sort()

        win = sum(bisect_left(b_result, num) for num in a_result)

        win_cnt.append(win)

    result = a_list[win_cnt.index(max(win_cnt))]    
    return [x +1 for x in result]
