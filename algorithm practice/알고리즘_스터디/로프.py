
N = int(input())

rope = []
for i in range(N):
    rope.append(int(input()))

rope.sort()
max_ = 0
for i in range(N):
    if rope[i] * (N-i) >max_:
        max_ = rope[i] * (N-i)

print(max_)

#중량 = w/k

# 1 5 9
# 9 -> 9
#  5,9 -> 10
# 1,5,9 -> 3