N = int(input())
ability = list(map(int,input().split()))
maxAbility,p1,p2,cnt= 0,0,N-1,0

while p1<=p2:
    maxAbility =max(maxAbility,(p2-p1-1)*min(ability[p1],ability[p2]))
    if ability[p1]<ability[p2]:
        p1+=1
    else:
        p2-=1
print(maxAbility)

