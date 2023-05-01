N = int(input())
li = list(map(int,input().split()))

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
    for com in combinations(li,N//2):
        min_=min(min_,abs(sum(li) - 2*sum(com)))
    return min_

print(find(li))