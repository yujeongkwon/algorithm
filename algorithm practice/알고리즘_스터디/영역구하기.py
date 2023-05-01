from collections import deque

def bfs(i,j):
    cnt = 0
    q = deque()
    q.append((i,j))
    rectangle[i][j] = 0
    x = [1,-1,0,0]  
    y = [0,0,-1,1]
    
    while q:
        a,b = q.popleft()   
        for k in range(4):
            nx = a+x[k]
            ny = b+y[k]
            if 0> nx or M<= nx or 0>ny or N <=ny:
                continue
            if  rectangle[nx][ny] == 1:
                q.append((nx,ny))
                rectangle[nx][ny] = 0
                cnt +=1
    return cnt

M,N,K = map(int,input().split())

rectangle = [ [1 for i in range(N)] for  i in range(M)]

put = []
for i in range(K):
    put.append(list(map(int, input().split())))

for lx,ly,rx,ry in put:
    for i in range(ly,ry):
        for j in range(lx,rx):
            rectangle[i][j] = 0

answer = []
for i in range(M):
    for j in range(N):
        if rectangle[i][j] == 1 :

            answer.append(bfs(i,j)+1)

answer.sort()
print(len(answer))
print(' '.join(str(_) for _ in answer))
