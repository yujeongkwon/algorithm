from collections import defaultdict

X = ['A','B','A','C','D','B','C']
k = 4

answer, dic, cnt = [], defaultdict(int), 0
for i in range(len(X)):
    dic[X[i]] += 1
    if dic[X[i]] == 1:
        cnt += 1

    if i >= k - 1:
        answer.append(cnt)
        dic[X[i-k+1]] -= 1
        if not dic[X[i-k+1]]:
            cnt -= 1
    
print(answer)

#시간복잡도 O(n)


# A = list(map(int,input().split()))
# k = int(input())
# h = {}
# cnt = 0
# result = []

# for i in range(k):
#     if A[i] not in h:
#         cnt += 1
#         h[A[i]] = 0
#     h[A[i]] += 1
# result.append(cnt)

# for i in range(len(A)-k):
#     h[A[i]] -= 1
#     if h[A[i]] == 0:
#         cnt -= 1
#         del h[A[i]]
#     if A[i+k] not in h:
#         cnt += 1
#         h[A[i+k]] = 0
#     h[A[i+k]] += 1
#     result.append(cnt)
# print(result)


# A = list(map(int,input().split()))
# k = int(input())
# result = []

# for i in range(len(A) - k + 1):
#     distinct_count = len(set(A[i:i+k]))  # 구간 내 서로 다른 정수의 개수를 계산
#     result.append(distinct_count)

# print(result)