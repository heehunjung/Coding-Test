from collections import Counter

def solution(weights):
    answer = 0
    ratios = [(1, 1), (1, 2), (2, 3), (3, 4)]
    
    # 몸무게 빈도수 계산
    weight_count = Counter(weights)
    
    # 같은 몸무게 조합 추가 (nC2)
    for w, count in weight_count.items():
        if count > 1:
            answer += count * (count - 1) // 2
    
    # 비율을 만족하는 경우 찾기
    for w in weight_count:
        for r1, r2 in ratios:
            target_weight = (w * r2) // r1  # 비율 적용
            if w * r2 % r1 == 0 and target_weight in weight_count and target_weight != w:
                answer += weight_count[w] * weight_count[target_weight]
    
    return answer
