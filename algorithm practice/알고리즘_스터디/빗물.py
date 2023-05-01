H,W = map(int,input().split())
land = list(map(int,input().split()))
water = 0

matrix = [[0 for i in range(W)] for i in range(H)]

for i,now in enumerate(land):
    for j in range(now):
        matrix[j][i] = 1

for i in range(H):
    lt, rt = -1, -1
    for j in range(W):
        if matrix[i][j] == 1 and lt ==-1 and rt == -1:
            lt = j
        if lt != -1 and lt<j and rt == -1 and matrix[i][j] == 1:
            rt = j
        if lt != -1 and rt != -1:
            water += rt-lt-1
            lt= rt
            rt=-1
        
print(water)