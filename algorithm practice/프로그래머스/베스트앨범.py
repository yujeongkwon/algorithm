def solution(genres, plays):
    answer = []
    
    dic = {}
    for i in range(len(genres)):
        g,p = genres[i], plays[i]
        if g in dic:
            sum_, li = dic[g]
            sum_ += p
            li.append((p,i))
            dic[g] = (sum_,li)
        else:
            dic[g] = (p,[(p,i)])
            
    dic = sorted(dic.items(), reverse = True)
    print(dic)
    for g, tu in dic:
        tu = tu[1]
        li = sorted(tu, key = lambda x: x[0],reverse=True)
        answer.append(li[0][1])
        answer.append(li[1][1])

    return answer

print(solution(["classic", "pop", "classic", "classic", "pop"],[500, 600, 150, 800, 2500]))