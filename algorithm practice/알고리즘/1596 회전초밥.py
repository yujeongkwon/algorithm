from collections import defaultdict
#set을 쓰자니 순서가 거슬려서 힘들었는데 셋항목정리에 좋은 자료구조
#키가 있는지 확인 굳이x, 유사딕셔너리
N, d, k, c = map(int,input().split())
sushi = []
for i  in range(N):
    sushi.append(int(input()))

eat, ans, left,right = defaultdict(int), 0,-k,0
eat[c] += 1
for i in range(N-k,N):
    eat[sushi[i]] += 1

while right<N:
    ans = max(ans,len(eat))
    eat[sushi[left]] -= 1
    if eat[sushi[left]] ==0: del eat[sushi[left]]
    eat[sushi[right]] += 1
    left+=1
    right+=1

print(ans)