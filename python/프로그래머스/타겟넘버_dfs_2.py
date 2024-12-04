def solution(numbers, target):
    stack = []

    def dfs( index, current):
        
        if index < len(numbers):
            return dfs( index + 1 ,current + numbers[index]) + dfs(index + 1 ,current - numbers[index])
        else:
            if current == target:
                return 1
            else:
                return 0
    
    answer = dfs(0,0)
            
     
    return answer