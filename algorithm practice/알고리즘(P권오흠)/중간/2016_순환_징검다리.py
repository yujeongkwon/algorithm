f = open('C:\\Users\\a0107\\Desktop\\학교공부\\3학년\\알고리즘(권오흠)\\중간예제 코드\\input.txt', 'r')
# f = open('input.txt', 'r')
lines = f.readlines()
f.close()

N, D = map(int, lines[0].split())
rocks = []
for i in range(1, N+1):
    rocks.append(list(map(int, lines[i].split())))
start, end = map(int, lines[-1].split())
visited = [0 for i in range(N)]
x, y, w, h = 0, 1, 2, 3

N, D = map(int, lines[0].split())
rocks = []
for i in range(1, N+1):
    rocks.append(list(map(int, lines[i].split())))
start, end = map(int, lines[-1].split())
visited = [0 for i in range(N)]
x, y, w, h = 0, 1, 2, 3


def navigation(cur, cnt):
    if cur == end:
        return cnt
    else:
        visited[cur] = 1
        for i in range(len(rocks)):
            if visited[i] != 1:
                dx = [-D, rocks[cur][w]+D, 0, 0]
                dy = [0, 0, -D,rocks[cur][h]+D]
                for j in range(4):
                    nx = rocks[cur][x] + dx[j]
                    ny = rocks[cur][y] + dy[j]
                    if rocks[i][x] <= nx <= rocks[i][x] + rocks[i][w] and rocks[i][y] <= ny <= rocks[i][y] + rocks[i][h]:
                        result = navigation(i, cnt + 1)
                        if result != False:
                            return result
        return False

result = navigation(start, 0)
if result != False:
    print(result)
else:
    print("No path")