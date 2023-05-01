def solution(routes):
    answer = [-30001]
    
    routes = sorted(routes, key = lambda x:x[-1])
    print(routes)
    flag = 0
    for i in range(0,len(routes)):
        if answer[-1] < routes[i][0]:
            answer.append(routes[i][1])
        
    return len(answer)-1


print(solution([[0,1], [0,1], [1,2]])) #1
print()
print()
print(solution([[0,1], [2,3], [4,5], [6,7]])) #4