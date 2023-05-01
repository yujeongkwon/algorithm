#stack 
stack = []
N = int(input())
sum_ = 0
for i in range(N):
    current = int(input())
    if current ==0:
        sum_-=stack.pop()
    else:
        stack.append(current)
        sum_ += current

print(sum_)