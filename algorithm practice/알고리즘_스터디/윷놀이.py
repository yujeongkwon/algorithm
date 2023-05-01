#도: 0-1/1-3 #개: 2,2 #걸 0-3/1-1 #윷: 0-4 #모 1-4
def yut(back):
    if back == 3:
        return 'A'
    if back == 2:
        return 'B'
    if back == 1:
        return 'C'
    if back == 0:
        return 'D'
    return 'E'

for i in range(3):
    li = list(map(int, input().split()))
    print(yut(sum(li)))

