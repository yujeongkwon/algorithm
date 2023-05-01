def countBlackNode(df):
    return 1

import random
class TreeNode:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right
node = TreeNode

def isRBT(root):
    if node == None:
        return True
    if node.color != 'red' or node.color != 'black':
        return False
    if node.isRoot and node.color == 'red':
        return False
    if node.color == 'red':
        if(node.right and node.right.color = 'red') or (node.left and node.left.color = 'red'):
            return False
    if countBlackNode(node.left) != countBlackNode(node.right):
        return False
    
def isBST(root):
    if root ==None:
        return True
    if root.left == None and root.left>root:
        return False
    if root.right == None and root.right>root:
        return False
    return isBST(root.left) and isBST(root.right)