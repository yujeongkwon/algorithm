class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def constructBST(postorder):
    if not postorder:
        return None
    
    root = TreeNode(postorder[-1])
    left_postorder = []
    right_postorder = []
    for i in range(len(postorder)-1):
        if postorder[i] > root.val:
            left_postorder = postorder[:i]
            right_postorder = postorder[i:-1]
            break
    else:
        left_postorder=postorder[:-1]
    
    root.left = constructBST(left_postorder)
    root.right = constructBST(right_postorder)
    
    return root

def isBST(node,min_,max_):
    if node == None:
        return True
    if node.val < min_ or node.val > max_:
        return False
    return isBST(node.left,min_,node.val)and isBST(node.right,node.val,max_)


def treeHeight(root):
    if not root:
        return 0
    
    left_height = treeHeight(root.left)
    right_height = treeHeight(root.right)
    
    return max(left_height, right_height) + 1

if __name__ == '__main__':
    n = int(input())
    postorder = list(map(int, input().split()))
    
    root = constructBST(postorder)
    if isBST(root,-99999999,99999999):
        print(treeHeight(root))
    else:
        print(-1)


# 11
# 2 3 4 1 8 10 9 11 7 6

# 11
# 2 3 1 4 8 10 7 11 9 6

# 5
# 2 1 4 3 5

# 7
# 1 2 3 4 5 6 7

# 16
# 1 3 5 4 2 7 8 9 11 10 12 14 16 15 13 6