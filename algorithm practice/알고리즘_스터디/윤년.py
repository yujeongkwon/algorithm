# 4의 배수, 100의 배수X, 400의 배수
year = int(input())

if year%400 ==0:
    print(1)
else:
    if year%4==0 and year%100 !=0:
        print(1)
    else:
        print(0)