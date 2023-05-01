# 와나 힙큐로 하면 인덱스 배열이 달라진다는 것ㅇ르 까먹음
#캐서 time을 힙큐로 푸시해서 (배열로 어펜드한 것이 아닌) 틀린 거였음 계쏙 ㅡㅡ
import heapq

N = int(input())
time = []

for i in range(N):
    s,t = map(int,input().split())
    time.append((s,t))
time.sort()

room = []
heapq.heappush(room,time[0][1])
for i in range(1,N):
    heapq.heappush(room,time[i][1])
    if room[0] <= time[i][0]:
        heapq.heappop(room)

print(len(room))

# 8
# 1 8
# 9 16
# 3 7
# 8 10
# 10 14
# 5 6
# 6 11
# 11 12