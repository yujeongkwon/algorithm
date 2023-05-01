from itertools import combinations 

def binary(li, score):
    st = -1
    end = len(li)
    while st +1 < end:
        mid = (st + end) // 2
        if li[mid] < score: st = mid
        else:   end = mid
    return end

def solution(info, query):
    answer = []
    #info가 query에 들어갈 수 있는 모든 경우의 수를 dic에 저장
    dic ={}
    for i in info:  
        info_ = i.split()
        for j in range(5):  # 16가지의 경우의 수 = 키, 점수 = value
            for c in combinations(range(4),j):
                tmp_info = info_[:-1]
                
                for k in c:
                    tmp_info[k] = "-"
                    
                tmp_info = ''.join(tmp_info)
                
                if tmp_info in dic: dic[tmp_info].append(int(info_[-1]))
                else: dic[tmp_info] = [int(info_[-1])]   
    
    for v in dic.values():  v.sort()

    for q in query:
        q = q.replace(" and ", " ").split()
        key = ''.join(q[:-1])
        score_li = dic[key]
        if key in dic:    answer.append(len(score_li) - binary(score_li, int(q[-1])) )
        else:   answer.append(0)
    return answer

# from itertools import combinations 
# def binary(li,target):
#     # 항상 범위를 포함해야함 최소 0을 return할 수 있으면 left= -1,
#     #최대 n-1을 return할 수 있으면 right = n
#     left = -1
#     right = len(li)
#     while left +1 < right:
#         mid = (left+right) // 2
#         if li[mid] < target: left = mid
#         else:   right = mid
#     return right

# def solution(info, query):
#     answer = []
#     dic = {}
    
#     for i in info:
#         curInfo = i.split(' ')
#         for j in range(5):
#             for c in combinations(range(4),j):
#                 temp_info = curInfo[:-1]  #깊은 복사
#                 for m in c:
#                     temp_info[m] = '-'
#                 temp_info=''.join(temp_info)
#                 if temp_info in dic:    dic[temp_info].append(int(curInfo[-1]))
#                 else:   dic[temp_info] = [int(curInfo[-1])]
    
#     for v in dic.values():  v.sort()
    
#     for q in query:
#         temp = q.replace('and','').split()
#         queryKey = ''.join(temp[:-1])
#         queryScore = int(temp[-1])
#         if queryKey in dic:
#             n = binary(dic[queryKey],queryScore)
#             answer.append(len(dic[queryKey])-n)
#         else: answer.append(0)
#     return answer

print(solution(["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"],["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]))


#처음 코드
# def solution(info, query):
#     answer = [ 0 for i in range(len(query))]
    
#     infosplit = [ i.split(' ') for i in info ]
#     infosplit.sort(key = lambda x : int(x[-1]))
#     infosplit.reverse()
#     infoScore = [int(i.pop()) for i in infosplit]
#     querysplit = [ i.replace('and','').replace('-','').split() for i in query ]
    
#     for i in range(len(querysplit)):
#         q = querysplit[i].pop()
#         for j in range(len(infosplit)):
#             if int(q) <= infoScore[j]:
#                 if len(set(querysplit[i]) - set(infosplit[j])) == 0: answer[i] += 1
#             else: break
#     return answer