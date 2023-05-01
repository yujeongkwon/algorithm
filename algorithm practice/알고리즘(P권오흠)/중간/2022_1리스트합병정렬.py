def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def merge(left, right):
    result = []
    i, j = 0, 0
    while i < len(left) and j < len(right):
        if sum(left[i]) <= sum(right[j]):
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i:]
    result += right[j:]
    return result

N = int(input())
scores = []
for i in range(N):
    mid, final, assignment = map(int, input().split())
    scores.append((mid, final, assignment))

sorted_scores = merge_sort(scores)

for score in sorted_scores:
    print(score[0], score[1], score[2])