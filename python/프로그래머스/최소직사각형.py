def solution(sizes):
    # 각 명함을 회전시켜 더 작은 값을 세로(h), 더 큰 값을 가로(w)로 정렬
    rotated_sizes = [(min(w, h), max(w, h)) for w, h in sizes]
    
    # 각각의 최댓값 구하기
    max_width = max(w for _, w in rotated_sizes)
    max_height = max(h for h, _ in rotated_sizes)
    
    # 필요한 지갑 크기 반환
    return max_width * max_height