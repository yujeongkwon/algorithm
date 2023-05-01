f = open('C:/Users/a0107/Desktop/알고리즘/Algo_study_bj_with_python/Alg, Sql/algorithm practice/kyj/알고리즘(권오흠)/input3_4.txt', 'r')
# f = open('input.txt', 'r')
lines = f.readlines()
f.close()

N = int(lines[0])
W = int(lines[1])
weights = [i for i in list(map(int,lines[2].split()))]
costs = [i for i in list(map(int,lines[3].split()))]

def knapsack(w, n):
    if n==0 or w ==0:
        return 0
    else:
        without_c = knapsack(w,n-1)
        with_c = knapsack(w-weights[n-1],n-1) + costs[n-1] if weights[n-1]<=w else 0
        return max(with_c,without_c)    
        
max_value= knapsack(W,N)

print(max_value)
