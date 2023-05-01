N = int(input())
board = [[0 for i in range(N)] for i in range(N)]
K = int(input())
for i in range(K):
    r,c = map(int,input().split())
    board[r-1][c-1] = 1
L = int(input())
turn = []
for i in range(L):
    input_ = input().split()
    turn.append((int(input_[0]),input_[1]))

def move(x):
    global head, tail
    board[head[0]][head[1]] = -1

    for i in range(x):
        print(board,head,tail)
        head = (head[0]-offset[d][0], head[1]-offset[d][1])
        if 0<=head[0]<N and 0<=head[1]<N and board[head[0]][head[1]] != -1:
            if board[head[0]][head[1]] != 1:
                board[tail[0]][tail[1]] = 0
                tail = tail[0]-offset[d][0], tail[1]-offset[d][1]
            board[head[0]][head[1]] == -1
        else:
            return i +1
    return x + 1

offset = [[-1, 0], [0, 1], [1, 0], [0, -1]] #상,우,하,좌
d, head, tail, count = 1,(0,0),(0,-1),0

for t in turn:
    cnt = move(t[0])
    count += cnt
    if cnt != t[0]: break

    if t[1] =="L":    d = (d-1)%4
    else:          d = (d+1)%4
    

print(count)