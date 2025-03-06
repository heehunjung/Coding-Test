def solution(coin, cards):
    answer = 0
    n=len(cards)
    t = n + 1
    myDeck = cards[:n//3]
    giveCard = []
    tempDeck = []
    leftCards = cards[n//3:]
    
    def useCoin(mine, temp):
        for v in mine[:]:
            if t - v in temp:
                mine.remove(v)
                temp.remove(t - v)
                return True
        return False
    
    def useTwoCoin(temp):
        for card in temp[:]:
            if t - card in temp:
                temp.remove(card)
                temp.remove(t - card)
                return True
        return False
    
    # n+1을 만족하는 세트를 미리 만들어둠 (안전하게 myDeck[:]을 사용)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    for card in myDeck[:]:
        if t - card in myDeck:
            giveCard.append([card, t - card])
            myDeck.remove(card)
            myDeck.remove(t - card)
    
    myDeck = cards[:n//3]
    
    idx = 0
    isContinue = True
    while isContinue:
        if leftCards:
            f, s = leftCards[0], leftCards[1]
            tempDeck.append(f)
            tempDeck.append(s)
            leftCards.remove(f)
            leftCards.remove(s)        
        else:
            isContinue = False
        answer += 1
        
        # 기존의 카드에서 제거하는 경우 
        if giveCard:
            card1, card2 = giveCard.pop()
            
            myDeck.remove(card1)
            myDeck.remove(card2)
            continue
            
        if coin >= 1 and useCoin(myDeck, tempDeck):
            coin -= 1
            continue
            
        if coin >= 2 and useTwoCoin(tempDeck):
            coin -= 2
            continue
            
        break
    
    return answer
