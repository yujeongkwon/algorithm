#백준
import sys
import heapq
input=sys.stdin.readline

T = int(input())

for i in range(T):
    k = int(input())
    minheap = []
    maxheap = []
    answer = []
    visited = [False] * k
    for n in range(k):
        op, num = input().split()
        num = int(num)
        if op == "I":
            heapq.heappush(minheap,(num,n))
            heapq.heappush(maxheap,(-num,n))
        else:
            if num == 1 :
                while maxheap and visited[maxheap[0][1]]:
                    heapq.heappop(maxheap)
                if maxheap: 
                    visited[maxheap[0][1]] = True
                    heapq.heappop(maxheap)
            elif num == -1 :
                while minheap and visited[minheap[0][1]]:
                    heapq.heappop(minheap)
                if minheap: 
                    visited[minheap[0][1]] = True
                    heapq.heappop(minheap)

    while minheap and visited[minheap[0][1]]:
        heapq.heappop(minheap)
    while maxheap and visited[maxheap[0][1]]:
        heapq.heappop(maxheap)

    if minheap: print(-heapq.heappop(maxheap)[0],heapq.heappop(minheap)[0] )
    else:        print("EMPTY")

# import heapq

# def solution(operations):
#     minheap = []
#     maxheap = []
#     answer = []
#     for oper in operations:
#         op, num = oper.split()
#         if op == "I":
#             heapq.heappush(minheap,num)
#             heapq.heappush(maxheap,num)
#         else:
#             if num == 1:
#                 heapq.heappop(maxheap)
#             else:
#                 heapq.heappop(minheap)
#     return [heapq.pop(maxheap),heapq.pop(minheap)] if minheap else [0,0]

# print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))