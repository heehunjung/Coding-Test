def solution(numbers, target):
    answer = 0
    stack = []
    for number in numbers:
        stack.append([number,number * -1])
    
    def dfs(stack, numbers,target ,index, current):
        nonlocal answer
        
        if index < len(stack):
            for number in stack[index]:
                dfs(stack,numbers,target ,index + 1 ,current + number)
        else:
            if current == target:
                answer += 1
    
    dfs(stack,numbers,target,0,0)
            
     
    return answer