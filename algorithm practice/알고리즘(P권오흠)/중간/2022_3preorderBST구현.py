class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def constructBST(preorder):
    if not preorder:
        return None
    
    root = TreeNode(preorder[0])
    left_preorder = []
    right_preorder = []
    for val in preorder[1:]:
        if val < root.val:
            left_preorder.append(val)
        else:
            right_preorder.append(val)
    
    root.left = constructBST(left_preorder)
    root.right = constructBST(right_preorder)
    
    return root

class BinarySearchTree:
    def __init__(self,node):
        self.__root = node

    def print(self):  # inorder 순회
        return self.__print(self.__root)

    def __print(self, tNode: TreeNode):
        if (tNode == None):
            return None
        self.__print(tNode.left)
        print(tNode.val)
        self.__print(tNode.right)


def treeHeight(root):
    if not root:
        return 0
    
    left_height = treeHeight(root.left)
    right_height = treeHeight(root.right)
    
    return max(left_height, right_height) + 1

if __name__ == '__main__':
    n = int(input())
    preorder = list(map(int, input().split()))
    
    root = constructBST(preorder)
    height = treeHeight(root)
    
    bst = BinarySearchTree(root)
    print(height)   

# 11
# 6 1 4 2 3 5 7 11 9 8 10