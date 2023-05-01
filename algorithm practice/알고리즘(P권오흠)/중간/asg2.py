# f = open('C:/Users/a0107/Desktop/알고리즘/Algo_study_bj_with_python/Alg, Sql/algorithm practice/kyj/알고리즘/input.txt', 'r')
f = open('input.txt', 'r')
lines = f.readlines()
f.close()

N = int(lines[0])
board = []
for i in range(1,N+1):
    board.append(list(map(int,lines[i].split())))
start = list(map(int,lines[N+1].split()))
arrive = list(map(int,lines[N+2].split()))

def check(y,x):
    if y==arrive[0] and x== arrive[1]:
        return True
    else:
        board[y][x] = -1
        flag = [0,0,0,0] #동 서 남 북
        for i in range(N):
            dx = [i,-i,0,0]
            dy = [0,0,i,-i]
            for j in range(4):
                nx = x + dx[j]
                ny = y + dy[j]
                if 0<=nx<N and 0<=ny<N:
                    if board[ny][nx] == 1:  flag[j] +=1
                    if flag[j]==1 and board[ny][nx]==0 and check(ny,nx):   return True
        return False
    
if check(start[0],start[1]):
    print("Yes")
else:
    print("No")