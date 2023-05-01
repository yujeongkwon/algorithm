from collections import deque

def bfs(i,j):
    global N,M

    q = deque()
    q.append([i,j])
    li[i][j] = -1

    x = [1,-1,0,0,]
    y = [0,0,1,-1]

    while q:
        a,b = q.popleft()
        li[a][b] = -1
        for k in range(4):
            if 0 <= a+x[k] <N and 0<= b+y[k] <M:
                if li[a+x[k]][b+y[k]] == 0:
                    q.append([a+x[k],b+y[k]])
                    li[a+x[k]][b+y[k]] = -1
    return 1

def dfs(i,j):
    global N,M

    li[i][j] = -1
    
    x = [1,-1,0,0,]
    y = [0,0,1,-1]

    for k in range(4):
        if 0 <= i+x[k] <N and 0<= j+y[k] <M:
            if li[i+x[k]][j+y[k]] == 0:
                dfs(i+x[k],j+y[k])
    return 1


N = int(input())
li = []

for i in range(N):
    li.append(list(input()))

print(li)
# answer = 0
# for i in range(N):
#     for j in range(M):
#         if li[i][j] == 0:
#             answer += dfs(i,j)

# print(answer)