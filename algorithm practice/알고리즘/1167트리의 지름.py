from collections import deque

V = int(input())
line = [[] for i in range(V+1)]

for i in range(1,V+1):
    li = list(map(int,input().split()))
    for j in range(1,len(li),2):
        if li[j] != -1:
            line[li[0]].append([li[j],li[j+1]])

def bfs(v):
    visited = [-1 for i in range(V+1)]
    visited[v] = 0
    q = deque()
    q.append(v)
    maxD,maxV = 0,0

    while q:
        cur = q.pop()
        for e,w in line[cur]:
            if visited[e] == -1:
                visited[e] = visited[cur]+w
                q.append(e)
                if maxD<visited[e]:
                    maxD,maxV = visited[e],e
    return maxD,maxV

def dfs(v,maxD):
    for e,w in line[v]:
        if visited[e] == -1 :
            visited[e] = maxD + w
            dfs(e,visited[e])

visited = [-1 for i in range(V+1)]
visited[1] = 0
dfs(1,0)
maxV = visited.index(max(visited))
visited = [-1 for i in range(V+1)]
visited[maxV] = 0
dfs(maxV,0)
print(max(visited))

# td,maxV = bfs(1)
# print(bfs(maxV)[0])

