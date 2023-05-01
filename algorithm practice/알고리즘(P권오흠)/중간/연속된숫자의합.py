data = [31,-41,59,26,-53,58,97,-93,-23,84]
N = len(data)
def solve_linear():
    maxsofar, maxhere = 0, 0
    for i in range(N):
        maxhere = max(maxhere + data[i],  data[i])
        maxsofar = max(maxhere,maxsofar)
        print(maxhere,maxsofar,data[i])
    return maxsofar

print(solve_linear())