A, B = input().split()

A = A.replace('6','5')
B = B.replace('6','5')
min_ = int(A) +int(B)

A = A.replace('5','6')
B = B.replace('5','6')
max_ = int(A) +int(B)

print(min_, max_)
