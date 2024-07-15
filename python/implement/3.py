x,y = map(int,input().split())

moves = [(-2,-1),(-1,-2),(-2,1),(-1,2),(2,-1),(1,-2),(2,1),]

count = 0

for move in moves:
  nx = x + move[0]
  ny = y + move[1]
  if nx >= 1 and ny >= 1 and nx <= 8 and ny <= 8:
    count += 1
    
print(count)