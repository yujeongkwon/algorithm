import math
N,K = map(int, input().split())

def fact(n):
    if n==1:
        return 1
    else:
        return n * fact(n-1)

n = fact(N)
d = fact(K)*fact(N-K)
print(n /d)

print(math.factorial(N) / (math.factorial(N-K)*math.factorial(K)))