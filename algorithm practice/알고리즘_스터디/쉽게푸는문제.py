#첫번째 방법 무식하게 b까지 for문 돌면서 수열 리스트 생성 후, sum(list[a:b])
#   b가 1000까지라 시간제한 안걸림 
#두번째 방법 
#   수가 엄청 커지더라도 뭔가 빠르게 풀 수 있는 공식이 있을거같은데 -0-..
#   수열을 만드는 방법 대신 a번째 수가 무슨 숫자인지 알고 그 수 부터 b까지 사이 구하는 방법
#   생각안나서 걍 무식하게 함 방법이 없나 ㅇ9ㅇ?


a, b = map(int, input().split())
li = []
for i in range(1,b+1):
    li += [i]*i
print(sum(li[a-1:b]))

