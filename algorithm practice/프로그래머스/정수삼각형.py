def solution(triangle):
    dp = triangle[0]
    for t in range(1,len(triangle)):
        temp = triangle[t]
        for cur in range(len(triangle[t])):
            max_ = 0
            for bef in range(len(dp)):
                if cur == bef or cur == bef + 1:
                    max_ = max(max_,dp[bef])
            temp[cur] = max_ + triangle[t][cur]
        dp = temp[:]
    return max(dp)

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))