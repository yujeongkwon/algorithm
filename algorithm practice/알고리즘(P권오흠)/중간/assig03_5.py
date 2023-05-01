f = open('C:/Users/a0107/Desktop/알고리즘/Algo_study_bj_with_python/Alg, Sql/algorithm practice/kyj/알고리즘/input.txt', 'r')
# f = open('input.txt', 'r')
lines = f.readlines()
f.close()

def navigation(x,y,way):
    if (x,y) == exit:
        return True
    else:
        visited[x][y][way] = 1
        go = [(-1, 0), (0, 1), (1, 0), (0, -1)] # u r d l
        right_way = (way-1)%4 # 우회전 방향 보정 식
        dx = [go[right_way][0],-go[way][0],go[way][0]]  #우회전, 직진, u턴
        dy = [go[right_way][1],-go[way][1],go[way][1]]
        dw = [right_way-2 if right_way>1 else right_way+2,way,way-2 if way>1 else way+2]
        for i in range(3):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N and not board[nx][ny]:
                if not visited[nx][ny][dw[i]] and navigation(nx,ny,dw[i]):
                    return True     
        return False

T = int(lines[0])
i =1
while(i<len(lines)):
    N = int(lines[i])
    visited = [[[0,0,0,0] for i in range(N)] for i in range(N)]
    board = []
    for j in range(i+1,N+i+1):
        board.append(list(map(int,lines[j].split())))
    exit = tuple(map(int,lines[N+i+1].split()))
    i += N + 2

    if navigation(0,0,0):    print("Yes")
    else:                    print("No")
