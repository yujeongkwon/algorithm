def twoN_sum(n,k):
    answer,lt, rt = 0,0,n-1
    diff = 9999999999999999
    li.sort() 
    while lt < rt:
        sum_ = li[lt]+li[rt]
        if abs(k - sum_) < diff:
            answer = 1
            if k > sum_ :
                lt +=1
            else:
                rt -=1
            diff = abs(k - sum_)
            continue
        elif abs(k - sum_) == diff:
            answer += 1
            if k > sum_ :
                lt +=1
            else:
                rt -=1
            continue
        elif abs(k-sum_) > diff:
            if k > sum_ :
                lt +=1
            else:
                rt -=1
    return answer
# -7 -4 -3 -2 0 1 2 5 9 12

t = int(input())
answer = []
for i in range(t):
    n,k = map(int,input().split())
    li = list(map(int,input().split()))
    answer.append(twoN_sum(n,k))

for r in answer:
    print(r)