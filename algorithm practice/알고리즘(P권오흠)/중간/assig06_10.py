import csv
my_file_root = "C:/Users/a0107/Desktop/알고리즘/Algo_study_bj_with_python/Alg, Sql/algorithm practice/kyj/알고리즘(권오흠)/"

class TreeNode:
    def __init__(self, newName, newInfo, left, right):
        self.name = newName
        self.info = newInfo
        self.left = left
        self.right = right

class BinarySearchTree:
    def __init__(self):
        self.__root = None

    def insert(self, newName, newInfo):
        self.__root = self.__insertItem(self.__root, newName, newInfo)

    def __insertItem(self, tNode: TreeNode, newName, newInfo) -> TreeNode:
        if (tNode == None):
            tNode = TreeNode(newName, newInfo, None, None)
        elif (newName < tNode.name):  # 삽입하려는 key가 현 노드보다 작으면
            tNode.left = self.__insertItem(tNode.left, newName, newInfo)
        else:  # 삽입하려는 key가 현 노드보다 크면
            tNode.right = self.__insertItem(tNode.right, newName, newInfo)
        return tNode

    def __form(self, tNode: TreeNode):
        print(tNode.name)
        print(' '+property[0]+': '+tNode.info[0])
        print(' '+property[1]+': '+tNode.info[1])
        print(' '+property[2]+': '+tNode.info[2])
        print(' '+property[3]+': '+tNode.info[3])
        print(' '+property[4]+': '+tNode.info[4])

    def print(self):  # inorder 순회
        return self.__print(self.__root)

    def __print(self, tNode: TreeNode):
        if (tNode == None):
            return None
        self.__print(tNode.left)
        self.__form(tNode)
        self.__print(tNode.right)

    def save(self, fileName):
        f = open(fileName, 'w')
        f.truncate(0)  # 파일 초기화

        content = []
        self.__save(self.__root, content)

        for data in content:
            f.write('\t'.join(data))

        f.close()

    def __save(self, tNode: TreeNode, content):
        if (tNode == None):
            return None
        self.__save(tNode.left, content)
        content.append([tNode.name]+tNode.info)
        self.__save(tNode.right, content)

    def trace(self, x) -> list:
        path = self.__traceItem(self.__root, x, [])
        for name in path:
            print(name)

    def __traceItem(self, tNode: TreeNode, x, path):
        if (tNode == None):
            return None
        path.append(tNode.name)
        if x == tNode.name:
            return path
        elif x < tNode.name:
            return self.__traceItem(tNode.left, x, path)
        else:
            return self.__traceItem(tNode.right, x, path)

    def search(self, x) -> TreeNode:
        item = self.__searchItem(self.__root, x)
        if item != None:
            self.__form(item)
        else:
            print("찾는 사람이 없습니다.")

    def __searchItem(self, tNode: TreeNode, x) -> TreeNode:
        if (tNode == None):
            return None
        elif (x == tNode.name):
            return tNode
        elif (x < tNode.name):  # 삽입하려는 key가 현 노드보다 작으면
            return self.__searchItem(tNode.left, x)
        else:  # 삽입하려는 key가 현 노드보다 크면
            return self.__searchItem(tNode.right, x)

    def delete(self, x):
        self.__root = self.__deleteItem(self.__root, x)

    def __deleteItem(self, tNode: TreeNode, x) -> TreeNode:
        if (tNode == None):  # 삭제하려는 key가 존재하지 않음
            print("해당 사람은 존재하지 않습니다.")
            return None
        elif (x == tNode.name):  # 삭제하려는 key 찾음
            tNode = self.__deleteNode(tNode)
        elif (x < tNode.name):  # 삽입하려는 key가 현 노드보다 작으면
            tNode.left = self.__deleteItem(tNode.left, x)
        else:  # 삽입하려는 key가 현 노드보다 크면
            tNode.right = self.__deleteItem(tNode.right, x)
        return tNode

    def __deleteNode(self, tNode: TreeNode) -> TreeNode:
        # 1. tNode이 리프 노드
        if tNode.left == None and tNode.right == None: 
            return None
        # 2. tNode이 자식이 하나만 있음
        elif tNode.left == None:  # 오른자식뿐
            return tNode.right
        elif tNode.right == None:  # 왼자식뿐
            return tNode.left
        # 3. tNode이 자식이 둘 있음
        else:  
            (rtnName, rtnNode) = self.__deleteMinItem(tNode.right)
            tNode.name = rtnName
            tNode.right = rtnNode
            return tNode

    def __deleteMinItem(self, tNode: TreeNode) -> tuple:
        if tNode.left == None:
            return (tNode.name, tNode.right)
        else:
            (rtnName, rtnNode) = self.__deleteMinItem(tNode.left)
            tNode.left = rtnNode
            return (rtnName, tNode)

    def add(self, newName):
        if self.__searchItem(self.__root, newName) == None:
            company = input('Company?')
            address = input('Address?')
            zipcode = input('Zipcode?')
            phones = input('Phones?')
            email = input('Email?')
            [company, address, zipcode, email]
            self.__root = self.__insertItem(
                self.__root, newName, [company, address, zipcode, phones, email])
            print(newName, '은 성공적으로 추가 되었습니다.')
        else:
            print('해당 사람은 이미 존재합니다. 따라서 추가하지 않습니다.')


def read(input_):
    if input_[0] =='read':
        f = open(my_file_root+input_[1], 'r')
        data = list(csv.reader(f, delimiter="\t"))
        property = data[0][1:]
        name, info = [name[0] for name in data[1:]], [info[1:] for info in data[1:]]
        f.close()
    else:
        print("파일명을 잘 못 입력하셨습니다.")
    return property, name, info



input_ = list(input().split())
fileN = 1
while input_[0] != 'exit':
    if input_[0] == 'read':
        property, name, info = read(input_)
        BST = BinarySearchTree()  # 객체 생성
        for i in range(len(name)-1):  # data 이진 검색 트리에 집어넣기
            BST.insert(name[i], info[i])
    elif input_[0] == 'list':
        BST.print()
    elif input_[0] == 'find':
        BST.search(input_[1])
    elif input_[0] == 'add':
        BST.add(input_[1])
    elif input_[0] == 'delete':
        BST.delete(input_[1])
    elif input_[0] == 'trace':
        BST.trace(input_[1])
    elif input_[0] == 'save':
        fileN += 1
        BST.save('address_book',fileN,'.tsv')
    else: 
        print("입력이 잘못되었습니다. 다시 입력해주세요:")
    input_=list(input().split())