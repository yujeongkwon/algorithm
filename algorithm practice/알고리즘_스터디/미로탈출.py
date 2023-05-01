from collections import deque

def bfs(i,j):
    global N,M

    q = deque()
    q.append([i,j])

    x = [1,-1,0,0,]
    y = [0,0,1,-1]

    while q:
        a,b = q.popleft()
        li[a][b] += 1
        for k in range(4):
            if 0 <= a+x[k] <N and 0<= b+y[k] <M:
                if li[a+x[k]][b+y[k]] == 1:
                    q.append([a+x[k],b+y[k]])
                    li[a+x[k]][b+y[k]] = li[a][b]
    return li[-1][-1] -1

def dfs(i,j):
    global N,M

    li[i][j] += 1
    x = [1,-1,0,0,]
    y = [0,0,1,-1]

    for k in range(4):
        if 0 <= i+x[k] <N and 0<= j+y[k] <M:
            if li[i+x[k]][j+y[k]] == 1:
                li[i+x[k]][j+y[k]] = li[i][j]
                dfs(i+x[k],j+y[k])
    return li[-1][-1] -1


N,M = map(int, input().split())
li = []

for i in range(N):
    li.append(list(map(int,input())))

answer = 0

print(dfs(0,0))