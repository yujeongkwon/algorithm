def find_parent(x):
    if parent[x] !=x:
        parent[x] = find_parent(parent[x])
    return parent[x]

def union(a,b):
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def kruskal(E):
    result = 0
    for i in range(E):
        cost,a,b = edge[i]  
        Aparent = find_parent(a)
        Bparent = find_parent(b)
        if Aparent != Bparent:
            result += cost
            union(Aparent,Bparent)
    return result

V, E = map(int, input().split())
result = 0
parent = [ i for i in range(V+1)]
for i in range(1,V+1):
    parent[i] = i

edge = [[] for i in range(E)]
for e in range(E):
    a,b,cost = map(int,input().split())
    edge[e] = (cost,a,b)
edge.sort()

print(kruskal(E))