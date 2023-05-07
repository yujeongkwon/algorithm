N, M = map(int,input().split())
info = {}
for i in range(N+M):
    P,F,C = input().split()
    if P in info:
        pset,fset =info[P]
        if C == '1':  pset.add(F)
        else:   fset.add(F)
    else:
        if C == '1': info[P] = ({F},set())
        else:   info[P] = (set(),{F})

K = int(input())
move = []
for i in range(K):
    li = list(input().split())
    move.append([list(li[0].split('/'))[-1],list(li[1].split('/'))[-1]])

Q = int(input())
query = []
for i in range(Q):
    query.append(list(input().split('/')))

""" 파일 옮기기 """
for m in move:
    Lpset,Lfset = info[m[0]]
    Hpset,Hfset = info[m[1]]
    Hpset.update(Lpset)
    Hfset.update(Lfset)
    del info[m[0]]

''' 쿼리 읽기'''
def countPF(list):
    if len(info) == 0:
        return list(info[list][1]), len(info[list][1])
    else:
        files,fileN = {}, 0
        for li in list:
            f,n = countPF(info[li])
            files.update(f)
            fileN += N
        return len(files), n

for q in query:
    pset,fset = info[q[-1]]
    setN,fileN = countPF(list(pset))
    print(setN,fileN)


# { 전
#     'main': ({'FolderB', 'FolderA'}, set()),
#     'FolderA': (set(), {'File2', 'File1'}), 
#     'FolderB': ({'FolderC'}, {'File3', 'File1'}), 
#     'FolderC': (set(), {'File5', 'File4'})}

# { 후
#     'main': ({'FolderB', 'FolderA'}, set()), 
#     'FolderA': ({'FolderC'}, {'File2', 'File3', 'File1'}), 
#     'FolderC': (set(), {'File5', 'File4'})
#     }