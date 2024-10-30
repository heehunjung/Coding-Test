def solution(genres, plays):
    answer = []
    
    # 장르별로 재생 횟수를 저장할 딕셔너리 생성
    genre_dict = {}
    length = len(plays)
    
    # 장르별 재생 횟수 리스트 생성
    for i in range(length):
        genre_dict.setdefault(genres[i], []).append([plays[i], i])
        
    # 각 장르별 재생 횟수를 합산하여 내림차순 정렬
    sorted_genres = sorted(genre_dict.items(), key=lambda item: sum(play[0] for play in item[1]), reverse=True)
    
    # 장르별로 상위 두 곡을 answer에 추가
    for genre, songs in sorted_genres:
        # 각 장르에서 곡을 재생 횟수로 내림차순, 인덱스 오름차순 정렬
        sorted_songs = sorted(songs, key=lambda x: (-x[0], x[1]))
        # 상위 2개의 곡의 인덱스를 answer에 추가
        for i in range(min(2, len(sorted_songs))):
            answer.append(sorted_songs[i][1])
    
    return answer
