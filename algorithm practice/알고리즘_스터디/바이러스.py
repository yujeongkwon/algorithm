from collections import deque

def bfs(V):
    deq = deque([V])
    visited[V] = 1
    cnt= 0
    while deq: # 큐가 빌때 까지
        #맨 처음 인자 빼고, 출력
        V = deq.popleft()
        #방문하지 않은 인자 큐에 추가
        for i in li[V]:
            if not visited[i]:
                cnt +=1
                deq.append(i)
                visited[i] = 1
                
    return cnt

N = int(input())
M = int(input())

li = [[]for i in range(N+1)]

for i in range(M):
    num_1, num_2 = map(int, input().split())
    li[num_1].append(num_2)
    li[num_2].append(num_1)

visited = [0] * (N + 1)

#리스트 정렬
for i in range(1,N+1):
    li[i].sort()

print(bfs(1))