n = int(input())
stack = []
result = []
flag = 0
num = 1

for i in range(n):
    seq = int(input())
    while num <= seq:
        stack.append(num)
        result.append("+")
        num += 1
    
    if stack[-1] == num:
        stack.pop()         
        result.append("-")
    else:
        print("NO")
        flag = 1
        break

if flag == 0:   
    for i in result:    print(i)

# import sys

# n = int(input())

# sequence = []
# stack_ = [1]
# for i in range(n):
#     sequence.append(int(input()))

# st = 0
# num = 2
# result = ["+"]


# while num <= n or stack_:
#     if stack_ and stack_[-1] == sequence[st]:   
#         stack_.pop()
#         result.append("-")
#         st += 1
#     else:
#         if stack_ and stack_[-1] > sequence[st]:
#             print("NO")
#             sys.exit(0)
#         while num <= sequence[st]:
#             result.append("+")
#             stack_.append(num)
#             num += 1
            


# if st < n -1:    print("NO")
# else:
#     for i in result:    print(i)
