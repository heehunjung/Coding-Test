def solution(clothes):
    dict_cloth = {}
    
    # 의상 카테고리별로 아이템을 분류하여 딕셔너리에 저장
    for cloth in clothes:
        dict_cloth.setdefault(cloth[1], []).append(cloth[0])
        
    # 경우의 수 계산을 위한 초기값
    temp_result = 1
    
    # 모든 카테고리별 아이템 수로 조합 계산
    for values in dict_cloth.values(): # value 리스트를 반환
        temp_result *= (len(values) + 1)  # 각 카테고리의 아이템 수 + 1 (해당 카테고리 선택 안 하는 경우)
    
    # 아무것도 선택하지 않는 경우 제외
    answer = temp_result - 1
    
    return answer
