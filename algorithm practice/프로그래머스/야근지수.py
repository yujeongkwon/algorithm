def solution(n, works):
    answer = 0
    tmp = []
    sum_ = sum(works)
    if sum(works) <= n: return 0
    
    re = sum_ - n
    q, r = divmod(re,len(works))
    
    mod = len(works) - r

    #몫만큼 일량 추가
    for i in range(mod):
        tmp.append(q)
    #나머지만큼 추가 
    for i in range(r):
        tmp.append(q+1)
    
    plus = sumtmp - sum_
    q,r = divmod(plus,len(works))
    mod = len(works) - r
    for i in range(mod):
        tmp[i] += q
    for i in range(mod+1,r+1):
        tmp[i] += 1
        
    for i in tmp:
        answer += i**2
            
    
    return answer

print(solution(4,[4, 3, 3]))