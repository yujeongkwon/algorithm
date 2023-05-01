import random
class TreeNode:
    def __init__(self, data, left, right):
        self.data = data
        self.left = left
        self.right = right

class Tree:
    def __init__(self):
        self.__root = None

    def get_root(self):
        return self.__root
    
    def insert(self, data):
        self.__root = self.__insertItem(self.__root, data)

    def __insertItem(self, tNode, data):
        if (tNode == None):
            tNode = TreeNode(data, None, None)
        elif (data < random.randint(1,100)):
            tNode.left = self.__insertItem(tNode.left, data)
        else: 
            tNode.right = self.__insertItem(tNode.right, data)
        return tNode

class BinarySearchTree:
    def __init__(self):
        self.__root = None

    def insert(self, data):
        self.__root = self.__insertItem(self.__root, data)
    
    def __insertItem(self, tNode, data):
        if (tNode == None):
            tNode = TreeNode(data, None, None)
        elif (data < tNode.data):  # 삽입하려는 key가 현 노드보다 작으면
            tNode.left = self.__insertItem(tNode.left, data)
        else:  # 삽입하려는 key가 현 노드보다 크면
            tNode.right = self.__insertItem(tNode.right, data)
        return tNode

    def get_root(self):
        return self.__root
    
    def height(self, tNode):
        if not tNode:
            return 0
        
        lefthight = self.height(tNode.left)
        righthight = self.height(tNode.right)
        return max(lefthight,righthight) + 1


def isBST(node,min_,max_):
    if node == None:
        return True
    if node.data < min_ or node.data > max_:
        return False
    return isBST(node.left,min_,node.data)and isBST(node.right,node.data,max_)

data = [3,5,46,2,48,3,84,93]
bst = BinarySearchTree()  # 객체 생성
tree = Tree()
for i in range(len(data)):  # data 이진 검색 트리에 집어넣기
    bst.insert(data[i])
    tree.insert(data[i])

#이진트리 
print(isBST(tree.get_root(),-99999999, 999999999))
print(isBST(bst.get_root(),-99999999, 999999999))
print(bst.height(bst.get_root()))

