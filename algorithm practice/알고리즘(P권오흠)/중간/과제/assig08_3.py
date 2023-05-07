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