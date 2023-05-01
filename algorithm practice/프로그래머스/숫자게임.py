def solution(A, B):
    answer = -1
    A = sorted(A)
    B = sorted(B)
    
    #이진탐색
    fst = -1
    end = len(B)
    print(A,B,fst,end)

    # while fst <= end:
    #     mid = (fst + end) //2
    #     if A[mid] > B[mid]: end = mid -1
    #     else:   fst = mid +1
    #     print(mid,fst,end)
    # return answer

print(solution([5,1,3,7],[2,2,6,8]))

1357
2268