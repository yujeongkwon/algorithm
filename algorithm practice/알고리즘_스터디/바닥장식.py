from collections import deque

def bfs(i,j):
    global N,M

    q = deque()
    q.append([i,j])

    while q:
        a,b = q.popleft()
        notVisited[a][b] = False
        
        if li[a][b] == '-':
            y = [1,-1]
            x  = [0,0]
        else:
            y = [0,0]
            x  = [1,-1]
        
        for k in range(2):
            if 0 <= a+x[k] <N and 0<= b+y[k] <M:
                if notVisited[a+x[k]][b+y[k]] and li[a+x[k]][b+y[k]] == li[a][b]:
                    q.append([a+x[k],b+y[k]])
                    notVisited[a+x[k]][b+y[k]] = False
    return 1


N,M = map(int, input().split())
li = []

for i in range(N):
    li.append(list(input()))

notVisited = [[True]*M for i in range(N)]
answer = 0

for i in range(N):
    for j in range(M):
        if notVisited[i][j]:
            answer += bfs(i,j)
            
print(answer)