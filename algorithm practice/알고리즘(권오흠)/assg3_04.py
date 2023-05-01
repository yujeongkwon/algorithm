f = open('C:/Users/a0107/Desktop/알고리즘/Algo_study_bj_with_python/Alg, Sql/algorithm practice/kyj/알고리즘(권오흠)/input3_4.txt', 'r')
# f = open('input.txt', 'r')
lines = f.readlines()
f.close()

N = int(lines[0])
W = int(lines[1])
weights = [int(i) for i in lines[2].split()]
costs = [int(i) for i in lines[3].split()]
selected = [0 for i in range(N)]

def knapsack(w, n):
    if n == 0 or w == 0:
        return 0, [0] * n
    if weights[n-1] > w:
        result, items = knapsack(w, n-1)
        return result, items + [0]
    else:
        with_item_value, with_item_items = knapsack(w-weights[n-1], n-1)
        with_item_value += costs[n-1]

        without_item_value, without_item_items = knapsack(w, n-1)

        if with_item_value > without_item_value:
            return with_item_value, with_item_items + [1]
        else:
            return without_item_value, without_item_items + [0]

max_value, items = knapsack(W, N)

print(max_value)
print(items)
