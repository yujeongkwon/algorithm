
n = int(input())
li = []

for i in range(n):
    li.append(list(map(int, input().split())))

def quickSort(A, p, r):
    if p < r:
        q = partition1(A, p, r)
        quickSort(A, p, q-1)
        quickSort(A, q+1, r)

def partition1(A, p, r):
    tmp_left = []
    tmp_right = []
    pivot = A[r]
    for i in range(p, r):
        if A[i][0] < pivot[0]:
            tmp_left.append(A[i])
        elif A[i][0] > pivot[0]:
            tmp_right.append(A[i])
        else:
            if A[i][1] < pivot[1]:
                tmp_left.append(A[i])
            else:
                tmp_right.append(A[i])

    for i in range(0, len(tmp_left)):
        A[p+i] = tmp_left[i]
    A[p+len(tmp_left)] = pivot
    for j in range(0, len(tmp_right)):
        A[p+len(tmp_left)+1+j] = tmp_right[j]
    return p+len(tmp_left)

quickSort(li, 0, n-1)
print(li)
# 5
# 5 9
# -2 3
# 5 7
# 0 3
# -2 7