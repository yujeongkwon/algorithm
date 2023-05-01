# N = int(input())
# postorder = list(map(int,input().split()))
N = 11
postorder = [3,2, 5, 4, 1, 8, 10, 9, 11, 7, 6]
preorder = []

def find_subtree(postli):
    print(postli, preorder)
    if len(postli) == 0:
        return 
    root = postli.pop()
    preorder.append(root)
    left, right = [], []
    for val in postli:
        if val < root:
            left.append(val)
        else:
            right.append(val)
    find_subtree(left)
    find_subtree(right)
    

find_subtree(postorder)
print(preorder)
# 11
# 3 2 5 4 1 8 10 9 11 7 6

# 5
# 1 3 5 4 2

# 7
# 4 7 6 5 3 2 1

# 6
# 6 5 4 3 2 1

# 7
# 2 4 3 5 1 6 7