n, k = map(int, input().split())
seq = list(map(int, input().split()))

left = 0
max_length = 0
count = [0] * (max(seq) + 1)

for right in range(n):
    count[seq[right]] += 1
    
    while count[seq[right]] > k:
        count[seq[left]] -= 1
        left += 1
        
    max_length = max(max_length, right - left + 1)

print(max_length)