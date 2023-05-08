N = int(input())
space = list(map(int,input().split()))
maxHoney = 0

#꿀통이 왼쪽 끝, bee1은 인덱스 N-2부터 -1씩
bee1Sum,bee2Sum = sum(space[:-2]),sum(space[:-2])
maxHoney = max(maxHoney,bee1Sum+bee2Sum)
for bee1 in range(N-3,0,-1):
    bee1Sum -= space[bee1]
    bee2Sum += space[bee1+1]-space[bee1]
    maxHoney = max(maxHoney,bee1Sum+bee2Sum)

#꿀통이 오른쪽 끝, bee2은 인덱스 1부터 +1씩
bee1Sum,bee2Sum = sum(space[2:]),sum(space[2:])
maxHoney = max(maxHoney,bee1Sum+bee2Sum)
for bee2 in range(2,N-1):
    bee2Sum -= space[bee2]
    bee1Sum += space[bee2-1]-space[bee2]
    maxHoney = max(maxHoney,bee1Sum+bee2Sum)

# 꿀통이 중간일 때, 꿀통은 인덱스 1부터 시작
bee1Sum,bee2Sum = space[1],sum(space[1:-1])
maxHoney = max(maxHoney,bee1Sum+bee2Sum)
for honeyBucket in range(2,N-1):
    bee1Sum += space[honeyBucket]
    bee2Sum -= space[honeyBucket-1]
    maxHoney = max(maxHoney,bee1Sum+bee2Sum)

print(maxHoney)