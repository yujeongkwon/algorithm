def solution(m, n, puddles):
    answer = 0
    map_ = [[0]for i in range(m) for j in range(n)]
    
    print(map_)
    for puddle in puddles:
        map_[puddle[1]-1][puddle[0]-1] = -1
        
    for i in range(n):
        for j in range(m):
            if map_[i][j] != -1:
                map_[i][j] += 1
            
    
    return map_[-1][-1]

print(solution(4,3,[[2, 2]]))