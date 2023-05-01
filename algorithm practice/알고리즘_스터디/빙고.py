def find_binggo(i,j):
    cnt_i, cnt_j, result = 0,0,0
    for k in range(5):
        if binggo[k][j] ==0:
            cnt_i += 1
        if binggo[i][k] ==0:
            cnt_j += 1

    if cnt_i == 5: 
        result += 1
    if cnt_j ==5 :
        result += 1

    if i==j:
        for k in range(5):
            if binggo[k][k] != 0:
                break
        else:
            result +=1
    if i+j == 4:
        for k in range(5):
            if binggo[k][4-k] != 0:
                break
        else:
            result +=1

    return result

binggo = []
for i in range(5):
    binggo.append(list(map(int, input().split())))

answer = []
for i in range(5):
    tmp = list(map(int, input().split()))
    for t in tmp:
        answer.append(t)


count,result = 0,0
for cnt,n in enumerate(answer):
    index = [(i,j) for i in range(5) for j in range(5) if binggo[i][j]==n]
    i,j = index[0][0],index[0][1]
    binggo[i][j] = 0

    count += find_binggo(i,j)
    if count>=3:
        result = cnt+1
        break

print(result)