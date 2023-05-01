N = int(input())
li = list(map(int,input().split()))
K = int(input())

def combinations(lst,r):
    result = []
    if r == 0:
        return [[]]
    for i in range(len(lst)):
        for c in combinations(lst[i+1:], r-1):
            result.append([lst[i]]+c)
    return result

def find(li):
    min_ = 999999999999
    sum_ = 0
    for com in combinations(li,K):
        if min_ > abs(sum(com)):
            sum_=sum(com)
            min_ = abs(sum(com))
    return sum_

print(find(li))

# 6
# -1 -6 8 2 -3 2
# 3

# 2
# 8 -7
# 1

# 6
# 1 4 8 2 3 10
# 4

# 7
# -5 18 12 -24 43 51 -62
# 4

# 8
# 12 -24 33 49 -13 57 -66 77
# 5