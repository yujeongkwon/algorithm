import pandas as pd
import time
import random


#선택 정렬
def selectionSort(A):
    for last in range(len(A)-1, 2, -1):
        k = theLargest(A, last)
        A[k], A[last] = A[last], A[k]

def theLargest(A, last: int):
    largest = 0
    for i in range(last+1):
        if A[i] > A[largest]:
            largest = i
    return largest

#버블 정렬
def bubbleSort(A):
    for numElements in range(len(A), 2, -1):
        for i in range(numElements-1):
            if A[i] > A[i+1]:
                A[i], A[i+1] = A[i+1], A[i]


#삽입 정렬
def insertionSort(A):
    for i in range(1, len(A)):
        loc = i-1
        newItem = A[i]
        while loc >= 0 and newItem < A[loc]:
            A[loc+1] = A[loc]
            loc -= 1
        A[loc+1] = newItem


#병합 정렬
def mergeSort(A, p: int, r: int):
    if p < r:
        q = (p + r) // 2
        mergeSort(A, p, q)
        mergeSort(A, q+1, r)
        merge(A, p, q, r)


def merge(A, p: int, q: int, r: int):
    i = p
    j = q + 1
    t = 0
    tmp = [0 for i in range(len(A))]
    while i <= q and j <= r:
        if A[i] <= A[j]:
            tmp[t] = A[i]
            t += 1
            i += 1
        else:
            tmp[t] = A[j]
            t += 1
            j += 1
    while i <= q:
        tmp[t] = A[i]
        t += 1
        i += 1
    while j <= r:
        tmp[t] = A[j]
        t += 1
        j += 1
    i = p
    t = 0
    while i <= r:
        A[i] = tmp[t]
        t += 1
        i += 1


#빠른 정렬 - 마지막 값을 피봇으로 선택
def quickSort1(A, p: int, r: int):
    if p < r:
        q = partition1(A, p, r)
        quickSort1(A, p, q-1)
        quickSort1(A, q+1, r)


def partition1(A, p: int, r: int):
    tmp_left = []
    tmp_right = []
    pivot = A[r]
    for i in range(p, r):
        if A[i] < pivot:
            tmp_left.append(A[i])
        elif A[i] > pivot:
            tmp_right.append(A[i])
    for i in range(0, len(tmp_left)):
        A[p+i] = tmp_left[i]
    A[p+len(tmp_left)] = pivot
    for j in range(0, len(tmp_right)):
        A[p+len(tmp_left)+1+j] = tmp_right[j]
    return p+len(tmp_left)


#빠른 정렬 - 첫 번째 값, 가운데 위치의 값, 그리고 마지막 값 중에서 중간값을 피봇으로 선택
def quickSort2(A, p: int, r: int):
    if p < r:
        q = partition2(A, p, r)
        quickSort2(A, p, q-1)
        quickSort2(A, q+1, r)


def partition2(A, p: int, r: int):
    tmp_left = []
    tmp_right = []
    if r-p <= 1:
        pivot = A[r]
    else:
        if (A[p] >= A[r] >= A[(p+r)//2]) or (A[(p+r)//2] >= A[r] >= A[p]):
            pivot = A[r]
        elif (A[r] >= A[p] >= A[(p+r)//2]) or (A[(p+r)//2] >= A[p] >= A[r]):
            pivot = A[p]
        else:
            pivot = A[(p+r)//2]
    for i in range(p, r+1):
        if A[i] < pivot:
            tmp_left.append(A[i])
        elif A[i] > pivot:
            tmp_right.append(A[i])
    for i in range(0, len(tmp_left)):
        A[p+i] = tmp_left[i]
    A[p+len(tmp_left)] = pivot
    for j in range(0, len(tmp_right)):
        A[p+len(tmp_left)+1+j] = tmp_right[j]
    return p+len(tmp_left)


#빠른 정렬 - 피봇을 랜덤하게 선택
def quickSort3(A, p: int, r: int):
    if p < r:
        q = partition3(A, p, r)
        quickSort3(A, p, q-1)
        quickSort3(A, q+1, r)


def partition3(A, p: int, r: int):
    tmp_left = []
    tmp_right = []
    pivot = A[random.randrange(p, r+1)]
    for i in range(p, r+1):
        if A[i] < pivot:
            tmp_left.append(A[i])
        elif A[i] > pivot:
            tmp_right.append(A[i])
    for i in range(0, len(tmp_left)):
        A[p+i] = tmp_left[i]
    A[p+len(tmp_left)] = pivot
    for j in range(0, len(tmp_right)):
        A[p+len(tmp_left)+1+j] = tmp_right[j]
    return p+len(tmp_left)


#힙 정렬
def maxHeapify(A, n, i):
    largest = i
    child_left = 2*i + 1
    child_right = 2*i + 2

    if (child_left < n and A[child_left] > A[largest]):
        largest = child_left

    if (child_right < n and A[child_right] > A[largest]):
        largest = child_right

    if largest != i:
        A[i], A[largest] = A[largest], A[i]
        maxHeapify(A, n, largest)


def heapSort(A):
    n = len(A)

    for i in range(n//2-1, -1, -1):
        maxHeapify(A, n, i)

    for i in range(n-1, 0, -1):
        A[i], A[0] = A[0], A[i]
        maxHeapify(A, i, 0)

    return A


#알고리즘 별 평균 시간복잡도 구하기
def FindTime(N):
    Time_Set = []
    A = []
    for i in range(N+1):
        A.append(random.randrange(1, N+1))
    Time_1 = 0

    # 리스트에 함수와 파라미터를 저장
    funcs = [(bubbleSort, A), (selectionSort, A), (insertionSort, A), (mergeSort, A, 0, N-1),
            (quickSort1, A, 0, N-1), (quickSort2, A, 0, N-1), (quickSort3, A, 0, N-1), (heapSort, A), (sorted, A)]

    # 인덱스에 따라 함수와 파라미터를 호출하는 for문
    for i, (func, *args) in enumerate(funcs):
        for i in range(10):  # 라이브러리
            start = time.time()
            func(*args)  # 함수를 호출하면서 파라미터를 전달
            end = time.time()
            Time_1 += (end - start)/10
            random.shuffle(A)
            if i == 9:
                Time_Set.append(Time_1)
                Time_1 = 0

    return Time_Set


#테이블 만들기
data = {
    'N=1000': FindTime(10),
    # 'N=10000': FindTime(10000),
    # 'N=100000': FindTime(100000)
}
df = pd.DataFrame(data, index=['Bubble', 'Selection',
                'Insertion', 'Merge', 'Quick1', 'Quick2', 'Quick3', 'HeapSort', 'Library'])
print(df)
