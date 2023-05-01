# graph = [
#     [0,1,0,0,1,1,0,0,0,0],
#     [1,0,1,0,0,0,1,0,0,0],
#     [0,1,0,1,0,0,0,1,0,0],
#     [1,0,1,0,1,0,0,0,1,0],
#     [1,0,0,1,0,0,0,0,0,1],
#     [0,0,0,0,0,0,0,1,1,0],
#     [0,1,0,0,0,0,0,0,1,1],
#     [0,0,1,0,0,1,0,0,0,1],
#     [0,0,0,1,0,1,1,0,0,0],
#     [0,0,0,0,1,0,1,1,0,0]
# ]

graph = [
    [1,4,5],
    [0,1,6],
    [1,3,7],
    [2,4,8],
    [0,3,9],
    [0,7,8],
    [1,8,9],
    [2,5,9],
    [3,5,6],
    [4,6,7]
]

N = len(graph)
graph_color = [ -1 for i in range(N)]
colorN = 3

def give_color(level):
    if level == N:
        return True
    else:
        for c in range(colorN):
            if isVaildColor(level,c):
                graph_color[level] = c
                if give_color(level+1):
                    return True
        return False

def isVaildColor(level,c):
    for neigbor in graph[level]:
        if graph_color[neigbor] == c:
            return False
    return True

print(give_color(0))