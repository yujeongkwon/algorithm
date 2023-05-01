from collections import deque
MAX = 1000000
# -1 +1 *2 경우 
def bfs(subin,cnt):
    global K
    deq = deque()
    deq.append((subin,cnt))
    
    while deq: 
        subin,cnt = deq.popleft()
        notVisited[subin] = False
        if subin==K:    return cnt

        sulist = [subin+1,subin-1,subin*2]

        for su in sulist:
            if 0< su <MAX:
                if notVisited[su]:
                    deq.append((su,cnt+1))

N,K = map(int, input().split())
notVisited=[True]*MAX
print(bfs(N,0))

